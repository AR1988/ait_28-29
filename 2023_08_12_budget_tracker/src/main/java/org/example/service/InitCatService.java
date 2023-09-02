package org.example.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.entity.Category;
import org.example.entity.SubCategory;
import org.example.utils.CategoryJson;
import org.example.utils.SubCategoryJson;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author Andrej Reutow
 * created on 26.08.2023
 */
public class InitCatService {

    private final CategoryService categoryService;
    private final SubCategoryService subCategoryService;
    private final ObjectMapper objectMapper;

    public InitCatService(CategoryService categoryService, SubCategoryService subCategoryService) {
        this.categoryService = categoryService;
        this.subCategoryService = subCategoryService;
        this.objectMapper = new ObjectMapper();
    }

    public List<Category> initCategory(Collection<CategoryJson> jsonsLine) {

        List<Category> result = new ArrayList<>();
        for (CategoryJson categoryJson : jsonsLine) {
            Category savedCat = categoryService.save(new Category(categoryJson.getName()));
            for (SubCategoryJson subCategoryJson : categoryJson.getSubCategories()) {
                SubCategory savedSubCat = subCategoryService.save(new SubCategory(subCategoryJson.getName()));
                categoryService.addSubcategory(savedCat, savedSubCat);
            }

            result.add(savedCat);
        }

        return result;
    }

    public List<CategoryJson> readJson(String fileName) throws IOException {
        return objectMapper.readValue(new FileReader(fileName), new TypeReference<List<CategoryJson>>() {
        });
    }
}

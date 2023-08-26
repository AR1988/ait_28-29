package org.example;

import org.example.etity.Category;
import org.example.etity.EntityEnum;
import org.example.repository.impl.CategoryRepository;
import org.example.repository.impl.SubCategoryRepository;
import org.example.service.CategoryService;
import org.example.service.InitCatService;
import org.example.service.InitDBService;
import org.example.service.SubCategoryService;
import org.example.utils.CategoryJson;

import java.io.IOException;
import java.util.List;

public class Main {


    public static void main(String[] args) throws IOException {
        SubCategoryRepository subCategoryRepository = new SubCategoryRepository(EntityEnum.SUB_CATEGORY);
        SubCategoryService subCategoryService = new SubCategoryService(subCategoryRepository);

        CategoryRepository categoryRepository = new CategoryRepository(EntityEnum.CATEGORY);
        CategoryService categoryService = new CategoryService(categoryRepository, subCategoryService);


        InitDBService initDBService = new InitDBService();
        initDBService.initDb();

        InitCatService initCatService = new InitCatService(categoryService, subCategoryService);

        List<CategoryJson> categoryJsons = initCatService.readJson("category_init.json");
        List<Category> category = initCatService.initCategory(categoryJsons);
    }
}

package org.example;

import org.example.entity.Category;
import org.example.service.CategoryService;
import org.example.service.InitCatService;
import org.example.service.InitDBService;
import org.example.service.SubCategoryService;
import org.example.utils.CategoryJson;

import java.io.IOException;
import java.util.List;

import static org.example.service.ServiceFactory.*;

public class Main {


    public static void main(String[] args) throws IOException {
        SubCategoryService subCategoryService = getSubCategoryService();
        CategoryService categoryService = getCategoryService(subCategoryService);
        InitDBService initDBService = getInitDBService();
        InitCatService initCatService = getInitCatService(categoryService, subCategoryService);

        initDBService.initDb();

        List<CategoryJson> categoryJsons = initCatService.readJson("category_init.json");
        List<Category> category = initCatService.initCategory(categoryJsons);
    }
}

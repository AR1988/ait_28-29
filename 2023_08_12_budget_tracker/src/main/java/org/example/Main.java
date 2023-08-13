package org.example;

import org.example.etity.EntityEnum;
import org.example.etity.SubCategory;
import org.example.repository.impl.SubCategoryRepository;
import org.example.service.InitService;
import org.example.service.SubCategoryService;

import java.io.IOException;

public class Main {


    public static void main(String[] args) throws IOException {
        InitService initService = new InitService();
        initService.initDb();

        SubCategoryRepository subCategoryRepository = new SubCategoryRepository(EntityEnum.SUB_CATEGORY);
        SubCategoryService categoryService = new SubCategoryService(subCategoryRepository);

        for (int i = 0; i < 5; i++) {
            SubCategory subCategory = new SubCategory();
            subCategory.setName("Счет " + i);

            System.out.println(subCategory);
            SubCategory save = categoryService.save(subCategory);
            System.out.println(save);
        }
    }
}

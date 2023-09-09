package org.example.example.service;

import org.example.entity.EntityEnum;
import org.example.repository.impl.CategoryRepository;
import org.example.repository.impl.SubCategoryRepository;
import org.example.repository.impl.TransactionRepository;
import org.example.service.CategoryService;
import org.example.service.InitCatService;
import org.example.service.InitDBService;
import org.example.service.SubCategoryService;
import org.example.service.TransactionService;

import static java.util.Objects.requireNonNull;

/**
 * @author Andrej Reutow
 * created on 02.09.2023
 */
public class ServiceFactory {

    public static SubCategoryService getSubCategoryService() {
        SubCategoryRepository subCategoryRepository = new SubCategoryRepository(EntityEnum.SUB_CATEGORY);
        return new SubCategoryService(subCategoryRepository);
    }

    public static CategoryService getCategoryService(SubCategoryService subCategoryService) {
//        if (subCategoryService == null) {
//            throw new NullPointerException("SubCategoryService is null");
//        }
        requireNonNull(subCategoryService, "SubCategoryService is null");

        CategoryRepository categoryRepository = new CategoryRepository(EntityEnum.CATEGORY);
        return new CategoryService(categoryRepository, subCategoryService);
    }

    public static org.example.service.InitCatService getInitCatService(CategoryService categoryService, SubCategoryService subCategoryService) {
        return new InitCatService(categoryService, subCategoryService);
    }

    public static InitDBService getInitDBService() {
        return new InitDBService();
    }

    public static org.example.service.TransactionService getTransactionService(SubCategoryService subCategoryService) {
        TransactionRepository categoryRepository = new TransactionRepository(EntityEnum.TRANSACTION);
        return new TransactionService(categoryRepository, subCategoryService);
    }
}

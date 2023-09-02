package org.example.service;

import org.example.entity.EntityEnum;
import org.example.repository.impl.CategoryRepository;
import org.example.repository.impl.SubCategoryRepository;
import org.example.repository.impl.TransactionRepository;

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

    public static InitCatService getInitCatService(CategoryService categoryService, SubCategoryService subCategoryService) {
        return new InitCatService(categoryService, subCategoryService);
    }

    public static InitDBService getInitDBService() {
        return new InitDBService();
    }

    public static TransactionService getTransactionService(SubCategoryService subCategoryService) {
        TransactionRepository categoryRepository = new TransactionRepository(EntityEnum.TRANSACTION);
        return new TransactionService(categoryRepository, subCategoryService);
    }
}

package org.example.service;

import org.example.entity.SubCategory;
import org.example.entity.Transaction;
import org.example.repository.impl.TransactionRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @author Andrej Reutow
 * created on 02.09.2023
 */
public class TransactionService {

    private final TransactionRepository transactionRepository;
    private final SubCategoryService subCategoryService;
    private final CategoryService categoryService;

    public TransactionService(TransactionRepository transactionRepository,
                              SubCategoryService subCategoryService, CategoryService categoryService) {
        this.subCategoryService = subCategoryService;
        this.transactionRepository = transactionRepository;
        this.categoryService = categoryService;
    }

    public Transaction save(Transaction transaction, long subCategoryId) {
        SubCategory subCategory = subCategoryService.getById(subCategoryId);
        transaction.setSubCategory(subCategory);
        transactionRepository.persist(transaction);
        return transaction;
    }

    public List<Transaction> findAll() {
        return transactionRepository.findAll();
    }

    public List<Transaction> findAllBySubcategory(long subCategoryId) {
        SubCategory subCategory = subCategoryService.getById(subCategoryId);
        return findAll().stream().filter(tr -> tr.getSubCategory().equals(subCategory)).toList();
//        return findAll().stream().filter(tr -> tr.getSubCategory().getId().equals(subCategoryId)).toList();
    }

    public List<Transaction> findAllByCategory(long categoryId) {
        Set<SubCategory> subCategories = categoryService.getById(categoryId).getSubCategories();

        List<Transaction> transactionsResult = new ArrayList<>();
        for (SubCategory subCategory : subCategories) {
            transactionsResult.addAll(findAllBySubcategory(subCategory.getId()));
        }

//        List<Transaction> transactions = findAll();
//        for (SubCategory subCategory : subCategories) {
//            for (Transaction transaction : transactions) {
//                if (transaction.getSubCategory().equals(subCategory)) {
//                    transactionsResult.add(transaction);
//                }
//            }
//        }
        return transactionsResult;
    }

    public List<Transaction> findAllBySubcategoryAndDate(LocalDateTime from, LocalDateTime to, long subCategoryId) {
        List<Transaction> allBySubcategory = findAllBySubcategory(subCategoryId);
        return allBySubcategory.stream().filter(subCat -> subCat.getDate().isAfter(from) && subCat.getDate().isBefore(to)).toList();
    }

    public List<Transaction> findAllByCategoryAndDate(LocalDateTime from, LocalDateTime to, long categoryId) {
        List<Transaction> allByCategory = findAllByCategory(categoryId);

        return allByCategory.stream().filter(cat -> cat.getDate().isAfter(from) && cat.getDate().isBefore(to)).toList();
    }
}

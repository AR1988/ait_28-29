package org.example.service;

import org.example.entity.SubCategory;
import org.example.entity.Transaction;
import org.example.repository.impl.TransactionRepository;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

/**
 * @author Andrej Reutow
 * created on 02.09.2023
 */
public class TransactionService {

    private final TransactionRepository transactionRepository;
    private final SubCategoryService subCategoryService;

    public TransactionService(TransactionRepository transactionRepository,
                              SubCategoryService subCategoryService) {
        this.subCategoryService = subCategoryService;
        this.transactionRepository = transactionRepository;
    }

    public Transaction save(Transaction transaction, long subCategoryId) {
        SubCategory subCategory = subCategoryService.getById(subCategoryId);
        transaction.setSubCategory(subCategory);
        transactionRepository.persist(transaction);
        return transaction;
    }

    public List<Transaction> findAll() {
        return Collections.emptyList();
    }

    public List<Transaction> findAllBySubcategory(long subCategoryId) {
        return Collections.emptyList();
    }

    public List<Transaction> findAllByCategory(long categoryId) {
        return Collections.emptyList();
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

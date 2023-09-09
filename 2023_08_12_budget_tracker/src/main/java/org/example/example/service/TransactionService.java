package org.example.example.service;

import org.example.entity.SubCategory;
import org.example.entity.Transaction;
import org.example.repository.impl.TransactionRepository;
import org.example.service.CategoryService;
import org.example.service.SubCategoryService;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.example.service.ServiceFactory.getCategoryService;

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
        List<Transaction> transactions = transactionRepository.finAll();
        return transactions;//Collections.emptyList();
    }
//
    public Transaction finById(long transactionId) {
        List<Transaction> transactions = findAll();
        for (Transaction transaction: transactions) {
            if (transaction.getId().equals(transactionId)) {
               return transaction;
            }
        }
        return null;
    }

    public List<Transaction> findAllBySubcategory(long subCategoryId) {
        List<Transaction> transactions = findAll();
//        List<Transaction> transactionsBySubCategories = new ArrayList<>();
//        for (Transaction transaction: transactions) {
//            SubCategory subCategory = transaction.getSubCategory();
//            if (subCategory.getId().equals(subCategoryId)) {
//                transactionsBySubCategories.add(transaction);
//            }
//        }
      //  return transactionsBySubCategories;
      return transactions.stream()
              .filter(subCat->subCat.getSubCategory().getId().equals(subCategoryId)).toList();
    }


    public List<Transaction> findAllByCategory(long categoryId) {
        CategoryService categoryService = getCategoryService(subCategoryService);
        Set<SubCategory> subCategories  = categoryService.getAllSubCategoryBy(categoryId);
        List<Transaction> transactionsByCategoryID = new ArrayList<>();
        for (SubCategory subCategory :subCategories) {
                 transactionsByCategoryID.addAll(findAllBySubcategory(subCategory.getId()));
        }
        return transactionsByCategoryID;
    }


    public List<Transaction> findAllBySubcategoryAndDate(LocalDateTime from, LocalDateTime to, long subCategoryId) {
        List<Transaction> allBySubcategory = findAllBySubcategory(subCategoryId);
        return allBySubcategory.stream().filter(subCat -> subCat.getDate().isAfter(from) && subCat.getDate().isBefore(to)).toList();
    }



    public List<Transaction> findAllByCategoryAndDate(LocalDateTime from, LocalDateTime to, long categoryId) {
        List<Transaction> allByCategory = findAllByCategory(categoryId);
        return allByCategory.stream().filter(cat -> cat.getDate().isAfter(from) && cat.getDate().isBefore(to)).toList();
    }
    public void Print(List<Transaction> transactions) {
        for (Transaction transaction: transactions) {
            System.out.println(transaction.toString());
            }

    }
}

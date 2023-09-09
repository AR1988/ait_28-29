package org.example;

import org.example.entity.Category;
import org.example.entity.SubCategory;
import org.example.entity.Transaction;
import org.example.service.*;
import org.example.utils.CategoryJson;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

import static org.example.service.ServiceFactory.*;

public class Main {


    public static void main(String[] args) throws IOException {
        SubCategoryService subCategoryService = getSubCategoryService();
        CategoryService categoryService = getCategoryService(subCategoryService);
        InitDBService initDBService = getInitDBService();
        InitCatService initCatService = getInitCatService(categoryService, subCategoryService);
        TransactionService transactionService = getTransactionService(subCategoryService);

        initDBService.initDb();
//
        List<CategoryJson> categoryJsons = initCatService.readJson("category_init.json");
        initCatService.initCategory(categoryJsons);


        List<Category> categoryList = categoryService.getAll();
        Set<SubCategory> subCategoryList = subCategoryService.getAll(categoryList.get(0));

        for (int i = 3; i < 14; i++) {
            Transaction transaction = new Transaction(
                    LocalDateTime.now(),
                    BigDecimal.valueOf(78.97)
            );
            transactionService.save(transaction, i);
        }

        System.out.println("Print result: transactionService.findAll() ");
        List<Transaction> transactions=transactionService.findAll();
        transactionService.Print(transactions);

        System.out.println("Print result: transactionService.finById(3) ");
        Transaction transaction=transactionService.finById(3);
        System.out.println(transaction);

        System.out.println("Print result:  transactionService.findAllBySubcategory(3) ");
        transactions=transactionService.findAllBySubcategory(3);
        transactionService.Print(transactions);

        System.out.println("Print result:  transactionService.findAllByCategory(1) ");
        transactions=transactionService.findAllByCategory(1);
        transactionService.Print(transactions);

        System.out.println("Print result:  transactionService.findAllBySubcategoryAndDate(1) ");
        transactions=transactionService.findAllBySubcategoryAndDate(LocalDateTime.now().minusDays(3),LocalDateTime.now().plusDays(3),3);
        transactionService.Print(transactions);

        System.out.println("Print result:  transactionService.findAllByCategoryAndDate ");
        transactions=transactionService.findAllByCategoryAndDate(LocalDateTime.now().minusDays(3),LocalDateTime.now().plusDays(3),1);
        transactionService.Print(transactions);
    }
}

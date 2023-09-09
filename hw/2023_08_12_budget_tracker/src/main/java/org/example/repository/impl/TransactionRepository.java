package org.example.repository.impl;

import org.example.Constants;
import org.example.entity.Category;
import org.example.entity.EntityEnum;
import org.example.entity.Transaction;
import org.example.parser.Parser;
import org.example.parser.impl.CategoryParser;
import org.example.parser.impl.TransactionParser;
import org.example.repository.Repository;
import org.example.service.SubCategoryService;

import java.io.File;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static org.example.service.ServiceFactory.getSubCategoryService;

/**
 * @author Andrej Reutow
 * created on 02.09.2023
 */
public class TransactionRepository extends Repository<Transaction> {

    /**
     * Конструктор класса Repository.
     *
     * @param entityEnum Тип сущности, с которой работает данный репозиторий.
     */
    public TransactionRepository(EntityEnum entityEnum) {
        super(entityEnum);
    }

    @Override
    protected String entityToDbString(Transaction entity) {
        Objects.requireNonNull(entity.getSubCategory());
        return entity.getId() +
                Constants.CSV_DELIMITER +

                entity.getDate().format(Constants.CSV_DATA_TIME_FORMATTER) +
                Constants.CSV_DELIMITER +

                entity.getAmount().setScale(2, RoundingMode.UNNECESSARY) +
                Constants.CSV_DELIMITER +

                entity.getSubCategory().getId() +
                Constants.CSV_DELIMITER;
    }

    @Override
    public List<Transaction> finAll() {
        //todo  return null;
        File file = entityEnum.getTablePath().toFile();
        List<String> stringList = fileService.readFile(file.getAbsolutePath());
        SubCategoryService subCategoryService = getSubCategoryService();
        Parser<Transaction> parser = new TransactionParser(subCategoryService);

        List<Transaction> transactions = new ArrayList<>();

        for (int i = 1; i < stringList.size(); i++) {
            String line = stringList.get(i);
            if (!line.isEmpty()) {
                transactions.add(parser.parse(line));
            }
        }

        return transactions;
    }
}

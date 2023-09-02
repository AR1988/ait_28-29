package org.example.repository.impl;

import org.example.Constants;
import org.example.entity.EntityEnum;
import org.example.entity.Transaction;
import org.example.repository.Repository;

import java.math.RoundingMode;
import java.util.List;
import java.util.Objects;

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
    protected List<Transaction> finAll() {
        return null;
    }
}

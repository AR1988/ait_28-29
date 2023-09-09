package org.example.example.parser.impl;

import org.example.Constants;
import org.example.entity.Transaction;
import org.example.parser.Parser;
import org.example.service.SubCategoryService;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.example.Constants.CSV_DATA_TIME_FORMATTER;

public class TransactionParser implements Parser<Transaction> {
    private SubCategoryService subCategoryService;

    public TransactionParser(SubCategoryService subCategoryService) {
        this.subCategoryService = subCategoryService;
    }

    /**
     * Преобразует строку CSV в объект типа Transaction.
     *
     * @param line Строка CSV для разбора.
     * @return Объект типа Transaction, созданный из строки.
     * @throws NumberFormatException          Если встретится ошибка при преобразовании числа из строки.
     * @throws ArrayIndexOutOfBoundsException Если количество элементов после разбора строки не соответствует ожидаемому.
     */
    @Override
    public Transaction parse(String line) {
        String[] split = line.split(Constants.CSV_DELIMITER, -1);
        //DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyy HH:mm:ss");
        Transaction transaction = new Transaction(Long.valueOf(split[0]),
                LocalDateTime.parse(split[1], CSV_DATA_TIME_FORMATTER), BigDecimal.valueOf(Double.parseDouble(split[2])), subCategoryService.getById(Long.valueOf(split[3])));
        return transaction;

    }
}

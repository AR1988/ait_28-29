package org.example;

import java.time.format.DateTimeFormatter;

/**
 * Класс Constants содержит набор констант, используемых в приложении.
 */
public class Constants {

    /**
     * Директория для хранения базы данных.
     */
    public static final String DB_SOURCE_DIR = "db-prod-2";

    /**
     * Имена директории и файлов для хранения транзакций.
     */
    public static final String DB_TRANSACTION_DIR_NAME = "транзакции";
    public static final String DB_TRANSACTION_TABLE_NAME = "transaction.csv";
    public static final String DB_TRANSACTION_CATEGORY_REF_TABLE_NAME = "transaction_category.csv";

    /**
     * Имена директории и файлов для хранения категорий.
     */
    public static final String DB_CATEGORY_DIR_NAME = "category";
    public static final String DB_CATEGORY_TABLE_NAME = "category.csv";
    public static final String DB_CATEGORY_SUBCATEGORY_REF_TABLE_NAME = "category_subcategory.csv";

    /**
     * Имена директории и файла для хранения подкатегорий.
     */
    public static final String DB_SUB_CATEGORY_DIR_NAME = "sub_category";
    public static final String DB_SUB_TABLE_NAME = "sub_category.csv";

    /**
     * Имя файла для хранения первичных ключей.
     */
    public static final String DB_KEY_TABLE_NAME = "prime_key.csv";

    /**
     * Разделитель для CSV файлов.
     */
    public static final String CSV_DELIMITER = ";";

    /**
     * Формат для представления даты и времени в CSV файлах.
     */
    public static final String CSV_DATA_TIME_FORMAT = "dd.MM.yyy HH:mm:ss";

    /**
     * Форматтер для преобразования даты и времени в строку согласно CSV_DATA_TIME_FORMAT.
     */
    public static final DateTimeFormatter CSV_DATA_TIME_FORMATTER = DateTimeFormatter.ofPattern(CSV_DATA_TIME_FORMAT);

}

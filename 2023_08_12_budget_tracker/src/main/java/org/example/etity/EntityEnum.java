package org.example.etity;

import java.nio.file.Path;

import static org.example.Constants.*;

/**
 * Перечисление, представляющее типы сущностей и их пути к файлам.
 */
public enum EntityEnum {

    TRANSACTION(
            Path.of(DB_SOURCE_DIR, DB_TRANSACTION_DIR_NAME, DB_KEY_TABLE_NAME),
            Path.of(DB_SOURCE_DIR, DB_TRANSACTION_DIR_NAME, DB_TRANSACTION_TABLE_NAME),
            Path.of(DB_SOURCE_DIR, DB_TRANSACTION_DIR_NAME, DB_TRANSACTION_CATEGORY_REF_TABLE_NAME)),

    CATEGORY(Path.of(DB_SOURCE_DIR, DB_CATEGORY_DIR_NAME, DB_KEY_TABLE_NAME),
            Path.of(DB_SOURCE_DIR, DB_CATEGORY_DIR_NAME, DB_CATEGORY_TABLE_NAME),
            Path.of(DB_SOURCE_DIR, DB_CATEGORY_DIR_NAME, DB_CATEGORY_SUBCATEGORY_REF_TABLE_NAME)),

    SUB_CATEGORY(Path.of(DB_SOURCE_DIR, DB_SUB_CATEGORY_DIR_NAME, DB_KEY_TABLE_NAME),
            Path.of(DB_SOURCE_DIR, DB_SUB_CATEGORY_DIR_NAME, DB_SUB_TABLE_NAME),
            Path.of(DB_SOURCE_DIR, DB_CATEGORY_DIR_NAME, DB_CATEGORY_SUBCATEGORY_REF_TABLE_NAME));

    private final Path keyTablePath;
    private final Path tablePath;
    private final Path referencePath;

    /**
     * Конструктор класса EntityEnum.
     *
     * @param keyTablePath  Путь к таблице с ключами.
     * @param tablePath     Путь к таблице с данными.
     * @param referencePath Путь к таблице с ссылками.
     */
    EntityEnum(Path keyTablePath, Path tablePath, Path referencePath) {
        this.keyTablePath = keyTablePath;
        this.tablePath = tablePath;
        this.referencePath = referencePath;
    }

    /**
     * Возвращает путь к таблице с ключами.
     *
     * @return Путь к таблице с ключами.
     */
    public Path getKeyTablePath() {
        return keyTablePath;
    }

    /**
     * Возвращает путь к таблице с данными.
     *
     * @return Путь к таблице с данными.
     */
    public Path getTablePath() {
        return tablePath;
    }

    /**
     * Возвращает путь к таблице с ссылками.
     *
     * @return Путь к таблице с ссылками.
     */
    public Path getReferencePath() {
        return referencePath;
    }
}

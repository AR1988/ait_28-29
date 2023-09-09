package org.example.service;

import org.example.Constants;
import org.example.entity.EntityEnum;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Сервис для инициализации базы данных и файловой структуры.
 */
public class InitDBService {

    private final FileService fileService = new FileService();


    /**
     * Инициализирует базу данных и файловую структуру.
     *
     * @throws IOException Если произошла ошибка при создании файлов и директорий.
     */
    public void initDb() throws IOException {
        String dbSourceDir = Constants.DB_SOURCE_DIR;
        initDb(dbSourceDir);
    }

    public void initTestDb() throws IOException {
        String dbSourceDir = Constants.DB_TEST_SOURCE_DIR;
        initDb(dbSourceDir);
    }

    private void initDb(String sourcePath) throws IOException {
        Path dbRootPath = Path.of(sourcePath);

        Path categoryDbPath = dbRootPath.resolve(Constants.DB_CATEGORY_DIR_NAME);
        Path subCategoryDbPath = dbRootPath.resolve(Constants.DB_SUB_CATEGORY_DIR_NAME);
        Path transactionDbPath = dbRootPath.resolve(Constants.DB_TRANSACTION_DIR_NAME);

        fileService.createDirectory(dbRootPath);
        fileService.createDirectory(categoryDbPath);
        fileService.createDirectory(subCategoryDbPath);
        fileService.createDirectory(transactionDbPath);

        for (EntityEnum entityEnum : EntityEnum.values()) {
            Path referencePath = entityEnum.getReferencePath();
            Path tablePath = entityEnum.getTablePath();
            Path keyTablePath = entityEnum.getKeyTablePath();

            if (referencePath != null) {
                fileService.createFile(referencePath);
            }
            fileService.createFile(tablePath);
            fileService.createFile(keyTablePath);

            if (entityEnum.equals(EntityEnum.CATEGORY) || entityEnum.equals(EntityEnum.SUB_CATEGORY)) {
                Files.writeString(referencePath, "CATEGORY_ID;SUBCATEGORY_ID;");
                Files.writeString(tablePath, "ID;NAME;");
            }

            if (entityEnum.equals(EntityEnum.TRANSACTION)) {
                Files.writeString(tablePath, "ID;DATE;AMOUNT;SUB_CATEGORY_ID;");
            }
            Files.writeString(keyTablePath, "ID;CREATED_AT;");
        }
    }
}

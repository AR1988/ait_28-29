package org.example.service;

import org.example.Constants;
import org.example.etity.EntityEnum;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

/**
 * Сервис для инициализации базы данных и файловой структуры.
 */
public class InitService {

    private final FileService fileService = new FileService();

    /**
     * Инициализирует базу данных и файловую структуру.
     *
     * @throws IOException Если произошла ошибка при создании файлов и директорий.
     */
    public void initDb() throws IOException {
        String dbSourceDir = Constants.DB_SOURCE_DIR;
        Path dbRootPath = Path.of(dbSourceDir);

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

            fileService.createFile(referencePath);
            fileService.createFile(tablePath);
            fileService.createFile(keyTablePath);

            if (entityEnum.equals(EntityEnum.CATEGORY) || entityEnum.equals(EntityEnum.SUB_CATEGORY)) {
                Files.write(referencePath, List.of("CATEGORY_ID; SUBCATEGORY_ID;"));
                Files.write(tablePath, List.of("ID; NAME;"));
            }


            if (entityEnum.equals(EntityEnum.TRANSACTION)) {
                Files.write(referencePath, List.of("TRANSACTION_ID; CATEGORY_ID;"));
                Files.write(tablePath, List.of("ID;payDay;amount;"));
            }
            Files.write(keyTablePath, List.of("ID; CREATED_AT;"));
        }
    }
}

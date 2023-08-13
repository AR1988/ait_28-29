package org.example.service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;

/**
 * Сервис для работы с файлами и путями.
 */
public class FileService {
    /**
     * Возвращает объект типа File по указанному пути.
     *
     * @param source Путь к файлу.
     * @return Объект типа File, соответствующий указанному пути.
     */
    public File getFile(String source) {
        return getPath(source).toFile();
    }

    /**
     * Возвращает объект типа Path по указанному пути.
     *
     * @param source Путь к файлу или директории.
     * @return Объект типа Path, соответствующий указанному пути.
     */
    public Path getPath(String source) {
        return Path.of(source);
    }

    /**
     * Читает содержимое файла по указанному пути.
     *
     * @param source Путь к файлу.
     * @return Список строк содержимого файла.
     * @throws RuntimeException Если произошла ошибка при чтении файла.
     */
    public List<String> readFile(String source) {
        try {
            return Files.readAllLines(getPath(source));
        } catch (IOException e) {
            //todo собственная ошибка, обработка всех случаев отдельно. Смотри документацию к 'Files.readAllLines()'
            throw new RuntimeException(e);
        }
    }

    /**
     * Записывает список строк в файл.
     *
     * @param file    Файл для записи.
     * @param content Список строк для записи.
     * @throws RuntimeException Если произошла ошибка при записи файла.
     */
    public void writeToFile(File file, List<String> content) {
        //todo дописать метод для дозаписи в файл
        try (BufferedWriter bufferedWriter = Files.newBufferedWriter(file.toPath(), StandardOpenOption.APPEND)) {
            for (String line : content) {
                bufferedWriter.newLine();
                bufferedWriter.write(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Записывает список строк в файл по указанному пути.
     *
     * @param keyFilePath Путь к файлу для записи.
     * @param content     Список строк для записи.
     * @throws RuntimeException Если произошла ошибка при записи файла.
     */
    public void writeToFile(String keyFilePath, List<String> content) {
        File file = getFile(keyFilePath);
        writeToFile(file, content);
    }

    /**
     * Создает директорию по указанному пути, если она не существует.
     *
     * @param directoryPath Путь к директории.
     * @throws RuntimeException Если произошла ошибка при создании директории.
     */
    public void createDirectory(Path directoryPath) {
        try {
            if (!Files.exists(directoryPath)) {
                Files.createDirectory(directoryPath);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Создает файл по указанному пути, если он не существует.
     *
     * @param filePath Путь к файлу.
     * @throws RuntimeException Если произошла ошибка при создании файла.
     */
    public void createFile(Path filePath) {
        try {
            if (!Files.exists(filePath)) {
                Files.createFile(filePath);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

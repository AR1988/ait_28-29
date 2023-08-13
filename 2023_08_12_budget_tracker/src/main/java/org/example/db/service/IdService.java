package org.example.db.service;

import org.example.Constants;
import org.example.etity.EntityEnum;
import org.example.service.FileService;

import java.nio.file.Path;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Сервис для управления уникальными идентификаторами.
 */
public class IdService {

    private static final int CSV_EXPECTED_COLUMNS = 2;

    private final FileService fileService = new FileService();

    /**
     * Получает текущий уникальный идентификатор для указанной сущности.
     *
     * @param entityEnum Сущность, для которой необходимо получить уникальный идентификатор.
     * @return Текущий уникальный идентификатор.
     * @throws RuntimeException Если произошла ошибка при получении уникального идентификатора.
     */
    public Long getId(EntityEnum entityEnum) {
        String keyFilePath = getAbsolutePathToFile(entityEnum.getKeyTablePath());
        List<String> csvIdLines = fileService.readFile(keyFilePath);

        if (csvIdLines.size() > 1) {
            String lastIdLine = csvIdLines.get(csvIdLines.size() - 1);
            String[] columns = parseCsvLine(lastIdLine);
            try {
                return Long.parseLong(columns[0]);
            } catch (NumberFormatException e) {
                throw new RuntimeException("Значение " + columns[0] + " не является целым числом");
            }
        } else if (csvIdLines.size() == 1) {
            return 1L;
        } else {
            throw new RuntimeException("Проверьте формат файла " + keyFilePath + ". В файле нет записей касательно id для " + entityEnum.name());
        }
    }

    /**
     * Генерирует следующий уникальный идентификатор для указанной сущности и обновляет файл с ключами.
     *
     * @param entityEnum Сущность, для которой необходимо сгенерировать уникальный идентификатор.
     * @return Сгенерированный уникальный идентификатор.
     */
    public Long generateNextId(EntityEnum entityEnum) {
        Long nextId = getId(entityEnum) + 1L;

        String keyFilePath = getAbsolutePathToFile(entityEnum.getKeyTablePath());

        String dbLine = String.format("%d;%s",
                nextId,
                LocalDateTime.now().format(Constants.CSV_DATA_TIME_FORMATTER));
        fileService.writeToFile(keyFilePath, List.of(dbLine));

        return nextId;
    }

    /**
     * Разбирает строку CSV и возвращает массив значений.
     *
     * @param line Строка CSV для разбора.
     * @return Массив значений, полученных из строки CSV.
     */
    private String[] parseCsvLine(String line) {
        String[] columns = line.split(Constants.CSV_DELIMITER);
        //todo проверить количество колонок
        return columns;
    }

    /**
     * Возвращает абсолютный путь к файлу.
     *
     * @param path Путь к файлу.
     * @return Абсолютный путь к файлу.
     */
    private static String getAbsolutePathToFile(Path path) {
        return path.toAbsolutePath().toString();
    }

}

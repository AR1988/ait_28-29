package org.example.parser.impl;

import org.example.Constants;
import org.example.db.model.EntityReference;
import org.example.parser.Parser;

/**
 * Парсер для преобразования строк в объекты типа EntityReference.
 */
public class EntityReferenceParser implements Parser<EntityReference> {
    /**
     * Преобразует строку CSV в объект типа EntityReference.
     *
     * @param line Строка CSV для разбора.
     * @return Объект типа EntityReference, созданный из строки.
     * @throws NumberFormatException          Если встретится ошибка при преобразовании числа из строки.
     * @throws ArrayIndexOutOfBoundsException Если количество элементов после разбора строки не соответствует ожидаемому.
     */
    @Override
    public EntityReference parse(String line) {
        String[] strings = line.split(Constants.CSV_DELIMITER, -1);
        return new EntityReference(
                //todo валидация: является ли строка числом числом, размер массива
                //todo написать builder
                Long.parseLong(strings[0]),
                Long.parseLong(strings[1]));
    }
}

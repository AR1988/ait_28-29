package org.example.parser.impl;

import org.example.Constants;
import org.example.etity.SubCategory;
import org.example.parser.Parser;

/**
 * Парсер для преобразования строк в объекты типа SubCategory.
 */
public class SubCategoryParser implements Parser<SubCategory> {
    /**
     * Преобразует строку CSV в объект типа SubCategory.
     *
     * @param line Строка CSV для разбора.
     * @return Объект типа SubCategory, созданный из строки.
     * @throws NumberFormatException          Если встретится ошибка при преобразовании числа из строки.
     * @throws ArrayIndexOutOfBoundsException Если количество элементов после разбора строки не соответствует ожидаемому.
     */
    @Override
    public SubCategory parse(String line) {
        String[] split = line.split(Constants.CSV_DELIMITER, -1);
        return new SubCategory(
                Long.valueOf(split[0]),
                split[1]);

        //todo валидация: является ли строка числом числом, размер массива
        //todo написать builder
        // SubCategory.builder()
        //      .id(Long.valueOf(split[0]))
        //      .name(split[1])
        //      .build();
    }
}

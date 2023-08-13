package org.example.parser.impl;

import org.example.Constants;
import org.example.etity.Category;
import org.example.parser.Parser;

/**
 * Парсер для разбора строк CSV и преобразования их в объекты типа Category.
 */
public class CategoryParser implements Parser<Category> {

    /**
     * Преобразует строку CSV в объект типа Category.
     *
     * @param line Строка CSV для разбора.
     * @return Объект типа Category, созданный из строки.
     * @throws NumberFormatException          Если встретится ошибка при преобразовании числа из строки.
     * @throws ArrayIndexOutOfBoundsException Если количество элементов после разбора строки не соответствует ожидаемому.
     */
    @Override
    public Category parse(String line) {
        String[] parseLine = line.split(Constants.CSV_DELIMITER, -1);
        return new Category(Long.parseLong(parseLine[0]), parseLine[1]);

        //todo валидация: является ли строка числом числом, размер массива
        //todo написать builder

    }
}

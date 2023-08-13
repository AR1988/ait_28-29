package org.example.repository.impl;

import org.example.Constants;
import org.example.etity.Category;
import org.example.etity.EntityEnum;
import org.example.etity.SubCategory;
import org.example.parser.Parser;
import org.example.parser.impl.CategoryParser;
import org.example.repository.Repository;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Репозиторий для работы с категориями.
 */
public class CategoryRepository extends Repository<Category> {

    /**
     * Конструктор класса CategoryRepository.
     *
     * @param entityEnum Тип сущности, с которой работает репозиторий.
     */
    public CategoryRepository(EntityEnum entityEnum) {
        super(entityEnum);
    }

    /**
     * Добавляет подкатегорию к категории и записывает связь в файл.
     *
     * @param category    Категория, к которой добавляется подкатегория.
     * @param subCategory Подкатегория, которая добавляется к категории.
     * @throws RuntimeException Если идентификаторы категории или подкатегории равны null.
     */
    public void addSubcategory(Category category, SubCategory subCategory) {
        Long subCategoryId = subCategory.getId();
        Long categoryId = category.getId();

        if (subCategoryId == null) {
            throw new RuntimeException("Id не должно быть null");
        }
        if (categoryId == null) {
            throw new RuntimeException("Id не должно быть null");
        }

        File file = entityEnum.getReferencePath().toFile();
        fileService.writeToFile(file, List.of(convertToRefString(category, subCategory)));
    }

    /**
     * Преобразует категорию и подкатегорию в строку для записи в таблицу ссылок.
     *
     * @param category    Категория.
     * @param subCategory Подкатегория.
     * @return Строка для записи в таблицу ссылок.
     */
    protected String convertToRefString(Category category, SubCategory subCategory) {
        return category.getId() + Constants.CSV_DELIMITER + subCategory.getId();
    }

    /**
     * Преобразует сущность Category в строку для записи в базу данных.
     *
     * @param entity Сущность Category.
     * @return Строка для записи в базу данных.
     */
    @Override
    protected String entityToDbString(Category entity) {
        return entity.getId() + Constants.CSV_DELIMITER + entity.getName();
    }

    /**
     * Возвращает список всех категорий из базы данных.
     *
     * @return Список категорий.
     */
    @Override
    public List<Category> finAll() {
        File file = entityEnum.getTablePath().toFile();
        List<String> stringList = fileService.readFile(file.getAbsolutePath());
        Parser<Category> parser = new CategoryParser();

        List<Category> categories = new ArrayList<>();

        for (int i = 1; i < stringList.size(); i++) {
            String line = stringList.get(i);
            if (!line.isEmpty()) {
                categories.add(parser.parse(line));
            }
        }

        return categories;
    }
}


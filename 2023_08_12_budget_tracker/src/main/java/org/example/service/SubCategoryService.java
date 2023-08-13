package org.example.service;

import org.example.etity.Category;
import org.example.etity.SubCategory;
import org.example.repository.impl.SubCategoryRepository;

import java.util.Set;

/**
 * Сервис для работы с подкатегориями.
 */

public class SubCategoryService {

    private final SubCategoryRepository subCategoryRepository;

    /**
     * Конструктор класса SubCategoryService.
     *
     * @param subCategoryRepository Репозиторий для работы с подкатегориями.
     */
    public SubCategoryService(SubCategoryRepository subCategoryRepository) {
        this.subCategoryRepository = subCategoryRepository;
    }

    /**
     * Сохраняет подкатегорию в хранилище.
     *
     * @param subCategory Подкатегория для сохранения.
     * @return Сохраненная подкатегория.
     */
    public SubCategory save(SubCategory subCategory) {
        subCategoryRepository.persist(subCategory);
        return subCategory;
    }

    /**
     * Возвращает множество подкатегорий, связанных с указанной категорией.
     *
     * @param category Категория, для которой необходимо найти подкатегории.
     * @return Множество подкатегорий, связанных с указанной категорией.
     */
    public Set<SubCategory> getAll(Category category) {
        return subCategoryRepository.finAll(category);
    }
}

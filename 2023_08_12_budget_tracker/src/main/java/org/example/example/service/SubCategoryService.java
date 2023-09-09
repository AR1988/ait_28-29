package org.example.example.service;

import org.example.entity.Category;
import org.example.entity.SubCategory;
import org.example.repository.impl.SubCategoryRepository;

import java.util.Optional;
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
    //todo

    public SubCategory getById(long subCategoryId) {
        return findById(subCategoryId)
                .orElseThrow(() -> new RuntimeException("Subcategory with id " + subCategoryId + " not exists"));
    }

    public Optional<SubCategory> findById(long subCategoryId) {
        return subCategoryRepository.findById(subCategoryId);
    }
}

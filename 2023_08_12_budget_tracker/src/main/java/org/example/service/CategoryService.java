package org.example.service;

import org.example.etity.Category;
import org.example.etity.SubCategory;
import org.example.repository.impl.CategoryRepository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
/**
 * Сервис для работы с категориями.
 */
public class CategoryService {

    private final CategoryRepository categoryRepository;
    private final SubCategoryService subCategoryService;

    /**
     * Конструктор класса CategoryService.
     *
     * @param categoryRepository Репозиторий для работы с категориями.
     * @param subCategoryService Сервис для работы с подкатегориями.
     */
    public CategoryService(CategoryRepository categoryRepository, SubCategoryService subCategoryService) {
        this.categoryRepository = categoryRepository;
        this.subCategoryService = subCategoryService;
    }

    /**
     * Сохраняет категорию в хранилище.
     *
     * @param category Категория для сохранения.
     * @return Сохраненная категория.
     */
    public Category save(Category category) {
        categoryRepository.persist(category);
        return category;
    }

    /**
     * Добавляет подкатегорию к категории.
     *
     * @param category    Категория, к которой добавляется подкатегория.
     * @param subCategory Подкатегория для добавления.
     */
    public void addSubcategory(Category category, SubCategory subCategory) {
        categoryRepository.addSubcategory(category, subCategory);
        Set<SubCategory> subCategories = category.getSubCategories();
        if (subCategories == null) {
            subCategories = new HashSet<>();
            subCategories.add(subCategory);
            category.setSubCategories(subCategories);
        } else {
            subCategories.add(subCategory);
        }
    }

    /**
     * Возвращает список всех категорий с их подкатегориями.
     *
     * @return Список всех категорий с подкатегориями.
     */
    public List<Category> getAll() {
        List<Category> categories = categoryRepository.finAll();
        for (Category category : categories) {
            Set<SubCategory> subCategories = subCategoryService.getAll(category);
            category.setSubCategories(subCategories);
        }
        return categories;
    }
}

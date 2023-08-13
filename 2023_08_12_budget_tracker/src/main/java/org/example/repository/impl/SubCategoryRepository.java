package org.example.repository.impl;

import org.example.db.model.EntityReference;
import org.example.etity.Category;
import org.example.etity.EntityEnum;
import org.example.etity.SubCategory;
import org.example.parser.Parser;
import org.example.parser.impl.EntityReferenceParser;
import org.example.parser.impl.SubCategoryParser;
import org.example.repository.Repository;

import java.io.File;
import java.util.*;

/**
 * Репозиторий для работы с подкатегориями.
 */
public class SubCategoryRepository extends Repository<SubCategory> {

    /**
     * Конструктор класса SubCategoryRepository.
     *
     * @param entityEnum Перечисление сущностей, определяющее тип репозитория.
     */
    public SubCategoryRepository(EntityEnum entityEnum) {
        super(entityEnum);
    }

    /**
     * Сохраняет подкатегорию в хранилище.
     *
     * @param entity Подкатегория для сохранения.
     */
    @Override
    public void persist(SubCategory entity) {
        Long id = getNextId();
        entity.setId(id);
        File file = entityEnum.getTablePath().toFile();
        List<String> content = List.of(entityToDbString(entity));
        fileService.writeToFile(file, content);
    }

    /**
     * Преобразует подкатегорию в строку для записи в хранилище.
     *
     * @param entity Подкатегория для преобразования.
     * @return Строка, представляющая подкатегорию для записи в хранилище.
     */
    @Override
    protected String entityToDbString(SubCategory entity) {
        return entity.getId() + ";" + entity.getName();

    }

    /**
     * Возвращает список всех подкатегорий из хранилища.
     *
     * @return Список всех подкатегорий из хранилища.
     */
    @Override
    public List<SubCategory> finAll() {
        File file = entityEnum.getTablePath().toFile();
        List<String> stringList = fileService.readFile(file.getAbsolutePath());
        Parser<SubCategory> parser = new SubCategoryParser();

        List<SubCategory> categories = new ArrayList<>();

        for (int i = 1; i < stringList.size(); i++) {
            String line = stringList.get(i);
            if (!line.isEmpty()) {
                categories.add(parser.parse(line));
            }
        }

        return categories;
    }

    /**
     * Возвращает список ссылок на подкатегории, связанные с категорией.
     *
     * @return Список ссылок на подкатегории, связанные с категорией.
     */
    public List<EntityReference> getReference() {
        File file = EntityEnum.SUB_CATEGORY.getReferencePath().toFile();
        List<String> strings = fileService.readFile(file.getAbsolutePath());
        Parser<EntityReference> parser = new EntityReferenceParser();

        List<EntityReference> entityReferences = new ArrayList<>();

        for (int i = 1; i < strings.size(); i++) {
            String line = strings.get(i);
            if (!line.isEmpty()) {
                entityReferences.add(parser.parse(line));
            }
        }

        return entityReferences;
    }

    /**
     * Возвращает подкатегорию по указанному идентификатору.
     *
     * @param id Идентификатор подкатегории.
     * @return Опциональный объект подкатегории.
     */
    public Optional<SubCategory> findById(Long id) {
        List<SubCategory> subCategories = finAll();
        return subCategories.stream().filter(sc -> sc.getId().equals(id)).findFirst();
    }

    /**
     * Возвращает множество подкатегорий, связанных с указанной категорией.
     *
     * @param category Категория, для которой необходимо найти подкатегории.
     * @return Множество подкатегорий, связанных с указанной категорией.
     */
    public Set<SubCategory> finAll(Category category) {
        Long categoryId = category.getId();
        List<Long> subCategoriesIdByCategory = getReference().stream()
                .filter(r -> r.getParentId().equals(categoryId))
                .map(EntityReference::getChildId)
                .toList();

        Set<SubCategory> subCategoriesByCategory = new HashSet<>();
        for (Long id : subCategoriesIdByCategory) {
            Optional<SubCategory> subCategory = findById(id);
            subCategory.ifPresent(subCategoriesByCategory::add);
        }
        return subCategoriesByCategory;
    }
}

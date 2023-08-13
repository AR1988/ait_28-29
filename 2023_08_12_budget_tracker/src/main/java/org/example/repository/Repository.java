package org.example.repository;

import org.example.db.service.IdService;
import org.example.etity.EntityEnum;
import org.example.etity.ID;
import org.example.service.FileService;

import java.io.File;
import java.util.List;

/**
 * Абстрактный репозиторий для работы с сущностями.
 *
 * @param <E> Тип сущности, с которым работает репозиторий.
 */
public abstract class Repository<E extends ID> {

    protected FileService fileService = new FileService();
    protected final EntityEnum entityEnum;

    /**
     * Конструктор класса Repository.
     *
     * @param entityEnum Тип сущности, с которой работает данный репозиторий.
     */
    public Repository(EntityEnum entityEnum) {
        this.entityEnum = entityEnum;
    }

    /**
     * Получает следующий доступный идентификатор сущности.
     *
     * @return Следующий доступный идентификатор сущности.
     */
    protected Long getNextId() {
        IdService idService = new IdService();
        return idService.generateNextId(EntityEnum.SUB_CATEGORY);
    }

    /**
     * Сохраняет сущность в базе данных.
     *
     * @param entity Сущность для сохранения.
     */
    public void persist(E entity) {
        Long id = getNextId();
        entity.setId(id);
        File file = entityEnum.getTablePath().toFile();
        List<String> content = List.of(entityToDbString(entity));
        fileService.writeToFile(file, content);
    }

    /**
     * Преобразует сущность в строку для записи в базу данных.
     *
     * @param entity Сущность для преобразования.
     * @return Строка для записи в базу данных.
     */
    protected abstract String entityToDbString(E entity);

    /**
     * Возвращает список всех сущностей данного типа из базы данных.
     *
     * @return Список всех сущностей.
     */
    protected abstract List<E> finAll();
}

package org.example.db.model;

/**
 * Класс EntityReference представляет собой модель ссылки между двумя сущностями.
 */
public class EntityReference {

    private final Long parentId;
    private final Long childId;

    /**
     * Создает объект EntityReference с указанными идентификаторами родительской и дочерней сущностей.
     *
     * @param parentId Идентификатор родительской сущности.
     * @param childId  Идентификатор дочерней сущности.
     */
    public EntityReference(Long parentId, Long childId) {
        this.parentId = parentId;
        this.childId = childId;
    }

    /**
     * Возвращает идентификатор родительской сущности.
     *
     * @return Идентификатор родительской сущности.
     */
    public Long getParentId() {
        return parentId;
    }

    /**
     * Возвращает идентификатор дочерней сущности.
     *
     * @return Идентификатор дочерней сущности.
     */
    public Long getChildId() {
        return childId;
    }

}

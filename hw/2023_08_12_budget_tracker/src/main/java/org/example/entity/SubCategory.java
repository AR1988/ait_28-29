package org.example.entity;

import java.util.Objects;

/**
 * Класс, представляющий сущность "Подкатегория".
 */
public final class SubCategory implements ID {

    private Long id;
    private String name;

    public SubCategory() {
    }

    public SubCategory(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public SubCategory(String name) {
        this.name = name;
    }

    @Override
    public Long getId() {
        return this.id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (SubCategory) obj;
        return Objects.equals(this.id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "SubCategory[" +
                "id=" + id + ", " +
                "name=" + name + ']';
    }
}

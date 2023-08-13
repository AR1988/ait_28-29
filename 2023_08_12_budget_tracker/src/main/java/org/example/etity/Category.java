package org.example.etity;

import java.util.Objects;
import java.util.Set;
/**
 * Класс, представляющий сущность "Категория".
 */
public final class Category implements ID {


    private Long id;
    private String name;
    private Set<SubCategory> subCategories;

    public Category() {
    }

    public Category(Long id, String name) {
        this.id = id;
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

    public Set<SubCategory> getSubCategories() {
        return subCategories;
    }

    public void setSubCategories(Set<SubCategory> subCategories) {
        this.subCategories = subCategories;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (Category) obj;
        return Objects.equals(this.id, that.id) &&
                Objects.equals(this.name, that.name) &&
                Objects.equals(this.subCategories, that.subCategories);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, subCategories);
    }

    @Override
    public String toString() {
        return "Category[" +
                "id=" + id + ", " +
                "name=" + name + ", " +
                "subCategories=" + subCategories + ']';
    }
}

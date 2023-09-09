package org.example.utils;

import java.util.List;
import java.util.Objects;

/**
 * @author Andrej Reutow
 * created on 26.08.2023
 */
public class CategoryJson {

    private String name;
    private List<SubCategoryJson> subCategories;

    public CategoryJson(String name, List<SubCategoryJson> subCategories) {
        this.name = name;
        this.subCategories = subCategories;
    }

    public CategoryJson() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<SubCategoryJson> getSubCategories() {
        return subCategories;
    }

    public void setSubCategories(List<SubCategoryJson> subCategories) {
        this.subCategories = subCategories;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CategoryJson that = (CategoryJson) o;
        return Objects.equals(name, that.name) && Objects.equals(subCategories, that.subCategories);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, subCategories);
    }
}

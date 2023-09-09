package org.example.example.utils;

import java.util.Objects;

/**
 * @author Andrej Reutow
 * created on 26.08.2023
 */
public class SubCategoryJson {

    private String name;

    public SubCategoryJson(String name) {
        this.name = name;
    }

    public SubCategoryJson() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SubCategoryJson that = (SubCategoryJson) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}

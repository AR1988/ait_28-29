package org.example.example.entity;

import org.example.entity.ID;
import org.example.entity.SubCategory;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

public class Transaction implements ID {
    private Long id;
    private LocalDateTime date;
    private BigDecimal amount;
    private SubCategory subCategory;

    public Transaction(Long id, LocalDateTime date, BigDecimal amount, SubCategory subCategory) {
        this.id = id;
        this.date = date;
        this.amount = amount;
        this.subCategory = subCategory;
    }

    public Transaction(LocalDateTime date, BigDecimal amount, SubCategory subCategory) {
        this.date = date;
        this.amount = amount;
        this.subCategory = subCategory;
    }

    public Transaction(LocalDateTime date, BigDecimal amount) {
        this.date = date;
        this.amount = amount;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public SubCategory getSubCategory() {
        return subCategory;
    }

    public void setSubCategory(SubCategory subCategory) {
        this.subCategory = subCategory;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (Transaction) obj;
        return Objects.equals(this.id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Transaction[" +
                "id=" + id + ", " +
                "payDay=" + date + ", " +
                "amount=" + amount + ", " +
                "category=" + subCategory + ']';
    }
}

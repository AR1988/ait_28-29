package org.example.etity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

public class Transaction {
    private Long id;
    private LocalDate date;
    private BigDecimal amount;
    private Category category;


    public Transaction() {
    }

    public Transaction(Long id, LocalDate date, BigDecimal amount, Category category) {
        this.id = id;
        this.date = date;
        this.amount = amount;
        this.category = category;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (Transaction) obj;
        return Objects.equals(this.id, that.id) &&
                Objects.equals(this.date, that.date) &&
                Objects.equals(this.amount, that.amount) &&
                Objects.equals(this.category, that.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, date, amount, category);
    }

    @Override
    public String toString() {
        return "Transaction[" +
                "id=" + id + ", " +
                "payDay=" + date + ", " +
                "amount=" + amount + ", " +
                "category=" + category + ']';
    }


}

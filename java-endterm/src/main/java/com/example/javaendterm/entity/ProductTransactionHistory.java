package com.example.javaendterm.entity;

import com.example.javaendterm.entity.base.BaseEntity;
import com.example.javaendterm.entity.enums.Transaction;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import java.util.Date;

@Entity
public class ProductTransactionHistory extends BaseEntity {
    @ManyToOne
    private ProductEntity product;
    private int count;
    private String description;
    private Date transactionDate;
    @Enumerated(EnumType.STRING)
    private Transaction transaction;

    public ProductTransactionHistory() {

    }

    public ProductTransactionHistory(ProductEntity product, int count, String description, Transaction transaction) {
        this.product = product;
        this.count = count;
        this.description = description;
        this.transactionDate = new Date();
        this.transaction = transaction;
    }

    public ProductEntity getProduct() {
        return product;
    }

    public void setProduct(ProductEntity product) {
        this.product = product;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }
}

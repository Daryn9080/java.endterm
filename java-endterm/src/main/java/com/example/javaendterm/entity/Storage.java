package com.example.javaendterm.entity;

import com.example.javaendterm.entity.base.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "product_storage")
public class Storage extends BaseEntity {
    @OneToOne
    private ProductEntity product;
    private int count;

    public Storage() {

    }

    public Storage(ProductEntity product, int count) {
        this.product = product;
        this.count = count;
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
}

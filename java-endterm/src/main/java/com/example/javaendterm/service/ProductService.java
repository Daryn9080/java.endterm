package com.example.javaendterm.service;

import com.example.javaendterm.entity.ProductEntity;
import com.example.javaendterm.entity.ProductTransaction;
import com.example.javaendterm.entity.ProductTransactionHistory;
import com.example.javaendterm.entity.Storage;

import java.util.List;

public interface ProductService {
    List<ProductEntity> getAll();
    ProductEntity getById(Long id);
    ProductEntity create(ProductEntity productEntity);
    ProductEntity update(ProductEntity productEntity);
    ProductEntity save(ProductEntity productEntity);
    ProductTransactionHistory transaction(ProductTransaction productTransaction);
    Storage getStorage(Long id);
    void delete(Long id);
}

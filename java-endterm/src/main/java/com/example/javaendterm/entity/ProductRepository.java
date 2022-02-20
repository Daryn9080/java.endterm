package com.example.javaendterm.entity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface ProductRepository extends CrudRepository<ProductEntity, Long> {
    List<ProductEntity> findAll();
}

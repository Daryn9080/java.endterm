package com.example.javaendterm.entity;

import org.springframework.data.repository.CrudRepository;

public interface StorageRepository extends CrudRepository<Storage, Long> {
    Storage getByProductId(Long productId);
}

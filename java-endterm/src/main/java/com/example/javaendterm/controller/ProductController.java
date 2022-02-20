package com.example.javaendterm.controller;

import com.example.javaendterm.entity.ProductEntity;
import com.example.javaendterm.entity.ProductTransaction;
import com.example.javaendterm.entity.ProductTransactionHistory;
import com.example.javaendterm.service.impl.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductServiceImpl productService;

    @GetMapping
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(productService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        return ResponseEntity.ok(productService.getById(id));
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody ProductEntity productEntity) {
        return ResponseEntity.ok(productService.create(productEntity));
    }

    @PostMapping("/{id}/update")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody ProductEntity productEntity) {
        return ResponseEntity.ok(productService.update(productEntity));
    }

    @GetMapping("/{id}/storage")
    public ResponseEntity<?> getProductStorage(@PathVariable Long id) {
        return ResponseEntity.ok(productService.getStorage(id));
    }

    @PostMapping("/create/transaction")
    public ResponseEntity<?> createTransaction(@RequestBody ProductTransaction productTransaction) {
        ProductTransactionHistory transactionHistory = null;
        try {
            transactionHistory = productService.transaction(productTransaction);
        } catch (RuntimeException runtimeException) {
            return ResponseEntity.badRequest().body(runtimeException.getMessage());
        }
        return ResponseEntity.ok(transactionHistory);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        productService.delete(id);
        return ResponseEntity.ok().build();
    }



}

package com.example.javaendterm.service.impl;

import com.example.javaendterm.entity.*;
import com.example.javaendterm.entity.enums.Transaction;
import com.example.javaendterm.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private StorageRepository storageRepository;

    @Autowired
    private ProductTransactionHistoryRepository transactionHistoryRepository;

    @Override
    public List<ProductEntity> getAll() {
        return productRepository.findAll();
    }

    @Override
    public ProductEntity getById(Long id) {
        Optional<ProductEntity> productEntity = productRepository.findById(id);
        return productEntity.orElse(null);
    }

    @Override
    public ProductEntity create(ProductEntity productEntity) {
        productEntity = save(productEntity);
        storageRepository.save(new Storage(productEntity, 0));
        return save(productEntity);
    }

    @Override
    public ProductEntity update(ProductEntity productEntity) {
        return save(productEntity);
    }

    @Override
    public ProductEntity save(ProductEntity productEntity) {
        return productRepository.save(productEntity);
    }

    @Override
    public ProductTransactionHistory transaction(ProductTransaction productTransaction) {
        ProductEntity product = getById(productTransaction.getProductId());
        Storage storage = storageRepository.getByProductId(productTransaction.getProductId());

        if(productTransaction.getTransaction() == Transaction.OUTCOME && storage.getCount() < productTransaction.getCount())
            throw new RuntimeException("Недостаточно товаров в количестве "+(productTransaction.getCount() - storage.getCount()) + " шт.");

        ProductTransactionHistory transactionHistory = new ProductTransactionHistory(product, productTransaction.getCount(), productTransaction.getDescription(), productTransaction.getTransaction());
        if (transactionHistory.getTransaction() == Transaction.OUTCOME)
            storage.setCount(storage.getCount() - productTransaction.getCount());
        else
            storage.setCount(storage.getCount() + productTransaction.getCount());

        storageRepository.save(storage);
        return transactionHistoryRepository.save(transactionHistory);
    }


    @Override
    public Storage getStorage(Long id) {
        return storageRepository.getByProductId(id);
    }

    @Override
    public void delete(Long id) {
        productRepository.deleteById(id);
    }
}

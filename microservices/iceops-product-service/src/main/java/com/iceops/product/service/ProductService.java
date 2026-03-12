package com.iceops.product.service;

import com.iceops.product.entity.Product;
import com.iceops.product.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public List<Product> getProducts() {
        return repository.findAll();
    }

    public Product save(Product product) {
        return repository.save(product);
    }
}
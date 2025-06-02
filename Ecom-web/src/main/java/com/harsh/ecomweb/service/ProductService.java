package com.harsh.ecomweb.service;

import com.harsh.ecomweb.model.Product;
import com.harsh.ecomweb.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepo repo;

    public List<Product> getAllProduct() {
        return repo.findAll();
    }

    public Product getProduct(int id) {
        return repo.findById(String.valueOf(id)).orElse(null);
    }
}

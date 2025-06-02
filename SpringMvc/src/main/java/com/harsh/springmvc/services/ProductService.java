package com.harsh.springmvc.services;

import com.harsh.springmvc.models.Product;
import com.harsh.springmvc.repository.Productrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    Productrepo repo;

    public List<Product> getallProducts() {
        return (List<Product>) repo.findAll();
    }

    public Product getProduct(int prodId) {
        return repo.findById(prodId).orElse(new Product());
    }

    public void add(Product prod) {
        repo.save(prod);
    }
    public void update(Product prod){
        repo.save(prod);
    }
    public void delete(int prodId){
        repo.deleteById(prodId);
    }

    public List<Product> findByName(String productName) {
        return repo.findByName(productName);
    }
}

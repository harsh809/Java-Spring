package com.harsh.ecomweb.controller;

import com.harsh.ecomweb.model.Product;
import com.harsh.ecomweb.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping("/getallproduct")
    public ResponseEntity<List<Product>> getProduct(){
        return new ResponseEntity<>(service.getAllProduct(), HttpStatus.OK);
    }
    @GetMapping("/getproduct/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable int id){
        Product prod = service.getProduct(id);
        if (prod != null){
            return new ResponseEntity<>(prod,HttpStatus.OK);
        }
        return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
    }
}

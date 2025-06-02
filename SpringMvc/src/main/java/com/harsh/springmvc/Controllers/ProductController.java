package com.harsh.springmvc.Controllers;

import com.harsh.springmvc.models.Product;
import com.harsh.springmvc.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public List<Product> getProducts(){
        return productService.getallProducts();
    }

    @GetMapping("/products/Id/{prodId}")
    public Product getProduct(@PathVariable int prodId){
        return productService.getProduct(prodId);
    }

    @PostMapping("products")
    public void addProduct(@RequestBody Product prod){
        productService.add(prod);
    }
    @PutMapping("products")
    public void updateProduct(@RequestBody Product prod){
        productService.update(prod);
    }
    @DeleteMapping("products/{prodId}")
    public void deleteProduct(@PathVariable int prodId){
        productService.delete(prodId);
    }
    @GetMapping("/products/name/{productName}")
    public List<Product> getProductByName(@PathVariable String productName){
        return productService.findByName(productName);
    }

}

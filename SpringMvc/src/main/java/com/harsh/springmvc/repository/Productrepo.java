package com.harsh.springmvc.repository;

import com.harsh.springmvc.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Productrepo extends JpaRepository<Product, Integer> {

//    List<Product> findByProductName(String productName);
    @Query("from Product where productName = :pname")
    List<Product> findByName(@Param("pname") String name);
}

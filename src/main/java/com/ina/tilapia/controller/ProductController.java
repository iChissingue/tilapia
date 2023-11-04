package com.ina.tilapia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ina.tilapia.models.Product;
import com.ina.tilapia.service.ProductService;

@RestController
public class ProductController {

    @Autowired
    ProductService productService;
    

    @PostMapping("/product")
    public ResponseEntity<?> create(@RequestBody Product product){
        return productService.create(product);
    }
    
}

package com.ina.tilapia.repository;


import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.ina.tilapia.models.Product;

public interface ProductRepo extends CrudRepository <Product, Integer> {
    List<Product> findAll();
}

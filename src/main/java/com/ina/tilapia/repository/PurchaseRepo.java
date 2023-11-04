package com.ina.tilapia.repository;

import org.springframework.data.repository.CrudRepository;

import com.ina.tilapia.models.Purchase;

public interface PurchaseRepo extends CrudRepository <Purchase, Integer>{
    
}

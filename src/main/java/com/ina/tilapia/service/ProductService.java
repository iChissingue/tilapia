package com.ina.tilapia.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ina.tilapia.models.Message;
import com.ina.tilapia.models.Product;
import com.ina.tilapia.repository.ProductRepo;

@Service
public class ProductService {

    @Autowired
    private Message message;

    @Autowired
    ProductRepo productRepo;

    public ResponseEntity<?> create(Product product){
        if(product.getName().equals("")){
            message.setMessage("Digite o nome do produto!");
            return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
        }else if(product.getPrice() > 0){
            message.setMessage("Digite o preco do produto!");
            return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
        }else{
            return new ResponseEntity<>(productRepo.save(product), HttpStatus.CREATED);
        }
    }
    
}

package com.ina.tilapia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ina.tilapia.models.Client;
import com.ina.tilapia.repository.Repo;
import com.ina.tilapia.service.Services;



@RestController
public class Controller{

    @Autowired
    private Repo action;

    @Autowired
    private Services services;

    @PostMapping("/client")
    public ResponseEntity<?> create(@RequestBody Client obj){
        return services.create(obj);
    }

    @PutMapping("/client")
    public ResponseEntity<?> edit(@RequestBody Client client){
        return services.edit(client);
    }

    @GetMapping("/clients")
    public ResponseEntity<?> select(){
        return services.selectAll();
    }
    
    @GetMapping("/clients/order")
    public List<Client> selectOrdered(){
        return action.findByOrderByName();
    }
    @GetMapping("/client/{code}")
    public ResponseEntity<?> selectByCode(@PathVariable  int code){
        return services.selectByCode(code);
    }

    @DeleteMapping("/client/{code}")
    public ResponseEntity<?> remove(@PathVariable int code){
       
         return services.remove(code);
    }

    @GetMapping("/clients/counter")
    public long countClients(){
        return action.count();
    }

    @GetMapping("")
    public String message(){
        return "Hello world!";
    }  
    
    @GetMapping("/wellcome/{name}")
    public String wellCome(@PathVariable String name){
        return "Well Come! " + name;
    }

    @GetMapping("/client/name/{term}")
    public List<Client> nameContaining(@PathVariable String term){
        return action.findByNameContaining(term);
    }

    @GetMapping("/contacts/sum")
    public int sumContacts(){
        return action.sumContacts();
    }

    @GetMapping("/code/greatOrEqual/{code}")
    public List<Client> greatOrEqualCode(@PathVariable Integer code){
        return action.greatOrEqualCode(code);
    }

}
 
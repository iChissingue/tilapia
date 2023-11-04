package com.ina.tilapia.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ina.tilapia.models.Client;


@Repository
public interface Repo extends CrudRepository <Client, Integer>{
    
    List<Client> findAll();
    Client findByCode(int code);
    List<Client> findByOrderByName();
    List<Client> findByNameContaining(String term);

    @Query(value = "SELECT SUM(code) from clients", nativeQuery = true)
    int sumContacts();

    @Query(value = ("SELECT * from clients where code >= :code"), nativeQuery = true)
    List<Client> greatOrEqualCode(int code);

    int countByCode(int code);
}

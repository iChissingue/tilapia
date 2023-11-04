package com.ina.tilapia.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ina.tilapia.models.Client;
import com.ina.tilapia.models.Message;
import com.ina.tilapia.repository.Repo;

@Service
public class Services {
    @Autowired
    private Message message;

    @Autowired Repo actions;

    public ResponseEntity<?> create(Client obj){
        if(obj.getName().equals("")){
            message.setMessage("O campo nome nao pode ser vazio!");
            return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
        }else if(obj.getContact() < 0){
            message.setMessage("Informe um valor numerico!");
            return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
        }else{  
            return new ResponseEntity<>(actions.save(obj), HttpStatus.CREATED);
        }
    }

    public ResponseEntity<?> selectAll(){
        return new ResponseEntity<>(actions.findAll(), HttpStatus.OK);
    }

    public ResponseEntity<?> selectByCode(int code){
        if(actions.countByCode(code) == 0){
            message.setMessage("Cliente nao encontrado!");
            return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
        }else{
            return new ResponseEntity<>(actions.findByCode(code), HttpStatus.OK);
        }
    }

    public ResponseEntity<?> edit(Client client){
        if(actions.countByCode(client.getCode()) == 0){
            message.setMessage("Cliente nao encontrado!");
            return new ResponseEntity<> (message, HttpStatus.NOT_FOUND);
        }else if(client.getName().equals("")){
            message.setMessage("Insira o nome do Cliente!");
            return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
        }else if(client.getContact() < 0){
            message.setMessage("Insira contacto do cliente!");
            return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
        }else{
            return new ResponseEntity<>(actions.save(client), HttpStatus.CREATED);
        }
    }

    public ResponseEntity<?> remove(int code){
        if(actions.countByCode(code) == 0){
            message.setMessage("Cliente nao encontrado!");
            return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
        }else{
            Client client = actions.findByCode(code);
            actions.delete(client);
            message.setMessage("Cliente deletado com sucesso!");
            return new ResponseEntity<>(message, HttpStatus.OK);
        }
    }
    
}

package com.ina.tilapia.models;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "purchases")
public class Purchase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int code;

    @OneToMany
    @JoinColumn(name = "Product_Code", referencedColumnName = "code")
    private Product product;



    @OneToOne
    @JoinColumn(name = "ClientCode", referencedColumnName = "code")
    private Client client;


    public int getCode() {
        return code;
    }
    public void setCode(int code) {
        this.code = code;
    }
   

}

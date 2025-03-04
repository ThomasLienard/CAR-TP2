package com.example.TP2_CAR.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.TP2_CAR.data.Client;

public interface  ClientRepository extends CrudRepository<Client, String>  {
    
    public Client findByEmail(String email);
    public Client findByEmailAndPassword(String email,String password);
}
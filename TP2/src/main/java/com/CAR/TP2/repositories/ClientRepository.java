package com.CAR.TP2.repositories;

import org.springframework.data.repository.CrudRepository;

import com.CAR.TP2.data.Client;

public interface  ClientRepository extends CrudRepository<Client, String>  {
    
    public Client findByEmail(String email);
    public Client findByEmailAndPassword(String email,String password);
}
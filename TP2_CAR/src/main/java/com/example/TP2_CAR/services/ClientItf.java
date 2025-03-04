package com.example.TP2_CAR.services;

import com.example.TP2_CAR.data.Client;

public interface ClientItf {

    Client findByEmail(String email);

    Client findByEmailAndPassword(String email,String password);

    void create(String email, String password, String nom, String prenom );
    
}

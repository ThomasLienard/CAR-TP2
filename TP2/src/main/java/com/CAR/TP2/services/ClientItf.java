package com.CAR.TP2.services;

import com.CAR.TP2.data.Client;

public interface ClientItf {

    Client findByEmail(String email);

    Client findByEmailAndPassword(String email,String password);

    void create(String email, String password, String nom, String prenom );
    
}

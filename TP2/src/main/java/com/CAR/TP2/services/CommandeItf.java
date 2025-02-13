package com.CAR.TP2.services;

import com.CAR.TP2.data.Client;
import com.CAR.TP2.data.Commande;

public interface  CommandeItf {
    
    Iterable<Commande> findAll();

    void create(String nom,Client client);
    
    Iterable<Commande> findAllByClient(Client client);


}

package com.example.TP2_CAR.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.TP2_CAR.data.Client;
import com.example.TP2_CAR.data.Commande;

public interface  CommandeRepository extends CrudRepository<Commande, Long>{

	public Iterable<Commande> findAllByClient(Client client);

}

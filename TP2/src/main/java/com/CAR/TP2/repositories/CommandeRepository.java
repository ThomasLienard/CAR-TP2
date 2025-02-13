package com.CAR.TP2.repositories;

import org.springframework.data.repository.CrudRepository;

import com.CAR.TP2.data.Client;
import com.CAR.TP2.data.Commande;

public interface  CommandeRepository extends CrudRepository<Commande, Long>{

	public Iterable<Commande> findAllByClient(Client client);

}

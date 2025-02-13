package com.CAR.TP2.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CAR.TP2.data.Client;
import com.CAR.TP2.data.Commande;
import com.CAR.TP2.repositories.CommandeRepository;

@Service
public class CommandeService implements CommandeItf {
    
     @Autowired
    private CommandeRepository repo;

    @Override
    public Iterable<Commande> findAll() {
        return repo.findAll();
        }

    @Override
    public void create(String nom,Client client) {
        var commande = new Commande(nom);
        commande.setClient(client);
        client.addCommande(commande);
        repo.save(commande);
        }

	@Override
	public Iterable<Commande> findAllByClient(Client client) {
		return repo.findAllByClient(client);
	}
}

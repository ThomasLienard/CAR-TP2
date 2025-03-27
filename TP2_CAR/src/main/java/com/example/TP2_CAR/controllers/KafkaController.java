package com.example.TP2_CAR.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import com.example.TP2_CAR.data.Commande;
import com.example.TP2_CAR.services.ClientItf;
import com.example.TP2_CAR.services.CommandeItf;
import com.example.TP2_CAR.services.kafka.KafkaProducer;

import jakarta.servlet.http.HttpSession;

@RestController
public class KafkaController {

    private final KafkaProducer kafkaProducer;

    @Autowired
    private ClientItf clientService;

     @Autowired
    private CommandeItf commandeService;

    public KafkaController(KafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    @PostMapping("/store/client/valider")
    public RedirectView produceMessage(@RequestParam Long commandeId, HttpSession session ) {
        String email = (String) session.getAttribute("email");
        if (email == null || clientService.findByEmail(email) == null) {
            return new RedirectView("/store/home");
        }
        // Gestion des messages
        Optional<Commande> commande = commandeService.findById(commandeId);
        if (!commande.isEmpty()){
            Commande c = commande.get();
            if (c != null) {
                c.getLigneCommande().forEach(lc -> {
                String message = lc.getArticle().getNomArticle() + " : " + lc.getNbArticle();
                kafkaProducer.produce(message);
                });
            }
            commandeService.valider(commandeId);

            return new RedirectView("/store/client");
        }else
            return new RedirectView("/store/home");
        
    }
}


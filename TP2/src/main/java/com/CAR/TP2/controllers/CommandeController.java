package com.CAR.TP2.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.CAR.TP2.data.Client;
import com.CAR.TP2.services.ClientItf;
import com.CAR.TP2.services.CommandeItf;

import jakarta.servlet.http.HttpSession;


@Controller
@RequestMapping("/store/client")
public class CommandeController {
    
    @Autowired
    private CommandeItf service;
    
    @Autowired
    private ClientItf clientService;

    
    @PostMapping("/createCommand")
    public RedirectView create(@RequestParam String nom,HttpSession session) {
    	String email = (String) session.getAttribute("email");
    	Client client = clientService.findByEmail(email);
        service.create(nom, client);
        return new RedirectView("/store/client");
    }
    
    @GetMapping("/commande/{id}")
    public String commandePage( @PathVariable String id ) {
    	// TODO
		return id;
    	
    }

}

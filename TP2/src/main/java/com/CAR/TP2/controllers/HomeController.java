package com.CAR.TP2.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.CAR.TP2.services.ClientItf;


@Controller
@RequestMapping("/store")
public class HomeController {
    
    @Autowired
    private ClientItf service;

    @GetMapping("/home")
    public String home() {
        return "/store/home";
    }

    @PostMapping("/create")
    public RedirectView create(@RequestParam String email,@RequestParam String password,@RequestParam String nom,@RequestParam String prenom ){
        service.create(email, password, nom, prenom);
        return new RedirectView("/store/home");
    }

    @PostMapping("/login")
    public ModelAndView login(@RequestParam String email, @RequestParam String password) {
        var client = service.findByEmailAndPassword(email,password);
        var model = Map.of("client",client);
        return new ModelAndView("/store/client",model);
    }
    
}

package com.CAR.TP2.data;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Client {

    @Id
    private String email;  
    private String password;
    private String nom;
    private String prenom;                       
                                    
    public Client() {}
                                
    public Client(String email, String password, String nom, String prenom ){                     
        this.email = email;                     
        this.password = password;                 
        this.nom = nom;
        this.prenom = prenom;
    }
    
    public void setMail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getMail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }
}

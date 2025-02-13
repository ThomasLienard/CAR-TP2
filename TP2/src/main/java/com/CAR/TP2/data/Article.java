package com.CAR.TP2.data;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Article {

    @Id
    private String nomArticle;

    private double prixUnitaire;

    @OneToOne(mappedBy = "article", cascade = CascadeType.ALL)
    private LigneCommande ligneCommande;
    
    public Article() {}

    public Article( String nomArticle, double prixUnitaire ) {
        this.nomArticle = nomArticle;
        this.prixUnitaire = prixUnitaire;
    }

    public String getNomArticle() {
        return nomArticle;
    }

    public void setNomArticle(String nomArticle) {
        this.nomArticle = nomArticle;
    }

    public Double getPrixUnitaire() {
        return prixUnitaire;
    }

    public void setPrixUnitaire(Double prixUnitaire) {
        this.prixUnitaire = prixUnitaire;
    }

    public LigneCommande getLigneCommande() { 
        return ligneCommande; 
    }

    public void setLigneCommande(LigneCommande ligneCommande) {
        this.ligneCommande = ligneCommande;
        if (ligneCommande != null) {
            ligneCommande.setArticle(this);
        }
    }


    
}

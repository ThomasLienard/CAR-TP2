package com.example.TP2_CAR.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.example.TP2_CAR.data.Article;

public interface ArticleRepository extends CrudRepository<Article, Long> {

    Optional<Article> findByNomArticleAndPrixUnitaire(String articleNom, double prix);
}
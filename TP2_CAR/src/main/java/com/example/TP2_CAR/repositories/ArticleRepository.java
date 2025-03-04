package com.example.TP2_CAR.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.TP2_CAR.data.Article;

public interface ArticleRepository extends CrudRepository<Article, String> {
}
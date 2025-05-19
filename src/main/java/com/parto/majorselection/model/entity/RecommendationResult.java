package com.parto.majorselection.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class RecommendationResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String major;

    private String zone;

    private Integer rank;

    private String sahmie;

    private String reshte;

    private String daneshgah;

    private String ostan;

    private String dore;

    private String rankCountry;

    private String rankZone;

    private String city;
}

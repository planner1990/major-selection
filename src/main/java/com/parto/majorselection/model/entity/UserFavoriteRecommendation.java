package com.parto.majorselection.model.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
public class UserFavoriteRecommendation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    private Long recommendationResultId;

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

    private LocalDateTime bookmarkedAt;
}

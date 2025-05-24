package com.parto.majorselection.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RecommendedField {

    private Long id;

    private String sahmie;

    private String reshte;

    private String daneshgah;

    private String ostan;

    private String dore;

    @JsonProperty("rank_country")
    private String rankCountry;

    @JsonProperty("rank_zone")
    private String rankZone;

    private String city;

    @JsonProperty("admission_chance")
    private String admissionChance; // خوش‌بینانه، منطقی، بدبینانه
}

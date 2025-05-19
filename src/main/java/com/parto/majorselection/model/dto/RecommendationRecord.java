package com.parto.majorselection.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class RecommendationRecord {
    private String major;
    private String zone;
    private int rank;
    private List<RecommendedField> results;
}

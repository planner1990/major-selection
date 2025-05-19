package com.parto.majorselection.model.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RecommendationRequest {
    private String major;
    private String zone;
    private int rank;
}

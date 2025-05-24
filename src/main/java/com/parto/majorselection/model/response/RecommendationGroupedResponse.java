package com.parto.majorselection.model.response;

import com.parto.majorselection.model.dto.RecommendedField;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RecommendationGroupedResponse {
    private List<RecommendedField> optimistic;
    private List<RecommendedField> realistic;
    private List<RecommendedField> pessimistic;
}

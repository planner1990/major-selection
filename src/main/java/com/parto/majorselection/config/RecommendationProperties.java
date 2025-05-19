package com.parto.majorselection.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@Setter
@ConfigurationProperties(prefix = "recommendation")
public class RecommendationProperties {
    private String filePath;
}

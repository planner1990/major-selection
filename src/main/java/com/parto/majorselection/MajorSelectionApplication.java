package com.parto.majorselection;

import com.parto.majorselection.config.RecommendationProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.parto")
@EntityScan(basePackages = "com.parto")
@EnableConfigurationProperties(RecommendationProperties.class)
public class MajorSelectionApplication {

    public static void main(String[] args) {
        SpringApplication.run(MajorSelectionApplication.class, args);
    }

}

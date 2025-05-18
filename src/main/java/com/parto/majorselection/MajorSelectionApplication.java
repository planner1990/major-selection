package com.parto.majorselection;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.parto")
@EntityScan(basePackages = "com.parto")
public class MajorSelectionApplication {

    public static void main(String[] args) {
        SpringApplication.run(MajorSelectionApplication.class, args);
    }

}

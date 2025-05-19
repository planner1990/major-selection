package com.parto.majorselection.model.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class UniversityField {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String highSchoolCategory;
    private String title;

    @Column(columnDefinition = "TEXT")
    private String intro;

    @Column(columnDefinition = "TEXT")
    private String subField;

    @Column(columnDefinition = "TEXT")
    private String vision;

    @Column(columnDefinition = "TEXT")
    private String lessons;

    @Column(columnDefinition = "TEXT")
    private String jobSituation;
}


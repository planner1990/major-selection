package com.parto.majorselection.model.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "users", uniqueConstraints = @UniqueConstraint(columnNames = "mobile"))
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;

    @Column(nullable = false, unique = true)
    private String mobile;

    @Column(nullable = false)
    private String password;

    private String city;

    @Column(name = "high_school_field")
    private String highSchoolMajor;
}

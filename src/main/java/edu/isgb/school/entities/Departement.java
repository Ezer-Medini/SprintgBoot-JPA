package edu.isgb.school.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Departement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idDepartment;

    private String name;

    @ManyToOne
    @JoinColumn(name = "school_id")
    private School school;
}
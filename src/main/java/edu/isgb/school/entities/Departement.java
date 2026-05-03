package edu.isgb.school.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
    @JsonBackReference
    private School school;
}
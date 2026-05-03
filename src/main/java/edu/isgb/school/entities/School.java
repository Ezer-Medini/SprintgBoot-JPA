package edu.isgb.school.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@JsonPropertyOrder({"idSchool", "name", "phone", "departements"})
public class School {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idSchool;

    private String name;
    private Integer phone;

    @OneToMany(mappedBy = "school")
    @JsonManagedReference
    private List<Departement> departements;
}
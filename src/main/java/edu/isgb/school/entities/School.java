package edu.isgb.school.entities;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Entity
@Data
public class School {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idSchool;

    private String name;
    private Integer phone;

    @OneToMany(mappedBy = "school", cascade = CascadeType.ALL)
    private List<Departement> departements;

    @OneToMany(mappedBy = "school", cascade = CascadeType.ALL)
    private List<Student> students;
}
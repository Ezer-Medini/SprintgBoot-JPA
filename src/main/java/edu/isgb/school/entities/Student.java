package edu.isgb.school.entities;

import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;

@Entity
@Data
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idStudent;

    private String name;

    @Temporal(TemporalType.DATE)
    private Date birthDate;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private Adresse address;

    @ManyToOne
    @JoinColumn(name = "school_id")
    private School school;
}
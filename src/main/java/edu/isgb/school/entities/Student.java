package edu.isgb.school.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;

@Entity
@Data
@JsonPropertyOrder({"idStudent", "name", "birthDate", "address", "school"})
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
    @JsonIgnore
    private School school;
}
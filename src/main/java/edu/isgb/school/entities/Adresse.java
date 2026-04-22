package edu.isgb.school.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Adresse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idAddress;

    private String street;
    private String city;
    private String postalCode;
}
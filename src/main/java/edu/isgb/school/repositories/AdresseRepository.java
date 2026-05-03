package edu.isgb.school.repositories;

import edu.isgb.school.entities.Adresse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface AdresseRepository extends JpaRepository<Adresse, Integer> {

    List<Adresse> findByCityContainingIgnoreCase(String city);
}
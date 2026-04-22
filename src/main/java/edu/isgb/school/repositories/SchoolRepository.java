package edu.isgb.school.repositories;

import edu.isgb.school.entities.School;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface SchoolRepository extends JpaRepository<School, Integer> {

    List<School> findByNameContainingIgnoreCase(String name);
}
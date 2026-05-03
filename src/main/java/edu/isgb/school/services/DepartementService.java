package edu.isgb.school.services;

import edu.isgb.school.entities.Departement;
import edu.isgb.school.entities.School;
import edu.isgb.school.repositories.DepartementRepository;
import edu.isgb.school.repositories.SchoolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartementService {

    @Autowired
    private DepartementRepository departementRepo;

    @Autowired
    private SchoolRepository schoolRepo;

    public List<Departement> getAllDepartements() {
        return departementRepo.findAll();
    }

    public Optional<Departement> getDepartementById(Integer id) {
        return departementRepo.findById(id);
    }

    public Departement sauvegarderDepartement(Departement d) {

        if (d.getSchool() != null && d.getSchool().getIdSchool() != null) {
            School school = schoolRepo.findById(d.getSchool().getIdSchool())
                    .orElseThrow(() -> new RuntimeException("School not found"));

            d.setSchool(school);
        }

        return departementRepo.save(d);
    }

    public void supprimerDepartement(Integer id) {
        departementRepo.deleteById(id);
    }

    public List<Departement> rechercherDepartementsParNom(String name) {
        return departementRepo.findByNameContainingIgnoreCase(name);
    }
}
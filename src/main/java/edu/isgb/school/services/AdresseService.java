package edu.isgb.school.services;

import edu.isgb.school.entities.Adresse;
import edu.isgb.school.repositories.AdresseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdresseService {

    @Autowired
    private AdresseRepository adresseRepo;

    public List<Adresse> getAllAdresses() {
        return adresseRepo.findAll();
    }

    public Optional<Adresse> getAdresseById(Integer id) {
        return adresseRepo.findById(id);
    }

    public Adresse sauvegarderAdresse(Adresse a) {
        return adresseRepo.save(a);
    }

    public void supprimerAdresse(Integer id) {
        adresseRepo.deleteById(id);
    }

    public List<Adresse> rechercherAdressesParCity(String city) {
        return adresseRepo.findByCityContainingIgnoreCase(city);
    }
}
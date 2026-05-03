package edu.isgb.school.test;

import edu.isgb.school.entities.Adresse;
import edu.isgb.school.services.AdresseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/adresse")
public class AdresseController {

    @Autowired
    private AdresseService adresseService;

    @PostMapping("/addAdresse")
    public ResponseEntity<Adresse> createAdresse(@RequestBody Adresse a) {
        Adresse savedAdresse = adresseService.sauvegarderAdresse(a);
        return ResponseEntity.ok(savedAdresse);
    }

    @GetMapping("/allAdresses")
    public List<Adresse> getAllAdresses() {
        return adresseService.getAllAdresses();
    }

    @GetMapping("/adresse/{id}")
    public ResponseEntity<Adresse> getAdresseById(@PathVariable Integer id) {
        return adresseService.getAdresseById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/deleteAdresse/{id}")
    public ResponseEntity<Void> deleteAdresse(@PathVariable Integer id) {
        adresseService.supprimerAdresse(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/searchAdresse")
    public List<Adresse> searchAdresse(@RequestParam String city) {
        return adresseService.rechercherAdressesParCity(city);
    }
}
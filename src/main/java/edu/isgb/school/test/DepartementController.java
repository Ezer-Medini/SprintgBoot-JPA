package edu.isgb.school.test;

import edu.isgb.school.entities.Departement;
import edu.isgb.school.services.DepartementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/departement")
public class DepartementController {

    @Autowired
    private DepartementService departementService;

    @PostMapping("/addDepartement")
    public ResponseEntity<Departement> createDepartement(@RequestBody Departement d) {
        Departement savedDepartement = departementService.sauvegarderDepartement(d);
        return ResponseEntity.ok(savedDepartement);
    }

    @GetMapping("/allDepartements")
    public List<Departement> getAllDepartements() {
        return departementService.getAllDepartements();
    }

    @GetMapping("/departement/{id}")
    public ResponseEntity<Departement> getDepartementById(@PathVariable Integer id) {
        return departementService.getDepartementById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/deleteDepartement/{id}")
    public ResponseEntity<Void> deleteDepartement(@PathVariable Integer id) {
        departementService.supprimerDepartement(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/searchDepartement")
    public List<Departement> searchDepartement(@RequestParam String name) {
        return departementService.rechercherDepartementsParNom(name);
    }
}
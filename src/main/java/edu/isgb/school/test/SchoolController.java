package edu.isgb.school.test;

import edu.isgb.school.entities.School;
import edu.isgb.school.services.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/school")
public class SchoolController {

    @Autowired
    private SchoolService schoolService;

    @PostMapping("/addSchool")
    public ResponseEntity<School> createSchool(@RequestBody School s) {
        School savedSchool = schoolService.sauvegarderSchool(s);
        return ResponseEntity.ok(savedSchool);
    }

    @GetMapping("/allSchools")
    public List<School> getAllSchools() {
        return schoolService.getAllSchools();
    }

    @GetMapping("/school/{id}")
    public ResponseEntity<School> getSchoolById(@PathVariable Integer id) {
        return schoolService.getSchoolById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/deleteSchool/{id}")
    public ResponseEntity<Void> deleteSchool(@PathVariable Integer id) {
        schoolService.supprimerSchool(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/searchSchool")
    public List<School> searchSchool(@RequestParam String name) {
        return schoolService.rechercherSchoolsParNom(name);
    }
}
package edu.isgb.school.test;

import edu.isgb.school.entities.Departement;
import edu.isgb.school.entities.School;
import edu.isgb.school.entities.Student;
import edu.isgb.school.services.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/school")
public class TestSchoolController {

    @Autowired
    private SchoolService schoolService;

    // ================= TEST =================

    @GetMapping("/test")
    public String test() {
        return "OK";
    }

    // ================= SCHOOL =================

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

    // ================= STUDENT =================

    @PostMapping("/addStudent")
    public ResponseEntity<Student> createStudent(@RequestBody Student s) {
        Student savedStudent = schoolService.sauvegarderStudent(s);
        return ResponseEntity.ok(savedStudent);
    }

    @GetMapping("/allStudents")
    public List<Student> getAllStudents() {
        return schoolService.getAllStudents();
    }

    @GetMapping("/student/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Integer id) {
        return schoolService.getStudentById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/deleteStudent/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Integer id) {
        schoolService.supprimerStudent(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/searchStudent")
    public List<Student> searchStudent(@RequestParam String name) {
        return schoolService.rechercherStudentsParNom(name);
    }

    // ================= DEPARTEMENT =================

    @PostMapping("/addDepartement")
    public ResponseEntity<Departement> createDepartement(@RequestBody Departement d) {
        Departement savedDepartement = schoolService.sauvegarderDepartement(d);
        return ResponseEntity.ok(savedDepartement);
    }

    @GetMapping("/allDepartements")
    public List<Departement> getAllDepartements() {
        return schoolService.getAllDepartements();
    }

    @GetMapping("/departement/{id}")
    public ResponseEntity<Departement> getDepartementById(@PathVariable Integer id) {
        return schoolService.getDepartementById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/deleteDepartement/{id}")
    public ResponseEntity<Void> deleteDepartement(@PathVariable Integer id) {
        schoolService.supprimerDepartement(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/searchDepartement")
    public List<Departement> searchDepartement(@RequestParam String name) {
        return schoolService.rechercherDepartementsParNom(name);
    }
}
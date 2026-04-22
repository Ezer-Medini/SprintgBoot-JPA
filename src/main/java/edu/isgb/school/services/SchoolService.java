package edu.isgb.school.services;

import edu.isgb.school.entities.Departement;
import edu.isgb.school.entities.School;
import edu.isgb.school.entities.Student;
import edu.isgb.school.repositories.DepartementRepository;
import edu.isgb.school.repositories.SchoolRepository;
import edu.isgb.school.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SchoolService {

    @Autowired
    private StudentRepository studentRepo;

    @Autowired
    private SchoolRepository schoolRepo;

    @Autowired
    private DepartementRepository departementRepo;

    // ================= SCHOOL =================

    public List<School> getAllSchools() {
        return schoolRepo.findAll();
    }

    public Optional<School> getSchoolById(Integer id) {
        return schoolRepo.findById(id);
    }

    public School sauvegarderSchool(School s) {
        return schoolRepo.save(s);
    }

    public void supprimerSchool(Integer id) {
        schoolRepo.deleteById(id);
    }

    public List<School> rechercherSchoolsParNom(String name) {
        return schoolRepo.findByNameContainingIgnoreCase(name);
    }

    // ================= STUDENT =================

    public List<Student> getAllStudents() {
        return studentRepo.findAll();
    }

    public Optional<Student> getStudentById(Integer id) {
        return studentRepo.findById(id);
    }

    public Student sauvegarderStudent(Student s) {
        return studentRepo.save(s);
    }

    public void supprimerStudent(Integer id) {
        studentRepo.deleteById(id);
    }

    public List<Student> rechercherStudentsParNom(String name) {
        return studentRepo.findByNameContainingIgnoreCase(name);
    }

    // ================= DEPARTEMENT =================

    public List<Departement> getAllDepartements() {
        return departementRepo.findAll();
    }

    public Optional<Departement> getDepartementById(Integer id) {
        return departementRepo.findById(id);
    }

    public Departement sauvegarderDepartement(Departement d) {
        return departementRepo.save(d);
    }

    public void supprimerDepartement(Integer id) {
        departementRepo.deleteById(id);
    }

    public List<Departement> rechercherDepartementsParNom(String name) {
        return departementRepo.findByNameContainingIgnoreCase(name);
    }
}
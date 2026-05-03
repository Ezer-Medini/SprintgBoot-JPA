package edu.isgb.school.services;

import edu.isgb.school.entities.Student;
import edu.isgb.school.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepo;

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
}
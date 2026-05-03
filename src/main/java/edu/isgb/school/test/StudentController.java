package edu.isgb.school.test;

import edu.isgb.school.entities.Student;
import edu.isgb.school.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/addStudent")
    public ResponseEntity<Student> createStudent(@RequestBody Student s) {
        Student savedStudent = studentService.sauvegarderStudent(s);
        return ResponseEntity.ok(savedStudent);
    }

    @GetMapping("/allStudents")
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/student/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Integer id) {
        return studentService.getStudentById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/deleteStudent/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Integer id) {
        studentService.supprimerStudent(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/searchStudent")
    public List<Student> searchStudent(@RequestParam String name) {
        return studentService.rechercherStudentsParNom(name);
    }
}
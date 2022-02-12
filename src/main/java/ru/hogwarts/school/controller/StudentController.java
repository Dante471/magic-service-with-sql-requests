package ru.hogwarts.school.controller;

import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.service.StudentService;

import java.util.Collection;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/student")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public Student createStudent(@RequestBody Student student) {
        return studentService.addStudent(student);
    }

    @GetMapping()
    public Student getStudent(@RequestParam Long studentId) {
        return studentService.getStudentById(studentId);
    }

    @PutMapping
    public Student updateStudent(@RequestBody Student student) {
        return studentService.updateStudent(student);
    }

    @DeleteMapping("{studentId}")
    public Student deleteStudent(@PathVariable Long studentId) {
        return studentService.deleteStudent(studentId);
    }

    @GetMapping("{age}")
    public Collection<Student> getStudentsByAge(@PathVariable Integer age) {
        return studentService.getAll().stream()
                .filter(student -> student.getAge() == age)
                .collect(Collectors.toList());
    }

    @GetMapping("{age1}, {age2}")
    public Collection<Student> getStudentsByAgeInterval(@PathVariable int age1, @PathVariable int age2) {
        return studentService.getStudentsByAgeInterval(age1, age2);
    }


}

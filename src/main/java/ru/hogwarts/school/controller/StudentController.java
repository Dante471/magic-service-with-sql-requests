package ru.hogwarts.school.controller;

import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.service.StudentService;

import java.util.Collection;
import java.util.Optional;
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

    @GetMapping
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
        return studentService.getStudentsByAge(age);
    }

    @GetMapping("/age-between")
    public Collection<Student> getStudentsByAgeInterval(@RequestParam int age1, @RequestParam int age2) {
        return studentService.getStudentsByAgeInterval(age1, age2);
    }

    @GetMapping("/number")
    public Integer amountOfStudents() {
        return studentService.getNumberOfStudents();
    }

    @GetMapping("/average-age")
    public Integer averageStudentsAge() {
        return studentService.getAverageStudentAge();
    }

    @GetMapping("/five-last")
    public Collection<Student> fiveLastStudents() {
        return studentService.getLastFiveStudents();
    }


}

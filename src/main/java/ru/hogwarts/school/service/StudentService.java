package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.repository.StudentRepository;

import java.util.Collection;
import java.util.Optional;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }

    public Optional<Student> getStudentById(Long studentId) {
        return studentRepository.findById(studentId);
    }

    public Student updateStudent(Student student) {
        return studentRepository.save(student);
    }

    public Student deleteStudent(Long studentId) {
        Student studentToRemove = studentRepository.getById(studentId);
        studentRepository.deleteById(studentId);
        return studentToRemove;
    }

    public Collection<Student> getStudentsByAge(int age) {
        return studentRepository.findStudentsByAge(age);
    }

    public Collection<Student> getStudentsByAgeInterval(int start, int end) {
        return studentRepository.findStudentsByAgeBetween(start, end);
    }
}

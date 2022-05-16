package ru.hogwarts.school.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.repository.StudentRepository;

import java.util.Collection;

@Service
public class StudentService {

    private final Logger logger = LoggerFactory.getLogger(StudentService.class);

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student addStudent(Student student) {
        logger.info("A method was called to add a student");
        return studentRepository.save(student);
    }

    public Student getStudentById(Long studentId) {
        logger.info("A method was called to get student by id");
        return studentRepository.findById(studentId).orElseThrow();
    }

    public Student updateStudent(Student student) {
        logger.info("A method was called to update the student");
        return studentRepository.save(student);
    }

    public Student deleteStudent(Long studentId) {
        logger.info("A method was called to delete the student by id");
        Student studentToRemove = studentRepository.getById(studentId);
        studentRepository.deleteById(studentId);
        return studentToRemove;
    }

    public Collection<Student> getStudentsByAge(int age) {
        logger.info("A method was called to get students by age");
        return studentRepository.findStudentsByAge(age);
    }

    public Collection<Student> getStudentsByAgeInterval(int start, int end) {
        logger.info("A method was called to get students by age interval");
        return studentRepository.findStudentsByAgeBetween(start, end);
    }

    public Integer getNumberOfStudents() {
        logger.info("A method was called to number of students");
        return studentRepository.getNumberOfStudents();
    }

    public Integer getAverageStudentAge() {
        logger.info("A method was called to get average students age");
        return studentRepository.getAverageStudentAge();
    }

    public Collection<Student> getLastFiveStudents() {
        logger.info("A method was called to get last five students");
        return studentRepository.getLastFiveStudents();
    }
}

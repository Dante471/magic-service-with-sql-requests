package ru.hogwarts.school.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.hogwarts.school.model.Student;

import java.util.Collection;

public interface StudentRepository extends JpaRepository<Student, Long> {

    Collection<Student> findStudentsByAgeBetween(int age, int age2);
    Collection<Student> findStudentsByAge(int age);

    @Query(value = "SELECT COUNT (*) FROM student", nativeQuery = true)
    Integer getNumberOfStudents();
    @Query(value = "SELECT AVG(age) FROM student", nativeQuery = true)
    Integer getAverageStudentAge();
    @Query(value = "SELECT * FROM student ORDER BY id DESC LIMIT 5", nativeQuery = true)
    Collection<Student> getLastFiveStudents();
}

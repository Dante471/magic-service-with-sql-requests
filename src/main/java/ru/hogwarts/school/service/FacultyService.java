package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.repository.FacultyRepository;

import java.util.Collection;
import java.util.Optional;

@Service
public class FacultyService {
    private final FacultyRepository facultyRepository;

    public FacultyService(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }

    public Faculty addFaculty(Faculty faculty) {
        return facultyRepository.save(faculty);
    }

    public Faculty getFacultyById(Long facultyId) {
        return facultyRepository.findById(facultyId).orElseThrow();
    }

    public Faculty updateFaculty(Faculty faculty) {
        return facultyRepository.save(faculty);
    }

    public Faculty deleteFaculty(Long facultyId) {
       Faculty facultyToRemove = facultyRepository.getById(facultyId);
       facultyRepository.deleteById(facultyId);
       return facultyToRemove;
    }

    public Collection<Faculty> getFacultyByName(String name) {
        return facultyRepository.findFacultyByName(name);
    }

    public Collection<Faculty> getFacultyByColor(String color) {
        return facultyRepository.findFacultyByColor(color);
    }
}

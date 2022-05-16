package ru.hogwarts.school.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.repository.FacultyRepository;

import java.util.Collection;
import java.util.Optional;

@Service
public class FacultyService {
    private final FacultyRepository facultyRepository;

    private final Logger logger = LoggerFactory.getLogger(FacultyService.class);

    public FacultyService(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }

    public Faculty addFaculty(Faculty faculty) {
        logger.info("A method was called to add a faculty");
        return facultyRepository.save(faculty);
    }

    public Faculty getFacultyById(Long facultyId) {
        logger.info("A method was called to get faculty by id");
        return facultyRepository.findById(facultyId).orElseThrow();
    }

    public Faculty updateFaculty(Faculty faculty) {
        logger.info("A method was called to update the faculty");
        return facultyRepository.save(faculty);
    }

    public Faculty deleteFaculty(Long facultyId) {
        logger.info("A method was called to delete the faculty by id");
        Faculty facultyToRemove = facultyRepository.getById(facultyId);
        facultyRepository.deleteById(facultyId);
        return facultyToRemove;
    }

    public Collection<Faculty> getFacultyByName(String name) {
        logger.info("A method was called to get faculties by name");
        return facultyRepository.findFacultyByName(name);
    }

    public Collection<Faculty> getFacultyByColor(String color) {
        logger.info("A method was called to get faculties by color");
        return facultyRepository.findFacultyByColor(color);
    }
}

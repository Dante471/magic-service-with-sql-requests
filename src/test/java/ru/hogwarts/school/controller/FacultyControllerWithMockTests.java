package ru.hogwarts.school.controller;

import net.minidev.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.service.FacultyService;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
public class FacultyControllerWithMockTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private FacultyService facultyService;

    @Test
    public void getFacultyInfoTest() throws Exception {
        final String name1 = "Gryffindor";
        final String color1 = "red";
        final long id1 = 1;
        final String name2 = "Hufflepuff";
        final String color2 = "yellow";
        final long id2 = 2;
        final List<Faculty> faculties = new ArrayList<>();

        Faculty faculty = new Faculty();
        faculty.setId(id1);
        faculty.setName(name1);
        faculty.setColor(color1);

        faculties.add(faculty);

        //when(facultyRepository.findFacultyByColor(color)).thenReturn(faculties);
        //when(facultyRepository.findFacultyByName(name)).thenReturn(faculties);
        when(facultyService.getFacultyById(any(Long.class))).thenReturn(faculty);

        mockMvc.perform(MockMvcRequestBuilders
                        .get("/faculty?facultyId=0")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(id1))
                .andExpect(jsonPath("$.name").value(name1))
                .andExpect(jsonPath("$.color").value(color1));

    }
}

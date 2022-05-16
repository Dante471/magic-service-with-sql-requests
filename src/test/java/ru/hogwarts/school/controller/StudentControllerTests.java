package ru.hogwarts.school.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;


import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class StudentControllerTests {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    public void shouldReturnStudent() {
        assertNotNull(testRestTemplate.getForObject("http://localhost:" + port + "/student", String.class));
    }

    @Test
    public void shouldReturnStudentsByAge() {
        assertNotNull(testRestTemplate.getForObject("http://localhost:" + port + "/student/{age}", String.class, 10));
    }

    @Test
    public void shouldReturnStudentsByAgeBetween() {
        assertNotNull(testRestTemplate.getForObject("http://localhost:" + port + "/student/age-between/?age1=10?age2=20", String.class));
    }




}

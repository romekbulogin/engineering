package ru.edu.studentservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.edu.studentservice.entity.StudentEntity;
import ru.edu.studentservice.service.StudentService;

import java.util.UUID;

@RestController
@RequestMapping("/api/student")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/find/{id}")
    public StudentEntity findById(@PathVariable String id) {
        return studentService.findById(UUID.fromString(id));
    }
}

package ru.edu.studentservice.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ru.edu.studentservice.entity.StudentEntity;
import ru.edu.studentservice.repository.StudentRepository;

import java.util.Optional;
import java.util.UUID;

@Service
public class StudentService {
    private final Logger logger = LoggerFactory.getLogger(StudentService.class);
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    public StudentEntity findById(UUID id) {
        logger.info("[FIND BY ID] ID: " + id);
        Optional<StudentEntity> studentEntity = studentRepository.findById(id);
        if (studentEntity.isEmpty()) {
            logger.error("Student not found");
            throw new RuntimeException("Student not found");
        }
        return studentEntity.get();
    }
}

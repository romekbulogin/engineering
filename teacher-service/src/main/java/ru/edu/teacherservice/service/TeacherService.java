package ru.edu.teacherservice.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ru.edu.teacherservice.repository.TeacherRepository;

@Service
public class TeacherService {
    private final Logger logger = LoggerFactory.getLogger(TeacherService.class);
    private final TeacherRepository teacherRepository;

    public TeacherService(
            TeacherRepository teacherRepository
    ) {
        this.teacherRepository = teacherRepository;
    }
}

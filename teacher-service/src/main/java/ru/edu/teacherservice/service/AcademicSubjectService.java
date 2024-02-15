package ru.edu.teacherservice.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ru.edu.teacherservice.repository.AcademicSubjectRepository;

@Service
public class AcademicSubjectService {
    private final Logger logger = LoggerFactory.getLogger(TeacherService.class);
    private final AcademicSubjectRepository academicSubjectRepository;

    public AcademicSubjectService(
            AcademicSubjectRepository academicSubjectRepository
    ) {
        this.academicSubjectRepository = academicSubjectRepository;
    }
}

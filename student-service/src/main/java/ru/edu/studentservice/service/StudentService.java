package ru.edu.studentservice.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ru.edu.studentservice.entity.StudentEntity;
import ru.edu.studentservice.entity.StudyGroupEntity;
import ru.edu.studentservice.repository.StudentRepository;
import ru.edu.studentservice.repository.StudyGroupRepository;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class StudentService {
    private final Logger logger = LoggerFactory.getLogger(StudentService.class);
    private final StudentRepository studentRepository;
    private final StudyGroupRepository studyGroupRepository;

    public StudentService(
            StudentRepository studentRepository,
            StudyGroupRepository studyGroupRepository
    ) {
        this.studentRepository = studentRepository;
        this.studyGroupRepository = studyGroupRepository;
    }

    public StudentEntity findById(UUID id) {
        logger.info("[FIND BY ID] ID: {}", id);
        Optional<StudentEntity> studentEntity = studentRepository.findById(id);
        if (studentEntity.isEmpty()) {
            logger.error("Student not found");
            throw new RuntimeException("Student not found");
        }
        return studentEntity.get();
    }

    public List<StudentEntity> findAllStudentByTitleAndCourseAndNumber(
            String title,
            Integer course,
            Integer number
    ) {
        logger.info(
                "[FIND ALL STUDENTS IN GROUP]: TITLE: {} COURSE: {} NAME: {}",
                title, course, number
        );
        StudyGroupEntity studyGroup =
                studyGroupRepository
                        .findByTitleAndCourseAndNumber(title, course, number);
        return studentRepository.findAllByStudyGroup(studyGroup);
    }
}

package ru.edu.teacherservice.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ru.edu.teacherservice.entity.AcademicSubjectEntity;
import ru.edu.teacherservice.entity.TeacherEntity;
import ru.edu.teacherservice.repository.TeacherRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TeacherService {
    private final Logger logger = LoggerFactory.getLogger(TeacherService.class);
    private final TeacherRepository teacherRepository;
    private final AcademicSubjectService academicSubjectService;

    public TeacherService(
            TeacherRepository teacherRepository,
            AcademicSubjectService academicSubjectService
    ) {
        this.teacherRepository = teacherRepository;
        this.academicSubjectService = academicSubjectService;
    }

    public List<TeacherEntity> findAll() {
        return teacherRepository.findAll();
    }

    public TeacherEntity findById(UUID id) {
        logger.info("[FIND TEACHER BY ID]: id={}", id);
        Optional<TeacherEntity> teacher = teacherRepository.findById(id);
        if (teacher.isEmpty()) {
            logger.error("[FIND TEACHER BY ID]: id={} not found", id);
            throw new RuntimeException("Teacher not found");
        }
        return teacher.get();
    }

    public TeacherEntity save(TeacherEntity teacher) {
        logger.info("[SAVE TEACHER]: {}", teacher);
        return teacherRepository.save(teacher);
    }

    public TeacherEntity addNewAcademicSubjectToTeacher(
            UUID teacherId,
            UUID academicSubjectId
    ) {
        logger.info(
                "[ADD NEW ACADEMIC SUBJECT TO TEACHER]: " +
                        "Teacher id={} AcademicSubject id={}",
                teacherId, academicSubjectId
        );
        TeacherEntity teacher = findById(teacherId);
        AcademicSubjectEntity academicSubject =
                academicSubjectService.findById(academicSubjectId);

        teacher.setAcademicSubject(List.of(academicSubject));
        return teacherRepository.save(teacher);
    }

    public TeacherEntity deleteAcademicSubjectFromTeacher(
            UUID teacherId,
            UUID academicSubjectId
    ) {
        logger.info(
                "[DELETE ACADEMIC SUBJECT FROM TEACHER]: " +
                        "Teacher id={} AcademicSubject id={}",
                teacherId, academicSubjectId
        );

        TeacherEntity teacher = findById(teacherId);
        AcademicSubjectEntity academicSubject =
                academicSubjectService.findById(academicSubjectId);

        teacher
                .getAcademicSubjects()
                .remove(academicSubject);
        return teacherRepository.save(teacher);
    }
}

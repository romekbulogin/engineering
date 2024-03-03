package ru.edu.teacherservice.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ru.edu.teacherservice.entity.AcademicSubjectEntity;
import ru.edu.teacherservice.entity.TeacherEntity;
import ru.edu.teacherservice.repository.AcademicSubjectRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AcademicSubjectService {
    private final Logger logger = LoggerFactory.getLogger(TeacherService.class);
    private final AcademicSubjectRepository academicSubjectRepository;
    private final TeacherService teacherService;

    public AcademicSubjectService(
            AcademicSubjectRepository academicSubjectRepository,
            TeacherService teacherService
    ) {
        this.academicSubjectRepository = academicSubjectRepository;
        this.teacherService = teacherService;
    }

    public List<AcademicSubjectEntity> findAll() {
        logger.info("[FIND ALL ACADEMIC SUBJECT]");
        return academicSubjectRepository.findAll();
    }

    public AcademicSubjectEntity findById(UUID id) {
        logger.info("[FIND ACADEMIC SUBJECT BY ID]: id={}", id);
        Optional<AcademicSubjectEntity> academicSubject =
                academicSubjectRepository.findById(id);
        if (academicSubject.isEmpty()) {
            logger.error("[FIND ACADEMIC SUBJECT BY ID]: id={} not found", id);
            throw new RuntimeException("Academic Subject is null");
        }
        return academicSubject.get();
    }

    public AcademicSubjectEntity save(AcademicSubjectEntity academicSubject) {
        logger.info("[SAVE ACADEMIC SUBJECT]: {}", academicSubject);
        return academicSubjectRepository.save(academicSubject);
    }

    public List<TeacherEntity> findTeachersEntityByAcademicSubjectEntityId(UUID id) {
        logger.info("[FIND TEACHERS BY ACADEMIC SUBJECT ID] id={}", id);
        return findById(id).getTeachers();
    }

    public AcademicSubjectEntity addNewTeacherToAcademicSubject(
            UUID teacherId,
            UUID academicSubjectId
    ) {
        logger.info(
                "[ADD NEW TEACHER TO ACADEMIC SUBJECT]: " +
                        "Teacher id={} AcademicSubject id={}",
                teacherId, academicSubjectId
        );
        TeacherEntity teacher = teacherService.findById(teacherId);
        AcademicSubjectEntity academicSubject =
                findById(academicSubjectId);

        academicSubject.setTeacher(List.of(teacher));
        return academicSubjectRepository.save(academicSubject);
    }

    public AcademicSubjectEntity deleteTeacherFromAcademicSubject(
            UUID teacherId,
            UUID academicSubjectId
    ) {
        logger.info(
                "[DELETE TEACHER TO ACADEMIC SUBJECT]: " +
                        "Teacher id={} AcademicSubject id={}",
                teacherId, academicSubjectId
        );

        TeacherEntity teacher = teacherService.findById(teacherId);
        AcademicSubjectEntity academicSubject =
                findById(academicSubjectId);

        academicSubject
                .getTeachers()
                .remove(teacher);
        return academicSubjectRepository.save(academicSubject);
    }
}

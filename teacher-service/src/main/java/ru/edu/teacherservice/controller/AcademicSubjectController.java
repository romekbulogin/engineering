package ru.edu.teacherservice.controller;

import org.springframework.web.bind.annotation.*;
import ru.edu.teacherservice.entity.AcademicSubjectEntity;
import ru.edu.teacherservice.entity.TeacherEntity;
import ru.edu.teacherservice.service.AcademicSubjectService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/academic_subject")
public class AcademicSubjectController {
    private final AcademicSubjectService academicSubjectService;

    public AcademicSubjectController(
            AcademicSubjectService academicSubjectService
    ) {
        this.academicSubjectService = academicSubjectService;
    }

    @GetMapping("/find_all")
    List<AcademicSubjectEntity> findAll() {
        return academicSubjectService.findAll();
    }

    @GetMapping("/find_by_id")
    AcademicSubjectEntity findById(@RequestParam String id) {
        return academicSubjectService.findById(UUID.fromString(id));
    }

    @PostMapping("/save")
    AcademicSubjectEntity save(
            @RequestBody AcademicSubjectEntity academicSubject
    ) {
        return academicSubjectService.save(academicSubject);
    }

    @GetMapping("/find_teacher")
    List<TeacherEntity> findTeachersEntityByAcademicSubjectEntityId(
            @RequestParam String academicSubjectId
    ) {
        return academicSubjectService
                .findTeachersEntityByAcademicSubjectEntityId(
                        UUID.fromString(academicSubjectId)
                );
    }

    @PostMapping("/teacher")
    AcademicSubjectEntity addNewTeacherToAcademicSubject(
            @RequestParam String teacherId,
            @RequestParam String academicSubjectId
    ) {
        return academicSubjectService
                .addNewTeacherToAcademicSubject(
                        UUID.fromString(teacherId),
                        UUID.fromString(academicSubjectId)
                );
    }

    @DeleteMapping("/teacher")
    AcademicSubjectEntity deleteTeacherFromAcademicSubject(
            @RequestParam String teacherId,
            @RequestParam String academicSubjectId
    ) {
        return academicSubjectService
                .deleteTeacherFromAcademicSubject(
                        UUID.fromString(teacherId),
                        UUID.fromString(academicSubjectId)
                );
    }
}

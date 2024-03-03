package ru.edu.teacherservice.controller;

import org.springframework.web.bind.annotation.*;
import ru.edu.teacherservice.entity.TeacherEntity;
import ru.edu.teacherservice.service.TeacherService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/teacher")
public class TeacherController {
    private final TeacherService teacherService;

    public TeacherController(
            TeacherService teacherService
    ) {
        this.teacherService = teacherService;
    }

    @GetMapping("/find_all")
    List<TeacherEntity> findAll() {
        return teacherService.findAll();
    }

    @GetMapping("/find_by_id")
    TeacherEntity findById(@RequestParam String id) {
        return teacherService.findById(UUID.fromString(id));
    }

    @PostMapping("/save")
    TeacherEntity save(@RequestBody TeacherEntity teacher) {
        return teacherService.save(teacher);
    }

    @PostMapping("/academic_subject")
    TeacherEntity addNewAcademicSubjectToTeacher(
            @RequestParam String teacherId,
            @RequestParam String academicSubjectId
    ) {
        return teacherService.addNewAcademicSubjectToTeacher(
                UUID.fromString(teacherId),
                UUID.fromString(academicSubjectId)
        );
    }

    @DeleteMapping("/academic_subject")
    TeacherEntity deleteAcademicSubjectFromTeacher(
            @RequestParam String teacherId,
            @RequestParam String academicSubjectId
    ) {
        return teacherService.deleteAcademicSubjectFromTeacher(
                UUID.fromString(teacherId),
                UUID.fromString(academicSubjectId)
        );
    }
}

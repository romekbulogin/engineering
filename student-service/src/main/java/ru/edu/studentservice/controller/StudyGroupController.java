package ru.edu.studentservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.edu.studentservice.entity.StudentEntity;
import ru.edu.studentservice.entity.StudyGroupEntity;
import ru.edu.studentservice.service.StudentService;
import ru.edu.studentservice.service.StudyGroupService;

import java.util.List;

@RestController
@RequestMapping("/api/study_group")
public class StudyGroupController {
    private final StudyGroupService studyGroupService;
    private final StudentService studentService;

    public StudyGroupController(
            StudyGroupService studyGroupService,
            StudentService studentService
    ) {
        this.studyGroupService = studyGroupService;
        this.studentService = studentService;
    }

    @GetMapping("/find")
    public StudyGroupEntity findByTitleAndCourseAndNumber(
            @RequestParam String title,
            @RequestParam Integer course,
            @RequestParam Integer number
    ) {
        return studyGroupService.findByTitleAndCourseAndNumber(
                title,
                course,
                number
        );
    }

    @GetMapping("/find/all")
    public List<StudyGroupEntity> findAll() {
        return studyGroupService.findAll();
    }

    @GetMapping("/students")
    public List<StudentEntity> findAllStudentByTitleAndCourseAndNumber(
            @RequestParam String title,
            @RequestParam Integer course,
            @RequestParam Integer number
    ) {
        return studentService.
                findAllStudentByTitleAndCourseAndNumber(
                        title, course, number
                );
    }
}

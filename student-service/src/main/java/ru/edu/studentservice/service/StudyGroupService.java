package ru.edu.studentservice.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ru.edu.studentservice.entity.StudyGroupEntity;
import ru.edu.studentservice.repository.StudyGroupRepository;

import java.util.List;

@Service
public class StudyGroupService {
    private final Logger logger = LoggerFactory.getLogger(StudentService.class);
    private final StudyGroupRepository studyGroupRepository;

    public StudyGroupService(StudyGroupRepository studyGroupRepository) {
        this.studyGroupRepository = studyGroupRepository;
    }

    public StudyGroupEntity findByTitleAndCourseAndNumber(
            String title,
            Integer course,
            Integer number
    ) {
        logger.info(
                "[FIND GROUP BY TITLE AND COURSE AND NUMBER] TITLE: {} COURSE: {} NUMBER: {}",
                title, course, number
        );
        return studyGroupRepository.findByTitleAndCourseAndNumber(
                title,
                course,
                number
        );
    }

    public List<StudyGroupEntity> findAll() {
        logger.info("[FIND ALL GROUP]");
        return studyGroupRepository.findAll();
    }
}

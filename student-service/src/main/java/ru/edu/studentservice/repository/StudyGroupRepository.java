package ru.edu.studentservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.edu.studentservice.entity.StudyGroupEntity;

import java.util.UUID;

@Repository
public interface StudyGroupRepository extends JpaRepository<StudyGroupEntity, UUID> {
    StudyGroupEntity findByTitleAndCourseAndNumber(
            String title,
            Integer course,
            Integer number
    );
}

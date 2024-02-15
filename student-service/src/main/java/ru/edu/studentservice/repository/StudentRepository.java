package ru.edu.studentservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.edu.studentservice.entity.StudentEntity;
import ru.edu.studentservice.entity.StudyGroupEntity;

import java.util.List;
import java.util.UUID;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity, UUID> {
    List<StudentEntity> findAllByStudyGroup(StudyGroupEntity studyGroup);
}

package ru.edu.teacherservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.edu.teacherservice.entity.TeacherEntity;

import java.util.UUID;

@Repository
public interface TeacherRepository extends JpaRepository<TeacherEntity, UUID> {
}

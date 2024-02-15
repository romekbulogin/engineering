package ru.edu.teacherservice.entity;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "academic_subject")
public class AcademicSubjectEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String title;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}

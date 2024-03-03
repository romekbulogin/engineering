package ru.edu.teacherservice.entity;

import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "teacher")
public class TeacherEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String lastname;
    private String firstname;
    private String surname;
    private Integer experience;
    @ManyToMany
    private List<AcademicSubjectEntity> academicSubjects;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Integer getExperience() {
        return experience;
    }

    public void setExperience(Integer experience) {
        this.experience = experience;
    }

    public List<AcademicSubjectEntity> getAcademicSubjects() {
        return academicSubjects;
    }

    public void setAcademicSubject(List<AcademicSubjectEntity> academicSubjects) {
        this.academicSubjects = academicSubjects;
    }
}

package ru.edu.studentservice.entity;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "student")
public class StudentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String lastname;
    private String firstname;
    private String surname;
    @OneToOne
    @JoinColumn(name = "group_id", referencedColumnName = "id")
    private StudyGroupEntity studyGroup;
    @Enumerated(EnumType.STRING)
    private StudentStatus status;

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

    public StudyGroupEntity getStudyGroupId() {
        return studyGroup;
    }

    public void setGroupId(StudyGroupEntity studyGroup) {
        this.studyGroup = studyGroup;
    }

    public StudentStatus getStatus() {
        return status;
    }

    public void setStatus(StudentStatus status) {
        this.status = status;
    }
}

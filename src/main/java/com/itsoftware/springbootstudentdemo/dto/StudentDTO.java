package com.itsoftware.springbootstudentdemo.dto;

import java.time.LocalDate;

public class StudentDTO {
    private String name;
    private int studentBookNumber;
    private LocalDate dateOfBirth;

    public StudentDTO(String name, int studentBookNumber, LocalDate dateOfBirth) {
        this.name = name;
        this.studentBookNumber = studentBookNumber;
        this.dateOfBirth = dateOfBirth;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStudentBookNumber() {
        return studentBookNumber;
    }

    public void setStudentBookNumber(int studentBookNumber) {
        this.studentBookNumber = studentBookNumber;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}

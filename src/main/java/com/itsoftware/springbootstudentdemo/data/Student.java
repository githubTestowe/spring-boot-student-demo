package com.itsoftware.springbootstudentdemo.data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Student {
    @Id
    @SequenceGenerator(name = "student_sequence", sequenceName = "student_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_sequence")
    private long id;
    private String name;
    private int studentBookNumber;
    private LocalDate dateOfBirth;

    public Student() {
    }

    public Student(long id, String name, int studentBookNumber, LocalDate dateOfBirth) {
        this.id = id;
        this.name = name;
        this.studentBookNumber = studentBookNumber;
        this.dateOfBirth = dateOfBirth;
    }

    public Student(String name, int studentBookNumber, LocalDate dateOfBirth) {
        this.name = name;
        this.studentBookNumber = studentBookNumber;
        this.dateOfBirth = dateOfBirth;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", studentBookNumber=" + studentBookNumber +
                ", dateOfBirth=" + dateOfBirth +
                '}';
    }


}

package com.itsoftware.springbootstudentdemo.service;

import com.itsoftware.springbootstudentdemo.data.Student;
import com.itsoftware.springbootstudentdemo.dto.StudentDTO;
import com.itsoftware.springbootstudentdemo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student getStudentById(long studentId) {
        return studentRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Not Found"));
    }

    public Student getStudentByName(String studentName) {
        return studentRepository.findStudentByName(studentName)
                .orElseThrow(() -> new RuntimeException("Not Found"));
    }

    public Student getStudentByStudentBookNumber(int studentBookNumber) {
        return studentRepository.findStudentByStudentBookNumber(studentBookNumber)
                .orElseThrow(() -> new RuntimeException("Not Found"));
    }

    public long saveStudent(Student student) {
        Optional<Student> studentOptional = studentRepository
                .findStudentByStudentBookNumber(student.getStudentBookNumber());
        if (studentOptional.isPresent()) {
            throw new IllegalStateException("Student book number has already exists. Use different student book number.");
        }
        return studentRepository.save(student).getId();
    }

    public Student updateStudentById(long studentId, StudentDTO studentDTO) {
        return studentRepository.findById(studentId)
                .map(student -> updateStudent(student, studentDTO))
                .orElseThrow(() -> new RuntimeException("Not Found"));
    }

    private Student updateStudent(Student student, StudentDTO studentDTO) {
        student.setName(studentDTO.getName());
        student.setStudentBookNumber(studentDTO.getStudentBookNumber());
        student.setDateOfBirth(studentDTO.getDateOfBirth());
        return studentRepository.save(student);
    }
}

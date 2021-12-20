package com.itsoftware.springbootstudentdemo.configuration;

import com.itsoftware.springbootstudentdemo.data.Student;
import com.itsoftware.springbootstudentdemo.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository) {
        return args -> {
            Student janKowalski = new Student(
                    "Jan Kowalski",
                    20890,
                    LocalDate.of(2001, Month.FEBRUARY, 23));
            Student adamNowak = new Student(
                    "Adam Nowak",
                    20901,
                    LocalDate.of(2003, Month.MARCH, 8));

            studentRepository.saveAll(List.of(janKowalski, adamNowak));
        };
    }
}

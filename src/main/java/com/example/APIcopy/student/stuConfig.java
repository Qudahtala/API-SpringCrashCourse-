package com.example.API.student;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import static java.time.Month.*;

@Configuration
public class stuConfig {
    @Bean
    CommandLineRunner commandLineRunner(
            studentRepository repository){
        return args -> {
            student tala = new student(
                    "Tala",
                    "talaqudah@gmail.com",
                    LocalDate.of(2020, AUGUST, 15)
            );
            student leen = new student(
                    "Leen",
                    "jaberleen@gmail.com",
                    LocalDate.of(1973, AUGUST, 15)
            );
            student nadia = new student(
                    "Nadia",
                    "nadiasharia@gmail.com",
                    LocalDate.of(1988, AUGUST, 15)
            );
            repository.saveAll(
                    List.of(tala,leen,nadia)
            );
        };
    }
}

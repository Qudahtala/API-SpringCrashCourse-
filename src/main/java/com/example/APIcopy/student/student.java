package com.example.API.student;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.Period;

@Entity
@Table
public class student {
    @Id
    @SequenceGenerator(name ="student_sequence",
    sequenceName = "student_sequence",
    allocationSize=1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )
    private Long id;
    private String name;
    private String email;
    private LocalDate BD;
    @Transient
    private Integer age;

    public student() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setBD(LocalDate BD) {
        this.BD = BD;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public student(Long id,
                   String name,
                   String email,
                   LocalDate BD) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.BD = BD;
    }
//one without the PK; the database will generate the id for us
    public student(String name,
                   String email,
                   LocalDate BD) {
        this.name = name;
        this.email = email;
        this.BD = BD;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public LocalDate getBD() {
        return BD;
    }

    public Integer getAge() {

        return Period.between(BD,LocalDate.now()).getYears();
    }

    @Override
    public String toString() {
        return "student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", BD=" + BD +
                ", age=" + age +
                '}';
    }


}

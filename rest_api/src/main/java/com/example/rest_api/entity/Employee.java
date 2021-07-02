package com.example.rest_api.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Long id;

    @Column(name="name")
    @Getter @Setter
    private String name;

    @Column(name="email")
    @Getter @Setter
    private String email;

    @Column(name="role")
    @Getter @Setter
    private String role;

    @Column(name="age")
    @Getter @Setter
    private int age;

    @Column(name="gender")
    @Getter @Setter
    private char gender;

    @Column(name="dob")
    @Getter @Setter
    private Date dob;
}

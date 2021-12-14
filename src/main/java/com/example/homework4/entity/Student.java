package com.example.homework4.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String firstName;

    @Column(name = "surname")
    private String lastName;

    @Column(name = "date_of_birth")
    private String birthday;

    @Email
    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phoneNumber;

    @ManyToOne
    @JoinColumn(name = "id_group")
    private StudentGroup groupID;
}

package com.example.LibraryManagementSystemSpring.model;

import com.example.LibraryManagementSystemSpring.enums.StudentBranch;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "student_info")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int studentId;
    private String name;
    private int age;
    @Column(unique = true)
    private String mob;
    @Enumerated(EnumType.STRING)
    private StudentBranch branch;
    @Column(unique = true)
    private String emailId;
    @OneToOne(mappedBy = "student",cascade = CascadeType.ALL)
    private Card card;
}

package com.example.LibraryManagementSystemSpring.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "author_info")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int authorId;
    private String authorName;
    private int age;
    @Column(unique = true)
    private String emailId;
    @OneToMany(mappedBy = "author",cascade = CascadeType.ALL)
    private List<Book> bookList = new ArrayList<>();

}

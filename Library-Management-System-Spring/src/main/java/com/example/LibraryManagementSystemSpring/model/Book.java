package com.example.LibraryManagementSystemSpring.model;


import com.example.LibraryManagementSystemSpring.enums.Genre;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "book_info")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bookId;
    @Column(unique = true)
    private String bookName;
    @CreationTimestamp
    private Date issuedDate;
    @Enumerated(EnumType.STRING)
    private Genre genre;
    private int price;
    private boolean isIssued;


    @ManyToOne
    @JoinColumn
    private Card card;

    @ManyToOne
    @JoinColumn
    private Author author;

    @OneToMany(mappedBy = "book")
    private List<Transactions> transactionsList = new ArrayList<>();
}

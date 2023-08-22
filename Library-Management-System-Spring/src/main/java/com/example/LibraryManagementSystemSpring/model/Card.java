package com.example.LibraryManagementSystemSpring.model;


import com.example.LibraryManagementSystemSpring.enums.CardStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "card_info")
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cardId;
    @Enumerated(EnumType.STRING)
    private CardStatus status;
    @CreationTimestamp
    private Date issuedDate;
    private String validTill;
    @OneToOne
    @JoinColumn
    private Student student;
    @OneToMany(mappedBy = "card",cascade = CascadeType.ALL)
    private List<Book> bookList = new ArrayList<>();

    @OneToMany(mappedBy = "card")
    private List<Transactions> transactionsList = new ArrayList<>();
}

package com.example.LibraryManagementSystemSpring.model;

import com.example.LibraryManagementSystemSpring.enums.TransactionStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;
import java.util.UUID;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "transactions_info")
public class Transactions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int transactionId;
    private String transactionNumber;
    private boolean isIssued;
    @CreationTimestamp
    private Date transactionDate;
    @Enumerated(EnumType.STRING)
    private TransactionStatus transactionStatus;


    @ManyToOne
    @JoinColumn
    Card card;

    @ManyToOne
    @JoinColumn
    Book book;
}

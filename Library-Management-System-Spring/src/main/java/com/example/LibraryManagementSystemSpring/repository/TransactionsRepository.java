package com.example.LibraryManagementSystemSpring.repository;

import com.example.LibraryManagementSystemSpring.model.Transactions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionsRepository extends JpaRepository<Transactions,Integer> {
}

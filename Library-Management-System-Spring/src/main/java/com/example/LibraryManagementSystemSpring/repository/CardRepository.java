package com.example.LibraryManagementSystemSpring.repository;


import com.example.LibraryManagementSystemSpring.model.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardRepository extends JpaRepository<Card,Integer> {
}

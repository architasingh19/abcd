package com.example.LibraryManagementSystemSpring.repository;


import com.example.LibraryManagementSystemSpring.enums.Genre;
import com.example.LibraryManagementSystemSpring.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book,Integer> {
    Book findByBookName(String name);
}

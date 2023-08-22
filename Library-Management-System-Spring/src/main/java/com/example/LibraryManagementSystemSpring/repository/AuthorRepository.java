package com.example.LibraryManagementSystemSpring.repository;


import com.example.LibraryManagementSystemSpring.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author,Integer> {
    public Author findByEmailId(String emailId);
    public Author findByAuthorName(String authorName);
}

package com.example.LibraryManagementSystemSpring.service.impl;


import com.example.LibraryManagementSystemSpring.DTO.RequestDto.Author.AuthorRequestDto;
import com.example.LibraryManagementSystemSpring.DTO.RequestDto.Author.GetAuthorByEmailRequestDto;
import com.example.LibraryManagementSystemSpring.DTO.ResponseDto.Author.AuthorResponseDto;
import com.example.LibraryManagementSystemSpring.exception.InvalidAutherName;
import com.example.LibraryManagementSystemSpring.exception.InvalidAuthorEmail;
import com.example.LibraryManagementSystemSpring.model.Author;
import com.example.LibraryManagementSystemSpring.model.Book;
import com.example.LibraryManagementSystemSpring.repository.AuthorRepository;
import com.example.LibraryManagementSystemSpring.repository.BookRepository;
import com.example.LibraryManagementSystemSpring.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class AuthorServiceImpl implements AuthorService {
    @Autowired
    AuthorRepository authorRepository;

    @Autowired
    BookRepository bookRepository;

    @Override
    public String addAuthor(AuthorRequestDto authorRequestDto) {
        Author author = new Author();
        author.setAuthorName(authorRequestDto.getAuthorName());
        author.setAge(authorRequestDto.getAge());
        author.setEmailId(authorRequestDto.getEmailId());

        authorRepository.save(author);
        return "successfully added author";
    }

    @Override
    public AuthorResponseDto getAuthorByEmailId(GetAuthorByEmailRequestDto getAuthorByEmailRequestDto) throws Exception {
        Author author;
        AuthorResponseDto authorResponseDto = new AuthorResponseDto();
        try{
            author = authorRepository.findByEmailId(getAuthorByEmailRequestDto.getEmailId());
            authorResponseDto.setAge(author.getAge());
            authorResponseDto.setEmailId(author.getEmailId());
            authorResponseDto.setAuthorName(author.getAuthorName());
        }
        catch(Exception e) {
            throw new InvalidAuthorEmail("enter the correct author mail id");
        }
        return authorResponseDto;
    }

    @Override
    public String deleteAuthor(String authorName) {
        Author author = authorRepository.findByAuthorName(authorName);
        List<Book> bookList = bookRepository.findAll();
        for (Book book : bookList) {
            if (book.getAuthor().equals(author)) {
                bookRepository.delete(book);
            }
        }
        authorRepository.delete(author);
        return "author deleted successfully";
    }
}

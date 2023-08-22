package com.example.LibraryManagementSystemSpring.controller;


import com.example.LibraryManagementSystemSpring.DTO.RequestDto.Book.BookRequestDto;
import com.example.LibraryManagementSystemSpring.DTO.ResponseDto.Book.BookResponseDto;
import com.example.LibraryManagementSystemSpring.service.BookService;
import com.example.LibraryManagementSystemSpring.service.impl.BookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookContoller {
    @Autowired
    BookService bookService;

    @PostMapping("/add")
    public String addBook(@RequestBody BookRequestDto bookRequestDto) throws Exception {
        return bookService.addBook(bookRequestDto);
    }
    @GetMapping("/get-by-name")
    public BookResponseDto getBookByName(@RequestParam ("bookName") String bookName) throws Exception {
        return bookService.getBookByBookName(bookName);
    }
    @GetMapping("/get-by-author")
    public List<BookResponseDto> getBookByAuthorName(@RequestParam ("authorName") String authorName) throws Exception{
        return bookService.getBookByAuthorName(authorName);
    }
    @GetMapping("/get-all")
    public List<BookResponseDto> getAllBooks() {
        return bookService.getAllBooks();
    }
    @DeleteMapping("/delete")
    public String deleteBookByName(@RequestParam ("bookName") String bookName) throws Exception {
        return bookService.deleteBookByName(bookName);
    }
}
package com.example.LibraryManagementSystemSpring.service;


import com.example.LibraryManagementSystemSpring.DTO.RequestDto.Book.BookRequestDto;
import com.example.LibraryManagementSystemSpring.DTO.ResponseDto.Book.BookResponseDto;

import java.util.List;

public interface BookService {
    public String addBook(BookRequestDto bookRequestDto) throws Exception;
    public BookResponseDto getBookByBookName (String bookName) throws Exception;
    public List<BookResponseDto> getBookByAuthorName(String authorName) throws Exception;
    public List<BookResponseDto> getAllBooks();
    public String deleteBookByName(String bookName) throws Exception;
}

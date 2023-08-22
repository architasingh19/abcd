package com.example.LibraryManagementSystemSpring.service;



import com.example.LibraryManagementSystemSpring.DTO.RequestDto.Author.AuthorRequestDto;
import com.example.LibraryManagementSystemSpring.DTO.RequestDto.Author.GetAuthorByEmailRequestDto;
import com.example.LibraryManagementSystemSpring.DTO.ResponseDto.Author.AuthorResponseDto;
import com.example.LibraryManagementSystemSpring.model.Author;
import com.example.LibraryManagementSystemSpring.model.Book;

import java.util.List;

public interface AuthorService {
    public String addAuthor(AuthorRequestDto authorRequestDto);
    public AuthorResponseDto getAuthorByEmailId(GetAuthorByEmailRequestDto getAuthorByEmailRequestDto) throws Exception;
    public String deleteAuthor(String authorName);
}

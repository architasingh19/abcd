package com.example.LibraryManagementSystemSpring.controller;

import com.example.LibraryManagementSystemSpring.DTO.RequestDto.Author.AuthorRequestDto;
import com.example.LibraryManagementSystemSpring.DTO.RequestDto.Author.GetAuthorByEmailRequestDto;
import com.example.LibraryManagementSystemSpring.DTO.ResponseDto.Author.AuthorResponseDto;
import com.example.LibraryManagementSystemSpring.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/author")
public class AuthorController {
    @Autowired
    AuthorService authorService;
    @PostMapping("/add")
    public String addAuthor(@RequestBody AuthorRequestDto authorRequestDto) {
        return authorService.addAuthor(authorRequestDto);
    }
    @GetMapping("/get-author-by-email")
    public AuthorResponseDto getAuthorByEmailId(@RequestBody GetAuthorByEmailRequestDto getAuthorByEmailRequestDto) throws Exception {
        return authorService.getAuthorByEmailId(getAuthorByEmailRequestDto);
    }
    @DeleteMapping("/delete-author")
    public String deleteAuthor(@RequestParam ("authorName") String authorName){
        return authorService.deleteAuthor(authorName);
    }
}

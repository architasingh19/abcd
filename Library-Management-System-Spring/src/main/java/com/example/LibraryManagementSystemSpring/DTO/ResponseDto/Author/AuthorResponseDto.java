package com.example.LibraryManagementSystemSpring.DTO.ResponseDto.Author;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AuthorResponseDto {
    private String authorName;
    private int age;
    private String emailId;
}

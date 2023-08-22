package com.example.LibraryManagementSystemSpring.DTO.RequestDto.Author;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AuthorRequestDto {
    private String authorName;
    private int age;
    private String emailId;
}

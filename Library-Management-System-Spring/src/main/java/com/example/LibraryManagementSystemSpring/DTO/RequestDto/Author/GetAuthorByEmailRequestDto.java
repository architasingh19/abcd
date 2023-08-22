package com.example.LibraryManagementSystemSpring.DTO.RequestDto.Author;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class GetAuthorByEmailRequestDto {
    private String emailId;
}

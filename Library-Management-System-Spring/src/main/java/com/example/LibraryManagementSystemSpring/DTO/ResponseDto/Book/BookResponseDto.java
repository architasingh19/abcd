package com.example.LibraryManagementSystemSpring.DTO.ResponseDto.Book;

import com.example.LibraryManagementSystemSpring.enums.Genre;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class BookResponseDto {
    private String name;
    private Genre genre;
    private Date issuedDate;
    private int price;
}

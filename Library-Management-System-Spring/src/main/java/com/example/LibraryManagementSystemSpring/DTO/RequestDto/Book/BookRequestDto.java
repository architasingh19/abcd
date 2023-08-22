package com.example.LibraryManagementSystemSpring.DTO.RequestDto.Book;


import com.example.LibraryManagementSystemSpring.enums.Genre;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class BookRequestDto {
    private String bookName;
    private Genre genre;
    private int price;
    private int authorId;
}

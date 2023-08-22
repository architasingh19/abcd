package com.example.LibraryManagementSystemSpring.DTO.RequestDto.Transactions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TransactionRequestDto {
    private String bookName;
    private int cardId;
}

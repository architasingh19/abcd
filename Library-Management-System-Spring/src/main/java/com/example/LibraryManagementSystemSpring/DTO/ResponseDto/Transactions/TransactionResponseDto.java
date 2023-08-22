package com.example.LibraryManagementSystemSpring.DTO.ResponseDto.Transactions;

import com.example.LibraryManagementSystemSpring.enums.TransactionStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TransactionResponseDto {
    private String bookName;
    private String transactionNumber;
    private int issuedToCardId;
    private TransactionStatus transactionStatus;
}

package com.example.LibraryManagementSystemSpring.service;

import com.example.LibraryManagementSystemSpring.DTO.RequestDto.Transactions.TransactionRequestDto;
import com.example.LibraryManagementSystemSpring.DTO.ResponseDto.Transactions.TransactionResponseDto;

public interface TransactionsService {
    public TransactionResponseDto issueBook(TransactionRequestDto transactionRequestDto) throws Exception;

}

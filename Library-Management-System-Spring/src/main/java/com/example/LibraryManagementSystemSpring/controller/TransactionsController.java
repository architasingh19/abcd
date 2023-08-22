package com.example.LibraryManagementSystemSpring.controller;

import com.example.LibraryManagementSystemSpring.DTO.RequestDto.Transactions.TransactionRequestDto;
import com.example.LibraryManagementSystemSpring.DTO.ResponseDto.Transactions.TransactionResponseDto;
import com.example.LibraryManagementSystemSpring.service.TransactionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transactions")
public class TransactionsController {
    @Autowired
    TransactionsService service;
    @PostMapping ("/issueBook")
    public TransactionResponseDto issueBook (@RequestBody TransactionRequestDto transactionRequestDto) throws Exception {
        return service.issueBook(transactionRequestDto);
    }
}

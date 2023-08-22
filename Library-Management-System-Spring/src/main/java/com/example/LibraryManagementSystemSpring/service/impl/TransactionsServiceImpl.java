package com.example.LibraryManagementSystemSpring.service.impl;

import com.example.LibraryManagementSystemSpring.DTO.RequestDto.Transactions.TransactionRequestDto;
import com.example.LibraryManagementSystemSpring.DTO.ResponseDto.Transactions.TransactionResponseDto;
import com.example.LibraryManagementSystemSpring.enums.CardStatus;
import com.example.LibraryManagementSystemSpring.enums.TransactionStatus;
import com.example.LibraryManagementSystemSpring.exception.BookNotAvailable;
import com.example.LibraryManagementSystemSpring.exception.InvalidBookName;
import com.example.LibraryManagementSystemSpring.exception.InvalidCardId;
import com.example.LibraryManagementSystemSpring.exception.NoSuchStudentAvailable;
import com.example.LibraryManagementSystemSpring.model.Book;
import com.example.LibraryManagementSystemSpring.model.Card;
import com.example.LibraryManagementSystemSpring.model.Transactions;
import com.example.LibraryManagementSystemSpring.repository.BookRepository;
import com.example.LibraryManagementSystemSpring.repository.CardRepository;
import com.example.LibraryManagementSystemSpring.repository.TransactionsRepository;
import com.example.LibraryManagementSystemSpring.service.TransactionsService;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.UUID;

@Service
public class TransactionsServiceImpl implements TransactionsService {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    CardRepository cardRepository;

    @Autowired
    TransactionsRepository transactionsRepository;

    @Autowired
    private JavaMailSender emailSender;

    @Override
    public TransactionResponseDto issueBook(TransactionRequestDto transactionRequestDto) throws Exception {
        Transactions transaction = new Transactions();
        transaction.setTransactionNumber(String.valueOf(UUID.randomUUID()));

        Book book;
        try {
            book = bookRepository.findByBookName(transactionRequestDto.getBookName());
            transaction.setIssued(true);
            transaction.setBook(book);
            book.setIssued(true);
            book.getTransactionsList().add(transaction);
        } catch (Exception e) {
            transaction.setIssued(false);
            transaction.setTransactionStatus(TransactionStatus.FAILED);
            transactionsRepository.save(transaction);
            throw new InvalidBookName("enter the valid book name");
        }
        Card card;
        try {
            card = cardRepository.findById(transactionRequestDto.getCardId()).get();
            transaction.setIssued(true);
            transaction.setCard(card);
            card.getTransactionsList().add(transaction);
        } catch (Exception e) {
            transaction.setIssued(false);
            transaction.setTransactionStatus(TransactionStatus.FAILED);
            transactionsRepository.save(transaction);
            throw new InvalidCardId("enter the valid card id");
        }
                            // !these are some extreme cases //
        // ?this is for if the book is already taken by another student.
        try {
            if (book.isIssued()) {
                transaction.setTransactionStatus(TransactionStatus.FAILED);
                transactionsRepository.save(transaction);
            }
        } catch (Exception e) {
            throw new BookNotAvailable("the book is not available");
        }

        //?if the card is not activated or there is no student with that id
        try {
            if (card.getStatus() != CardStatus.ACTIVE) {
                transaction.setTransactionStatus(TransactionStatus.FAILED);
                transactionsRepository.save(transaction);
            }
        } catch (Exception e) {
            throw new NoSuchStudentAvailable("there is no such student with that card id");
        }

        transaction.setTransactionStatus(TransactionStatus.SUCCESS);
        book.setCard(card);

        cardRepository.save(card);

        TransactionResponseDto transactionResponseDto = new TransactionResponseDto();
        transactionResponseDto.setTransactionNumber(transaction.getTransactionNumber());
        transactionResponseDto.setBookName(transactionRequestDto.getBookName());
        transactionResponseDto.setIssuedToCardId(transactionRequestDto.getCardId());
        transactionResponseDto.setTransactionStatus(transaction.getTransactionStatus());

        //?Sending the email for successfully issued the book to the user email id.

        //?this is the message i want to send to the student email id after successful transaction
        String text = "successfully issued the book to " + card.getStudent().getName() + " on " + transaction.getTransactionDate();
        String subject = "Regarding book";
        String pathName = "E:\\April-Spring2-Practice\\Library-Management-System-Spring\\src\\main\\java\\com\\example\\LibraryManagementSystemSpring\\images\\harry potter book.jpg";

        MimeMessage message = emailSender.createMimeMessage();

        MimeMessageHelper helper = new MimeMessageHelper(message, true);

        helper.setFrom("shopwaveservice@gmail.com");
        helper.setTo(card.getStudent().getEmailId());
        helper.setSubject(subject);
        helper.setText(text);

        FileSystemResource file = new FileSystemResource(new File(pathName));
        helper.addAttachment("BookImage", file);

        emailSender.send(message);


        return transactionResponseDto;
    }
}

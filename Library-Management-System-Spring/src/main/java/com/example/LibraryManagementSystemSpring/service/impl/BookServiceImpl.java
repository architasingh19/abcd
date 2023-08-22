package com.example.LibraryManagementSystemSpring.service.impl;

import com.example.LibraryManagementSystemSpring.DTO.RequestDto.Book.BookRequestDto;
import com.example.LibraryManagementSystemSpring.DTO.ResponseDto.Book.BookResponseDto;
import com.example.LibraryManagementSystemSpring.exception.InvalidAutherName;
import com.example.LibraryManagementSystemSpring.exception.InvalidAuthorId;
import com.example.LibraryManagementSystemSpring.exception.InvalidBookName;
import com.example.LibraryManagementSystemSpring.model.Author;
import com.example.LibraryManagementSystemSpring.model.Book;
import com.example.LibraryManagementSystemSpring.repository.AuthorRepository;
import com.example.LibraryManagementSystemSpring.repository.BookRepository;
import com.example.LibraryManagementSystemSpring.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    AuthorRepository authorRepository;

//    @Autowired
//    CardRepository cardRepository;

    @Autowired
    BookRepository bookRepository;

    @Override
    public String addBook(BookRequestDto bookRequestDto) throws Exception{
        Book book = new Book();
            try {
                Author author = authorRepository.findById(bookRequestDto.getAuthorId()).get();

                book.setBookName(bookRequestDto.getBookName());
                book.setGenre(bookRequestDto.getGenre());
                book.setPrice(bookRequestDto.getPrice());
                book.setAuthor(author);
                author.getBookList().add(book);
            }
            catch (Exception e) {
                throw new InvalidAuthorId("enter the valid author id");
            }
//            try{
//                Card card = cardRepository.findById(bookRequestDto.getCardId()).get();
//                book.setCard(card);
//                card.getBookList().add(book);
//            }
//            catch (Exception e) {
//                throw new InvalidCardId("enter the valid card id");
//            }
            bookRepository.save(book);
            return "book added successfully";
    }

    @Override
    public BookResponseDto getBookByBookName(String bookName) throws Exception {
        try {
            Book book = bookRepository.findByBookName(bookName);
            BookResponseDto bookResponseDto = new BookResponseDto();
            bookResponseDto.setName(book.getBookName());
            bookResponseDto.setPrice(book.getPrice());
            bookResponseDto.setGenre(book.getGenre());
            bookResponseDto.setIssuedDate(book.getIssuedDate());

            return bookResponseDto;
        }
        catch (Exception e) {
           throw new InvalidBookName("enter the valid book name");
        }
    }

    @Override
    public List<BookResponseDto> getBookByAuthorName(String authorName) throws Exception {
        try {
            List<Book> books = bookRepository.findAll();
            List<BookResponseDto> bookResponseDtoList = new ArrayList<>();
            for (Book book : books) {
                if (book.getAuthor().getAuthorName().equals(authorName)) {
                    BookResponseDto bookResponseDto = new BookResponseDto();
                    bookResponseDto.setName(book.getBookName());
                    bookResponseDto.setPrice(book.getPrice());
                    bookResponseDto.setGenre(book.getGenre());
                    bookResponseDto.setIssuedDate(book.getIssuedDate());
                    bookResponseDtoList.add(bookResponseDto);
                }
            }
            return bookResponseDtoList;
        }
        catch (Exception e) {
            throw new InvalidAutherName("enter the valid author name");
        }
    }

    @Override
    public List<BookResponseDto> getAllBooks() {
        List<BookResponseDto> bookResponseDtoList = new ArrayList<>();
        List<Book> bookList = bookRepository.findAll();
        for (Book book : bookList) {
            BookResponseDto bookResponseDto = new BookResponseDto();
            bookResponseDto.setGenre(book.getGenre());
            bookResponseDto.setPrice(book.getPrice());
            bookResponseDto.setName(book.getBookName());
            bookResponseDto.setIssuedDate(book.getIssuedDate());

            bookResponseDtoList.add(bookResponseDto);
        }
        return bookResponseDtoList;
    }

    @Override
    public String deleteBookByName(String bookName) throws Exception {
        try {
            Book book = bookRepository.findByBookName(bookName);
            bookRepository.delete(book);
        }
        catch (Exception e) {
            throw new InvalidBookName("enter the valid book name");
        }
        return "book deleted successfully";
    }
}

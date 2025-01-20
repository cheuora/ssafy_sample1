package com.example.tdd_ssafy.service;

import com.example.tdd_ssafy.domain.Book;
import com.example.tdd_ssafy.repo.BookRepository;
import com.example.tdd_ssafy.core.ISBNValidator;

import org.springframework.stereotype.Service;

@Service
public class BookRegistrationService {
    private final BookRepository bookRepository;

    public BookRegistrationService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void registerBook(Book book) {
        ISBNValidator ISBNValidator = new ISBNValidator();
        if (!ISBNValidator.isValid(book.getIsbn())) {
            throw new IllegalArgumentException("Invalid ISBN");
        }
        bookRepository.save(book);
    }
}

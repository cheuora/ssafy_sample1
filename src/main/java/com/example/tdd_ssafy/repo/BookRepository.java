package com.example.tdd_ssafy.repo;

import com.example.tdd_ssafy.domain.Book;

import org.springframework.stereotype.Repository;

// import java.util.Optional;

@Repository
public interface BookRepository {
    // Optional<Book> findByIsbn(String isbn);
    Book save(Book book);
}


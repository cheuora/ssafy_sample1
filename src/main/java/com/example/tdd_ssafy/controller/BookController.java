package com.example.tdd_ssafy.controller;

import com.example.tdd_ssafy.domain.Book;
import com.example.tdd_ssafy.service.BookRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/books")
public class BookController {
    private final BookRegistrationService bookRegistrationService;

    @Autowired
    public BookController(BookRegistrationService bookRegistrationService) {
        this.bookRegistrationService = bookRegistrationService;
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerBook(@RequestBody Book book) {
        try {
            bookRegistrationService.registerBook(book);
            return ResponseEntity.ok("Book registered successfully");
        } catch (NumberFormatException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e){
            return ResponseEntity.internalServerError().body("Error registering book");

        }
    }

}


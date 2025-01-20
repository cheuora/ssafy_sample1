package com.example.tdd_ssafy.service;


import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;


import com.example.tdd_ssafy.repo.BookRepository;
import com.example.tdd_ssafy.domain.Book;


import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class BookRegistrationServiceTest {
    
    @InjectMocks
    private BookRegistrationService bookRegistrationService;

    @Mock
    private BookRepository bookRepository;

    public BookRegistrationServiceTest() {
        MockitoAnnotations.openMocks(this);
    }


    @Test
    void testRegisterBook() {
        // given
        Book book = new Book("978-3-16-148410-0", "Test Book", "Test Author");
        when(bookRepository.save(any(Book.class))).thenReturn(book);

        // when
        bookRegistrationService.registerBook(book);

        // then
        verify(bookRepository, times(1)).save(book);

    }


    @Test
    void testRegisterBookWithInvalidISBN() {
        // given
        Book book = new Book("978-3-16-148410-0", "Test Book", "Test Author");
        when(bookRepository.save(any(Book.class))).thenReturn(book);

        bookRegistrationService.registerBook(book);

        // then
        verify(bookRepository, times(1)).save(book);
    }

}

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

package com.example.tdd_ssafy.core;



class ISBNValidatorTest {

    private final ISBNValidator isbnValidator = new ISBNValidator();

    @Test
    void testValidISBN10() {
        // Valid ISBN-10 examples
        assertTrue(isbnValidator.isValid("0-306-40615-2")); // Valid with hyphens
        assertTrue(isbnValidator.isValid("0306406152"));    // Valid without hyphens
        assertTrue(isbnValidator.isValid("0-19-852663-6")); // Valid with hyphens
    }

    @Test
    void testInvalidISBN10() {
        // Invalid ISBN-10 examples
        assertFalse(isbnValidator.isValid("0-306-40615-3")); // Incorrect checksum
        assertFalse(isbnValidator.isValid("123456789X"));    // Incorrect checksum
        assertFalse(isbnValidator.isValid("0-306-4061"));    // Too short
        assertFalse(isbnValidator.isValid("abcdefghij"));    // Non-numeric
    }

    @Test
    void testValidISBN13() {
        // Valid ISBN-13 examples
        assertTrue(isbnValidator.isValid("978-3-16-148410-0")); // Valid with hyphens
        assertTrue(isbnValidator.isValid("9783161484100"));     // Valid without hyphens
        assertTrue(isbnValidator.isValid("978-0-306-40615-7")); // Valid with hyphens
    }

    @Test
    void testInvalidISBN13() {
        // Invalid ISBN-13 examples
        assertFalse(isbnValidator.isValid("978-3-16-148410-1")); // Incorrect checksum
        assertFalse(isbnValidator.isValid("978316148410"));      // Too short
        assertFalse(isbnValidator.isValid("abcdefghijklm"));     // Non-numeric
    }

    @Test
    void testEmptyOrNullISBN() {
        // Null or empty ISBN
        assertFalse(isbnValidator.isValid(null));
        assertFalse(isbnValidator.isValid(""));
    }

    @Test
    void testISBNWithHyphens() {
        // ISBN with hyphens
        assertTrue(isbnValidator.isValid("978-0-306-40615-7")); // Valid ISBN-13
        assertTrue(isbnValidator.isValid("0-306-40615-2"));     // Valid ISBN-10
    }

    @Test
    void testISBNWithoutHyphens() {
        // ISBN without hyphens
        assertTrue(isbnValidator.isValid("9780306406157")); // Valid ISBN-13
        assertTrue(isbnValidator.isValid("0306406152"));   // Valid ISBN-10
    }
}
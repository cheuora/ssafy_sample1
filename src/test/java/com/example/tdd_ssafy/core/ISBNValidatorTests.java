package com.example.tdd_ssafy.core;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class ISBNValidatorTests {

    private boolean isValid(String isbn) {
        return new ISBNValidator().isValid(isbn);
    }




    @Test
    public void testValidISBN10() {
        assertTrue(isValid("0471958697"));
        assertTrue(isValid("0306406152"));
        assertTrue(isValid("0136091814"));
        assertTrue(isValid("123456789X"));
    }

    @Test
    public void testInvalidISBN10() {
        assertFalse(isValid("1234567890"));
        assertFalse(isValid("0471958699"));
        assertFalse(isValid("ABCDEFGHIJ"));
        assertFalse(isValid("12345678X"));
    }

    @Test
    public void testValidISBN13() {
        assertTrue(isValid("9780470059029"));
        assertTrue(isValid("9780306406157"));
        assertTrue(isValid("9780136091813"));
    }

    @Test
    public void testInvalidISBN13() {
        assertFalse(isValid("9780470059020"));
        assertFalse(isValid("9780306406150"));
        assertFalse(isValid("ABCDEFGHIJKLM"));
    }

}

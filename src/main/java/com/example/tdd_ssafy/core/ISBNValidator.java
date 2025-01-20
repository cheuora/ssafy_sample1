package com.example.tdd_ssafy.core;

public class ISBNValidator {

    public boolean isValid(String isbn) {
       // null이거나 비어있는지, 그리고 길이가 적절한지 초기 검사
       if (isbn == null || isbn.isEmpty()) {
            return false;
        }   

        // 하이픈 제거
        isbn = isbn.replace("-", "");

        // ISBN 길이가 10자리인지 13자리인지 확인하고 각각에 맞는 유효성 검사 실행
        if (isbn.length() == 10) {
            return isValidISBN10(isbn);
        } else if (isbn.length() == 13) {
            return isValidISBN13(isbn);
        } else {
            return false;
        }
    }

    private  boolean isValidISBN10(String isbn) {
        // ISBN-10 is either 9 digits followed by a digit or 9 digits followed by 'X'
        // (1×첫번째숫자)+(2×두번째숫자)+…+(10×열번째숫자)mod11=0
        if (isbn.length() != 10 || !isbn.substring(0, 9).matches("\\d+") || !(isbn.endsWith("X") || Character.isDigit(isbn.charAt(9)))) {
            return false;
        }

        int total = 0;
        for (int i = 0; i < 10; i++) {
            char ch = isbn.charAt(i);
            int value = (ch == 'X') ? 10 : Character.getNumericValue(ch);
            total += value * (i + 1);
        }

        return total % 11 == 0;
    }

    private  boolean isValidISBN13(String isbn) {
        // ISBN-13 is 13 digits
        // (1×홀수위치의숫자)+(3×짝수위치의숫자)mod10=0

        if (isbn.length() != 13 || !isbn.matches("\\d+")) {
            return false;
        }

        int total = 0;
        for (int i = 0; i < 13; i++) {
            int factor = (i % 2 == 0) ? 1 : 3;
            total += Character.getNumericValue(isbn.charAt(i)) * factor;
        }

        return total % 10 == 0;

    }

    
}

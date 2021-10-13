package com.bridgelabz.address_book_app_spring.exceptions;

public class CustomException extends RuntimeException{
    public CustomException(String message) {
        super(message);
    }
}

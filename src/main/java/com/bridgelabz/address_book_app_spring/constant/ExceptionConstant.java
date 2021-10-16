package com.bridgelabz.address_book_app_spring.constant;

public enum ExceptionConstant {
    ID_NOT_FOUND("Id not found");

    private final String message;

    ExceptionConstant(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}

package com.bridgelabz.address_book_app_spring.constant;

public enum ControllerConstant {
    GET_ALL("contacts fetched sucessfully"),
    GET_BYID("contact fetched by id sucessfully"),
    POST_CONTACT("Post Call sucessfully"),
    PUT_CONTACT("Put Call sucessfully"),
    DELETE_CONTACT("Delete Call Successfull");
    private final String message;

    ControllerConstant(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}

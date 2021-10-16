package com.bridgelabz.address_book_app_spring.dto;

import lombok.Data;

@Data
public class AddressBookResponseDto {
    private int id;
    private String firstName;
    private String city;
    private String state;
    private String pincode;
    private String phoneNumber;
}

package com.bridgelabz.address_book_app_spring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * creates and maintains AddressBook as object (DTO)
 *
 * @author roja julapalli
 * @version 0.0.1
 * @since 13-10-2021
 */
@Data
@AllArgsConstructor
public class AddressBookDto {
    private String firstName;
    private String city;
    private String state;
    private String pincode;
    private String phoneNumber;
}
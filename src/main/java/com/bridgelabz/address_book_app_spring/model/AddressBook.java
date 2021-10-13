package com.bridgelabz.address_book_app_spring.model;

import com.bridgelabz.address_book_app_spring.dto.AddressBookDto;
import lombok.Data;

/**
 * Receive data Object
 *
 * @author roja julapalli
 * @version 0.0.1
 * @since 13-10-2021
 */
@Data
public class AddressBook {
    private int id;
    private String firstName;
    private String city;
    private String state;
    private String pincode;
    private String phoneNumber;



    public AddressBook(int id, AddressBookDto addressBookDto) {
        this.id = id;
        this.firstName = addressBookDto.getFirstName();
        this.city = addressBookDto.getCity();
        this.state = addressBookDto.getState();
        this.pincode = addressBookDto.getPincode();
        this.phoneNumber = addressBookDto.getPhoneNumber();
    }
}

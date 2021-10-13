package com.bridgelabz.address_book_app_spring.model;

import com.bridgelabz.address_book_app_spring.dto.AddressBookDto;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.persistence.*;

/**
 * Receive data Object
 *
 * @author roja julapalli
 * @version 0.0.1
 * @since 13-10-2021
 */
@Data
@NoArgsConstructor
@Entity
@Table(name="AddressBook")
public class AddressBook {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String firstName;
    private String city;
    private String state;
    private String pincode;
    private String phoneNumber;

    public AddressBook(AddressBookDto addressBookDto){
        this.updateContactData(addressBookDto);
    }


    public void updateContactData(AddressBookDto addressBookDto) {
        this.firstName = addressBookDto.getFirstName();
        this.city = addressBookDto.getCity();
        this.state = addressBookDto.getState();
        this.pincode = addressBookDto.getPincode();
        this.phoneNumber = addressBookDto.getPhoneNumber();
    }
}

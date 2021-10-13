package com.bridgelabz.address_book_app_spring.controller;

import com.bridgelabz.address_book_app_spring.dto.AddressBookDto;
import com.bridgelabz.address_book_app_spring.dto.ResponseDto;
import com.bridgelabz.address_book_app_spring.model.AddressBook;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Performed Various HTTP Request(GET,PUT,POST,DELETE)
 *
 * @author roja julapalli
 * @version 0.0.1
 * @since 13-10-2021
 */
@RestController
@RequestMapping(value = "/addressbook")
public class AddressBookController {

    /**
     * Function to perform Http Get request
     *
     * @return List of contacts from addressbook
     */

    @GetMapping(value = "/get")
    public ResponseEntity<ResponseDto> getAllContacts() {
        AddressBook addressBook = null;
        addressBook = new AddressBook(1,new AddressBookDto("roja","chennai","tamilnadu","602026","78786667"));
        ResponseDto responseDto = new ResponseDto("Get Call Success",addressBook);
        return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
    }

    /**
     * Function to perform Http Get request
     *
     * @param contactId unique identifier to find contact
     * @return contact using unique identifier
     */

    @GetMapping(value = "/get/{contactId}")
    public ResponseEntity<ResponseDto> getContactById(@PathVariable(value = "contactId") int contactId) {
        AddressBook addressBook = null;
        addressBook = new AddressBook(1,new AddressBookDto("roja","chennai","tamilnadu","602026","78786667"));
        ResponseDto responseDto = new ResponseDto("Get Call Success For Id",addressBook);
        return  new ResponseEntity<ResponseDto>( responseDto, HttpStatus.OK);
    }

    /**
     * Function to perform Http Post request
     *
     * @param addressBookDto contact info data in the form of Json
     * @return add the contact to addressbook
     */


    @PostMapping(value = "/addcontact")
    public ResponseEntity<ResponseDto> addContact(@RequestBody AddressBookDto addressBookDto) {
        AddressBook addressBook = null;
        addressBook = new AddressBook(1, addressBookDto);
        ResponseDto responseDto = new ResponseDto("Added Address ",addressBook);
        return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
    }

    /**
     * Function to perform Http Put request
     *
     * @param contactId unique identifier of contact
     * @param addressBookDto contact data in addressbook
     * @return update contact data by using unique id
     */


    @PutMapping("/update/{contactId}")
    public ResponseEntity<ResponseDto> updateContact(@PathVariable(value = "contactId") int contactId,@RequestBody AddressBookDto addressBookDto) {
        AddressBook addressBook = null;
        addressBook = new AddressBook(contactId, addressBookDto);
        ResponseDto responseDto = new ResponseDto("updated Address "+contactId,addressBook);
        return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
    }

    /**
     * Function to perform Http Delete request
     *
     * @param contactId unique identifier of contact
     * @return ResponseEntity with message
     */

    @DeleteMapping("/delete/{contactId}")
    public ResponseEntity<ResponseDto> deleteContact(@PathVariable(value = "contactId") int contactId) {
        ResponseDto responseDto = new ResponseDto("Deleted Successfully ","deleted Address Id "+contactId);
        return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
    }
}

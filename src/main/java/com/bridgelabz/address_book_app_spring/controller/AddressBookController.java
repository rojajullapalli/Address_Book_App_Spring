package com.bridgelabz.address_book_app_spring.controller;

import com.bridgelabz.address_book_app_spring.constant.ControllerConstant;
import com.bridgelabz.address_book_app_spring.dto.AddressBookDto;
import com.bridgelabz.address_book_app_spring.dto.AddressBookResponseDto;
import com.bridgelabz.address_book_app_spring.dto.ResponseDto;
import com.bridgelabz.address_book_app_spring.model.AddressBook;
import com.bridgelabz.address_book_app_spring.service.AdressBookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Performed Various HTTP Request(GET,PUT,POST,DELETE)
 *
 * @author roja julapalli
 * @version 0.0.1
 * @since 13-10-2021
 */
@Slf4j
@RestController
@RequestMapping(value = "/addressbook")
public class AddressBookController {

    @Autowired
    AdressBookService adressBookService;

    /**
     * Function to perform Http Get request
     *
     * @return List of contacts from addressbook
     */

    @GetMapping(value = "/get")
    public ResponseEntity<ResponseDto> getAllContacts() {
        List<AddressBookResponseDto> addressBookResponseDto = null;
        addressBookResponseDto = adressBookService.getAllContacts();
        ResponseDto responseDto = new ResponseDto(ControllerConstant.GET_ALL.getMessage(), addressBookResponseDto);
        log.info("got all the contacts");
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
        AddressBookResponseDto addressBoookResponseDto = null;
        addressBoookResponseDto = adressBookService.getContactById(contactId);
        ResponseDto responseDto = new ResponseDto(ControllerConstant.GET_BYID.getMessage(), addressBoookResponseDto);
        log.info("got the contact by id");
        return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
    }

    /**
     * Function to perform Http Post request
     *
     * @param addressBookDto contact info data in the form of Json
     * @return add the contact to addressbook
     */


    @PostMapping(value = "/addcontact")
    public ResponseEntity<ResponseDto> addContact(@Valid @RequestBody AddressBookDto addressBookDto) {
        AddressBookResponseDto addressBook = null;
        addressBook = adressBookService.addContact(addressBookDto);
        ResponseDto responseDto = new ResponseDto(ControllerConstant.POST_CONTACT.getMessage(), addressBook);
        log.info("contact added successfully");
        return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
    }

    /**
     * Function to perform Http Put request
     *
     * @param contactId      unique identifier of contact
     * @param addressBookDto contact data in addressbook
     * @return update contact data by using unique id
     */


    @PutMapping("/update/{contactId}")
    public ResponseEntity<ResponseDto> updateContact(@PathVariable(value = "contactId") int contactId, @Valid @RequestBody AddressBookDto addressBookDto) {
        AddressBook addressBook = null;
        addressBook = adressBookService.UpdateContact(contactId, addressBookDto);
        ResponseDto responseDto = new ResponseDto(ControllerConstant.PUT_CONTACT.getMessage() + contactId, addressBook);
        log.info("contact updated successfully");
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
        AddressBook addressBook = adressBookService.deleteContact(contactId);
        ResponseDto responseDto = new ResponseDto(ControllerConstant.DELETE_CONTACT.getMessage(), addressBook);
        log.info("contact deleted successfully");
        return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
    }
}

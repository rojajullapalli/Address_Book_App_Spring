package com.bridgelabz.address_book_app_spring.service;

import com.bridgelabz.address_book_app_spring.dto.AddressBookDto;
import com.bridgelabz.address_book_app_spring.dto.AddressBookResponseDto;
import com.bridgelabz.address_book_app_spring.model.AddressBook;

import java.util.List;

public interface IAddressBookService {

    List<AddressBookResponseDto> getAllContacts();

    AddressBookResponseDto getContactById(int contactId);

    AddressBook addContact(AddressBookDto addressBookDto);

    AddressBook UpdateContact(int contactId, AddressBookDto addressBookDto);

    void deleteContact(int ContactId);

}

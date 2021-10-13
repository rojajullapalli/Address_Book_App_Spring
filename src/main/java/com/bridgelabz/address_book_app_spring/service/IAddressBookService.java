package com.bridgelabz.address_book_app_spring.service;

import com.bridgelabz.address_book_app_spring.dto.AddressBookDto;
import com.bridgelabz.address_book_app_spring.model.AddressBook;

import java.util.List;

public interface IAddressBookService {

    List<AddressBook> getAllContacts();

    AddressBook getContactById(int contactId);

    AddressBook addContact(AddressBookDto addressBookDto);

    AddressBook UpdateContact(int contactId,AddressBookDto addressBookDto);

    void deleteContact(int ContactId);

}

package com.bridgelabz.address_book_app_spring.service;

import com.bridgelabz.address_book_app_spring.dto.AddressBookDto;
import com.bridgelabz.address_book_app_spring.model.AddressBook;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * class implements all the methods of business logic
 *
 * @author roja julapalli
 * @version 0.0.1
 * @since 13-10-2021
 */
@Service
public class AdressBookService implements IAddressBookService {
    @Override
    public List<AddressBook> getAllContacts() {
        List<AddressBook> addressBookList = new ArrayList<>();
        addressBookList.add(new AddressBook(1,new AddressBookDto("roja","chennai","tamilnadu","602026","78786667")));
        return addressBookList;
    }

    @Override
    public AddressBook getContactById(int contactId) {
        AddressBook addressBook = null;
        addressBook = new AddressBook(1,new AddressBookDto("roja","chennai","tamilnadu","602026","78786667"));
        return addressBook;
    }

    @Override
    public AddressBook addContact(AddressBookDto addressBookDto) {
        AddressBook addressBook = null;
        addressBook = new AddressBook(1,addressBookDto);
        return addressBook;
    }

    @Override
    public AddressBook UpdateContact(int contactId,AddressBookDto addressBookDto) {
        AddressBook addressBook = null;
        addressBook = new AddressBook(contactId,addressBookDto);
        return addressBook;
    }

    @Override
    public void deleteContact(int ContactId) {

    }
}

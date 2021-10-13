package com.bridgelabz.address_book_app_spring.service;

import com.bridgelabz.address_book_app_spring.dto.AddressBookDto;
import com.bridgelabz.address_book_app_spring.exceptions.CustomException;
import com.bridgelabz.address_book_app_spring.model.AddressBook;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
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

    private final List<AddressBook> addressBookList = new ArrayList<>();
    @Autowired
    public ModelMapper modelMapper;

    @Override
    public List<AddressBook> getAllContacts() {
        return addressBookList;
    }

    @Override
    public AddressBook getContactById(int contactId) {
        return addressBookList.stream().filter(id -> id.getId() == contactId).findFirst().orElseThrow(() -> new CustomException("Contact id not found"));
    }

    @Override
    public AddressBook addContact(AddressBookDto addressBookDto) {
        AddressBook addressBook = null;
        addressBook = new AddressBook(addressBookList.size() + 1, addressBookDto);
        addressBookList.add(addressBook);
        return addressBook;
    }

    @Override
    public AddressBook UpdateContact(int contactId, AddressBookDto addressBookDto) {
        AddressBook addressBook = this.getContactById(contactId);
        modelMapper.map(addressBookDto, addressBook);
        addressBookList.set(contactId - 1, addressBook);
        return addressBook;
    }

    @Override
    public void deleteContact(int contactId) {
        addressBookList.stream().filter(id -> id.getId() == contactId).findFirst().orElseThrow(() -> new CustomException("Employee id not found"));
        addressBookList.remove(contactId - 1);
    }
}

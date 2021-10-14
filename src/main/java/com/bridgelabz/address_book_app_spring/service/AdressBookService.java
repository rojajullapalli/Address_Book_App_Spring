package com.bridgelabz.address_book_app_spring.service;

import com.bridgelabz.address_book_app_spring.dto.AddressBookDto;
import com.bridgelabz.address_book_app_spring.exceptions.CustomException;
import com.bridgelabz.address_book_app_spring.model.AddressBook;
import com.bridgelabz.address_book_app_spring.repository.AddressBookRepository;
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
    private ModelMapper modelMapper;
    @Autowired
    private AddressBookRepository addressBookRepository;

    @Override
    public List<AddressBook> getAllContacts() {
       return addressBookRepository.findAll();
    }

    @Override
    public AddressBook getContactById(int contactId) {
        return addressBookRepository.findById(contactId).orElseThrow(() -> new CustomException("Employee id not found"));
    }

    @Override
    public AddressBook addContact(AddressBookDto addressBookDto) {
        AddressBook addressBook = new AddressBook();
        modelMapper.map(addressBookDto,addressBook);
        return addressBookRepository.save(addressBook);
    }

    @Override
    public AddressBook UpdateContact(int contactId, AddressBookDto addressBookDto) {
        AddressBook addressBook = this.getContactById(contactId);
        modelMapper.map(addressBookDto,addressBook);
        return addressBookRepository.save(addressBook);
    }

    @Override
    public void deleteContact(int contactId) {
        AddressBook addressBook = this.getContactById(contactId);
        addressBookRepository.delete(addressBook);
    }
}

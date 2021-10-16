package com.bridgelabz.address_book_app_spring.service;

import com.bridgelabz.address_book_app_spring.constant.ExceptionConstant;
import com.bridgelabz.address_book_app_spring.dto.AddressBookDto;
import com.bridgelabz.address_book_app_spring.dto.AddressBookResponseDto;
import com.bridgelabz.address_book_app_spring.exceptions.CustomException;
import com.bridgelabz.address_book_app_spring.model.AddressBook;
import com.bridgelabz.address_book_app_spring.repository.AddressBookRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * class implements all the methods of business logic
 *
 * @author roja julapalli
 * @version 0.0.1
 * @since 13-10-2021
 */
@Service
public class AdressBookService implements IAddressBookService {

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private AddressBookRepository addressBookRepository;

    @Override
    public List<AddressBookResponseDto> getAllContacts() {
        return addressBookRepository.findAll().stream().map(addressBook -> modelMapper.map(addressBook, AddressBookResponseDto.class)).collect(Collectors.toList());
    }

    @Override
    public AddressBookResponseDto getContactById(int contactId) {
        return addressBookRepository.findById(contactId).stream().map(addressBook -> modelMapper.map(addressBook, AddressBookResponseDto.class)).findFirst().orElseThrow(() -> new CustomException(ExceptionConstant.ID_NOT_FOUND.getMessage()));
    }

    @Override
    public AddressBook addContact(AddressBookDto addressBookDto) {
        AddressBook addressBook = new AddressBook();
        modelMapper.map(addressBookDto, addressBook);
        return addressBookRepository.save(addressBook);
    }

    @Override
    public AddressBook UpdateContact(int contactId, AddressBookDto addressBookDto) {
        AddressBookResponseDto addressBookResponseDto = this.getContactById(contactId);
        AddressBook addressBook = new AddressBook();
        modelMapper.map(addressBookDto, addressBookResponseDto);
        modelMapper.map(addressBookResponseDto, addressBook);
        return addressBookRepository.save(addressBook);
    }

    @Override
    public void deleteContact(int contactId) {
        AddressBookResponseDto addressBookResponseDto = this.getContactById(contactId);
        AddressBook addressBook = new AddressBook();
        modelMapper.map(addressBookResponseDto, addressBook);
        addressBookRepository.delete(addressBook);
    }
}

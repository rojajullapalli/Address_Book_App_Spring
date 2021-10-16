package com.bridgelabz.address_book_app_spring.service;

import com.bridgelabz.address_book_app_spring.constant.ExceptionConstant;
import com.bridgelabz.address_book_app_spring.dto.AddressBookDto;
import com.bridgelabz.address_book_app_spring.dto.AddressBookResponseDto;
import com.bridgelabz.address_book_app_spring.exceptions.CustomException;
import com.bridgelabz.address_book_app_spring.model.AddressBook;
import com.bridgelabz.address_book_app_spring.repository.AddressBookRepository;
import io.swagger.models.Response;
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
    public AddressBookResponseDto addContact(AddressBookDto addressBookDto) {
        AddressBook addressBook = modelMapper.map(addressBookDto, AddressBook.class);
        addressBookRepository.save(addressBook);
        return modelMapper.map(addressBook, AddressBookResponseDto.class);
    }

    @Override
    public AddressBook UpdateContact(int contactId, AddressBookDto addressBookDto) {
        AddressBookResponseDto addressBookResponseDto = this.getContactById(contactId);
        modelMapper.map(addressBookDto, addressBookResponseDto);
        AddressBook addressBook = modelMapper.map(addressBookResponseDto, AddressBook.class);
        return addressBookRepository.save(addressBook);
    }

    @Override
    public AddressBook deleteContact(int contactId) {
        AddressBookResponseDto addressBookResponseDto = this.getContactById(contactId);
        AddressBook addressBook = modelMapper.map(addressBookResponseDto, AddressBook.class);
        addressBookRepository.delete(addressBook);
        return addressBook;
    }
}

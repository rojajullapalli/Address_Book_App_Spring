package com.bridgelabz.address_book_app_spring.service;

import com.bridgelabz.address_book_app_spring.dto.AddressBookDto;
import com.bridgelabz.address_book_app_spring.dto.AddressBookResponseDto;
import com.bridgelabz.address_book_app_spring.exceptions.CustomException;
import com.bridgelabz.address_book_app_spring.model.AddressBook;
import com.bridgelabz.address_book_app_spring.repository.AddressBookRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class AddressBookServiceTest {

    @InjectMocks
    private AdressBookService adressBookService;

    @Mock
    private AddressBookRepository addressBookRepository;
    @Mock
    private ModelMapper modelMapper;

    @Test
    void whengetallContacts_ShouldReturnAllContacts() {
        AddressBook addressBook = new AddressBook();
        addressBook.setFirstName("Roja");
        AddressBookResponseDto addressBookResponseDto = new AddressBookResponseDto();
        addressBookResponseDto.setFirstName("Roja");
        when(addressBookRepository.findAll()).thenReturn(List.of(addressBook));
        when(modelMapper.map(addressBook, AddressBookResponseDto.class)).thenReturn(addressBookResponseDto);
        List<AddressBookResponseDto> contacts = adressBookService.getAllContacts();
        Assertions.assertEquals(1, contacts.size());
    }

    @Test
    void WhenUserEnteredSpecifiedContactId_ShouldReturnDataOfSpecifiedContactId() {
        AddressBook addressBook = new AddressBook();
        addressBook.setFirstName("Roja");
        AddressBookResponseDto addressBookResponseDto = new AddressBookResponseDto();
        addressBookResponseDto.setFirstName("Roja");
        when(addressBookRepository.findById(1)).thenReturn(Optional.of(addressBook));
        when(modelMapper.map(addressBook, AddressBookResponseDto.class)).thenReturn(addressBookResponseDto);
        AddressBookResponseDto actualContact = adressBookService.getContactById(1);
        assertNotNull(actualContact);
    }

    @Test
    void whenGetContactByIdCalled_shouldThrowException() {
        when(addressBookRepository.findById(1)).thenReturn(Optional.empty());
        assertThrows(CustomException.class, () -> adressBookService.getContactById(1));
    }

    @Test
    void givenContactData_WhenaddContact_ShouldAddInToDatabase() {
        AddressBookDto addressBookDto = new AddressBookDto();
        addressBookDto.setFirstName("Roja");
        System.out.println(addressBookDto);

        AddressBook addressBook = new AddressBook();
        addressBook.setFirstName(addressBookDto.getFirstName());
        System.out.println(addressBook);

        AddressBookResponseDto addressBookResponseDto = new AddressBookResponseDto();
        addressBookResponseDto.setFirstName(addressBook.getFirstName());
        System.out.println(addressBookResponseDto);
        when(modelMapper.map(addressBookDto, AddressBook.class)).thenReturn(addressBook);
        when(modelMapper.map(addressBook, AddressBookResponseDto.class)).thenReturn(addressBookResponseDto);
        AddressBookResponseDto actualAddressBookResponseDto = adressBookService.addContact(addressBookDto);
        Assertions.assertEquals(addressBook.getFirstName(), actualAddressBookResponseDto.getFirstName());
        verify(addressBookRepository, times(1)).save(addressBook);
    }

    @Test
    void givenContactData_WhenupdateContact_ShouldUpdateTheExsistingData(){
        int contactId=1;
        AddressBookDto addressBookDto=new AddressBookDto();
        addressBookDto.setFirstName("Roja");
        AddressBookResponseDto addressBookResponseDto = new AddressBookResponseDto();
        addressBookResponseDto.setFirstName("Rojajules");
        AddressBook addressBook = new AddressBook();
        addressBook.setFirstName(addressBookDto.getFirstName());
        //System.out.println(addressBookRepository.findById(contactId));
        when(addressBookRepository.findById(contactId)).thenReturn(Optional.of(addressBook));

        //when(modelMapper.map(addressBookDto, AddressBookResponseDto.class)).thenReturn(addressBookResponseDto);
        when(modelMapper.map(addressBook,AddressBookResponseDto.class)).thenReturn(addressBookResponseDto);
        AddressBook addressBook1 =adressBookService.UpdateContact(contactId,addressBookDto);
        assertNotNull(addressBook1);

    }

    @Test
    void givenId_WhendeleteContact_ShouldDeleteTheRespectiveDataOfId() {
        AddressBookResponseDto addressBookResponseDto = new AddressBookResponseDto();
        int contactid=1;
        addressBookResponseDto.setId(contactid);
        AddressBook addressBook = new AddressBook();
        addressBook.setId(contactid);
        when(addressBookRepository.findById(contactid)).thenReturn(Optional.of(addressBook));
        when(modelMapper.map(addressBook, AddressBookResponseDto.class)).thenReturn(addressBookResponseDto);
        AddressBook addressBook1 = adressBookService.deleteContact(contactid);
        Assertions.assertEquals(null,addressBook1);
    }
}

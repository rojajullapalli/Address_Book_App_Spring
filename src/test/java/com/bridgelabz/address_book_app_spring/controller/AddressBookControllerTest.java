package com.bridgelabz.address_book_app_spring.controller;

import com.bridgelabz.address_book_app_spring.constant.ControllerConstant;
import com.bridgelabz.address_book_app_spring.dto.AddressBookDto;
import com.bridgelabz.address_book_app_spring.dto.AddressBookResponseDto;
import com.bridgelabz.address_book_app_spring.dto.ResponseDto;
import com.bridgelabz.address_book_app_spring.model.AddressBook;
import com.bridgelabz.address_book_app_spring.service.AdressBookService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
public class AddressBookControllerTest {
    @InjectMocks
    private AddressBookController addressBookController;
    @Mock
    private AdressBookService addressBookService;

    @Test
    void GivenContactId_WhenCalled_ShouldReturngetContactOfSpecifiedId() {
        ResponseDto responseDTO = new ResponseDto();
        responseDTO.setMessage(ControllerConstant.GET_BYID.getMessage());
        AddressBookResponseDto respContactDTO = new AddressBookResponseDto();
        respContactDTO.setFirstName("test");
        responseDTO.setData(respContactDTO);
        Mockito.when(addressBookService.getContactById(1)).thenReturn(respContactDTO);
        ResponseEntity<ResponseDto> actualResponseEntity = addressBookController.getContactById(1);
        assertNotNull(actualResponseEntity);
        assertEquals("test", ((AddressBookResponseDto) actualResponseEntity.getBody().getData()).getFirstName());
    }

    @Test
    void givenGetAllContact_WhenCalled_ShouldReturnNumberOfContacts() {
        ResponseDto responseDto = new ResponseDto();
        responseDto.setMessage(ControllerConstant.GET_ALL.getMessage());
        AddressBookResponseDto addressBookResponseDto = new AddressBookResponseDto();
        addressBookResponseDto.setFirstName("Roja");
        responseDto.setData(addressBookResponseDto);
        Mockito.when(addressBookService.getAllContacts()).thenReturn(List.of(addressBookResponseDto));
        List<AddressBookResponseDto> contacts = addressBookService.getAllContacts();
        Assertions.assertEquals(1, contacts.size());
    }

    @Test
    void givenContactData_WhenaddContact_ShouldAddInToDatabase() {
        ResponseDto responseDto = new ResponseDto();
        responseDto.setMessage(ControllerConstant.POST_CONTACT.getMessage());
        AddressBookResponseDto addressBookResponseDto = new AddressBookResponseDto();
        addressBookResponseDto.setFirstName("Roja");
        AddressBookDto addressBookDto = new AddressBookDto();
        addressBookDto.setFirstName(addressBookResponseDto.getFirstName());
        AddressBook addressBook = new AddressBook();
        addressBook.setFirstName(addressBookDto.getFirstName());
        responseDto.setData(addressBookResponseDto);
        Mockito.when(addressBookService.addContact(addressBookDto)).thenReturn(addressBookResponseDto);
        ResponseEntity<ResponseDto> actualResponseEntity = addressBookController.addContact(addressBookDto);
        assertNotNull(actualResponseEntity);
        assertEquals("Roja", ((AddressBookResponseDto) actualResponseEntity.getBody().getData()).getFirstName());
    }

    @Test
    void givenContactData_WhenupdateContact_ShouldUpdateTheExsistingData() {
       ResponseDto responseDto = new ResponseDto();
       responseDto.setMessage(ControllerConstant.PUT_CONTACT.getMessage());
       AddressBookDto addressBookDto = new AddressBookDto();
       addressBookDto.setFirstName("RojaJules");
        AddressBook addressBook = new AddressBook();
        addressBook.setId(1);
        addressBook.setFirstName(addressBookDto.getFirstName());
       Mockito.when(addressBookService.UpdateContact(1,addressBookDto)).thenReturn(addressBook);
       ResponseEntity<ResponseDto> actualResponseEntity = addressBookController.updateContact(1,addressBookDto);
       assertNotNull(actualResponseEntity);
       assertEquals("RojaJules",((AddressBook)actualResponseEntity.getBody().getData()).getFirstName());
    }

    @Test
    void givenId_WhendeleteContact_ShouldDeleteTheRespectiveDataOfId() {
        ResponseDto responseDto = new ResponseDto();
        responseDto.setMessage(ControllerConstant.DELETE_CONTACT.getMessage());
        AddressBook addressBook = new AddressBook();
        addressBook.setId(1);
        Mockito.when(addressBookService.deleteContact(1)).thenReturn(addressBook);
        ResponseEntity<ResponseDto> actualResponseEntity = addressBookController.deleteContact(1);
        assertEquals(addressBook,actualResponseEntity.getBody().getData());
    }
}

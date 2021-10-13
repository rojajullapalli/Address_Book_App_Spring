package com.bridgelabz.address_book_app_spring.dto;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

/**
 * creates and maintains AddressBook as object (DTO)
 *
 * @author roja julapalli
 * @version 0.0.1
 * @since 13-10-2021
 */
@Data
@AllArgsConstructor
public class AddressBookDto {
    @NotNull
    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z]{2,}$", message = "name should contains atleast 2 characters...first letter should be caps")
    private String firstName;
    @NotBlank(message = "city should not be blank")
    private String city;
    @NotBlank(message = "state should not be blank")
    private String state;
    @NotNull
    @Pattern(regexp = "^[0-9]{6}$", message = "pincode should cpntains 6 digits")
    private String pincode;
    @NotNull
    @Pattern(regexp = "^[1-9]{2}[-]{1}[1-9]{10}$", message = "number should follow 91-7645345678")
    private String phoneNumber;
}

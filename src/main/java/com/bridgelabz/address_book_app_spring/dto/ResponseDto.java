package com.bridgelabz.address_book_app_spring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResponseDto {
    private String message;
    private Object data;
}

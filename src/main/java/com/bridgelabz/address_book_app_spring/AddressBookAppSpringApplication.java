package com.bridgelabz.address_book_app_spring;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@Slf4j
@EnableSwagger2
public class AddressBookAppSpringApplication {

    public static void main(String[] args) {
       SpringApplication.run(AddressBookAppSpringApplication.class, args);
    }

}

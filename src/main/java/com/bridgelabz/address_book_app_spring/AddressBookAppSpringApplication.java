package com.bridgelabz.address_book_app_spring;

import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.core.ApplicationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class AddressBookAppSpringApplication {

    public static void main(String[] args) {
       SpringApplication.run(AddressBookAppSpringApplication.class, args);
        log.info("");
    }

}

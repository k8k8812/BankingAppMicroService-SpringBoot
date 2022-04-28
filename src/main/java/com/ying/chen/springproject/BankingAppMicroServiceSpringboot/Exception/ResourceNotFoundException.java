package com.ying.chen.springproject.BankingAppMicroServiceSpringboot.Exception;

import java.time.LocalDateTime;

public class ResourceNotFoundException extends Exception {

    public ResourceNotFoundException(String message, LocalDateTime dateTime){
        super();
    }
}

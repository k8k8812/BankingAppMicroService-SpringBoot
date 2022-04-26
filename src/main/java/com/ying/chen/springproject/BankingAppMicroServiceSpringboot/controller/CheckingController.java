package com.ying.chen.springproject.BankingAppMicroServiceSpringboot.controller;

import com.ying.chen.springproject.BankingAppMicroServiceSpringboot.model.CheckingAccount;
import com.ying.chen.springproject.BankingAppMicroServiceSpringboot.service.CheckingAccountService;
import com.ying.chen.springproject.BankingAppMicroServiceSpringboot.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/checkingAccount")
public class CheckingController {

    private final CheckingAccountService checkingService;

    @Autowired
    public CheckingController(CheckingAccountService checkingService) {
        this.checkingService = checkingService;
    }

    @GetMapping("/")
    public List<CheckingAccount> getAccount(){
        return checkingService.getAllCheckingAccount();
    }

    @PostMapping("/add/{customerId}")
    public ResponseEntity<?> addCheckingAccount(@PathVariable Long customerId){
        checkingService.addCheckingAccountToCustomer(customerId);
        return ResponseEntity.status(HttpStatus.OK).body("Successfully Added New Account to Existed Customer ID: "+ customerId);
    }

}

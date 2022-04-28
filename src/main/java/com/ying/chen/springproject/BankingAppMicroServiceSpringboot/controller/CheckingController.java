package com.ying.chen.springproject.BankingAppMicroServiceSpringboot.controller;

import com.ying.chen.springproject.BankingAppMicroServiceSpringboot.Exception.ResourceNotFoundException;
import com.ying.chen.springproject.BankingAppMicroServiceSpringboot.model.CheckingAccount;
import com.ying.chen.springproject.BankingAppMicroServiceSpringboot.service.CheckingAccountService;
import com.ying.chen.springproject.BankingAppMicroServiceSpringboot.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.nio.file.Path;
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

    @PatchMapping("/update/{accountId}")
    public ResponseEntity<?> updateCheckingAccount(@PathVariable Long accountId, @RequestBody CheckingAccount checking) throws ResourceNotFoundException {
        checkingService.updateCheckingAccountInfo(accountId, checking);
        return ResponseEntity.status(HttpStatus.OK).body("Successfully update checking account with ID: " + accountId);
    }

    @PostMapping("/deposit/{customerId}/{money}")
    public ResponseEntity<?> depositCheckingAccount(@PathVariable Long customerId, @PathVariable BigDecimal money ) throws ResourceNotFoundException {
        checkingService.deposit(customerId, money);
        return ResponseEntity.status(HttpStatus.OK).body("Successfully deposit money $"+ money + " into customer with ID: "+ customerId);
    }

}

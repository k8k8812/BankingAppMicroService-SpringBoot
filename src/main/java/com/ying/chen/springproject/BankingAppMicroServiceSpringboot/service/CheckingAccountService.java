package com.ying.chen.springproject.BankingAppMicroServiceSpringboot.service;

import com.ying.chen.springproject.BankingAppMicroServiceSpringboot.model.CheckingAccount;
import com.ying.chen.springproject.BankingAppMicroServiceSpringboot.model.Customer;
import com.ying.chen.springproject.BankingAppMicroServiceSpringboot.repository.CheckingAccountRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

import java.util.List;
import java.util.Optional;

@Service
public class CheckingAccountService {

    private final CheckingAccountRepository checkingRepo;

    public CheckingAccountService(CheckingAccountRepository checkingRepo) {
        this.checkingRepo = checkingRepo;
    }

    public List<CheckingAccount> getAllCheckingAccount() {
        return checkingRepo.findAll();
    }

    public CheckingAccount getCheckingAccountById(Long id) {
        Optional<CheckingAccount> found = checkingRepo.findById(id);
        if(found.isPresent()){
            return found.get();
        }
        return null;
    }

    public void activateCheckingAccount(Customer customer){

        CheckingAccount activateChecking =
                new CheckingAccount(-1L,BigDecimal.ZERO, BigDecimal.ZERO, null,"activate", customer);
        checkingRepo.save(activateChecking);
    }

}

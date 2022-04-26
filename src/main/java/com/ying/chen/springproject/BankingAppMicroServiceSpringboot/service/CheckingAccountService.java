package com.ying.chen.springproject.BankingAppMicroServiceSpringboot.service;

import com.ying.chen.springproject.BankingAppMicroServiceSpringboot.model.CheckingAccount;
import com.ying.chen.springproject.BankingAppMicroServiceSpringboot.model.Customer;
import com.ying.chen.springproject.BankingAppMicroServiceSpringboot.repository.CheckingAccountRepository;
import org.hibernate.annotations.Check;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CheckingAccountService {

    private final CheckingAccountRepository checkingRepo;

    @Autowired
    private CustomerService customerService;

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


    public void addCheckingAccountToCustomer(Long customerId){
        Optional<Customer> find = Optional.of(customerService.getCustomerById(customerId));

        if(find.isPresent()){
            CheckingAccount newChecking = new CheckingAccount(-1L, BigDecimal.ZERO, BigDecimal.ZERO, new Date(), "activate", find.get());
            checkingRepo.save(newChecking);
        }else{
            throw new NullPointerException("Sorry but the Customer ID Given Does not exist!");
        }
    }

}

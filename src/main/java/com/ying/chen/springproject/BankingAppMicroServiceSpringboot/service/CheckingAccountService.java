package com.ying.chen.springproject.BankingAppMicroServiceSpringboot.service;

import com.ying.chen.springproject.BankingAppMicroServiceSpringboot.Exception.ResourceNotFoundException;
import com.ying.chen.springproject.BankingAppMicroServiceSpringboot.model.CheckingAccount;
import com.ying.chen.springproject.BankingAppMicroServiceSpringboot.model.Customer;
import com.ying.chen.springproject.BankingAppMicroServiceSpringboot.repository.CheckingAccountRepository;
import org.hibernate.annotations.Check;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

import java.time.LocalDateTime;
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

    public void updateCheckingAccountInfo(Long accountId, CheckingAccount checking) throws ResourceNotFoundException {
        Optional<CheckingAccount> find = checkingRepo.findById(accountId);
        if(find.isPresent()){
            find.get().setAction(checking.getAction());
            find.get().setPrevious_balance(checking.getPrevious_balance());
            find.get().setCurrent_balance(checking.getCurrent_balance());
            find.get().setDate(new Date());
            checkingRepo.save(find.get());
        }else {
            throw new ResourceNotFoundException("uh-oh, checking account not found", LocalDateTime.now());
        }
    }

    public void deposit(Long customerId, BigDecimal money) throws ResourceNotFoundException {

        Optional<CheckingAccount> checking = checkingRepo.findByCustomerId(customerId);
        CheckingAccount newRecord = new CheckingAccount();

        if(checking.isPresent()){
            newRecord.setPrevious_balance(checking.get().getCurrent_balance());
            newRecord.setCurrent_balance(checking.get().getCurrent_balance().add(money));
            newRecord.setAction("deposit");
            newRecord.setDate(new Date());
            newRecord.setCustomer(checking.get().getCustomer());
            checkingRepo.save(newRecord);
        }else{
            throw new ResourceNotFoundException("uh-oh, checking account not found", LocalDateTime.now());
        }
    }



}

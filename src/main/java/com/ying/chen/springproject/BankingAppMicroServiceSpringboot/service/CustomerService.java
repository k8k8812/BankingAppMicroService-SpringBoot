package com.ying.chen.springproject.BankingAppMicroServiceSpringboot.service;

import com.ying.chen.springproject.BankingAppMicroServiceSpringboot.model.Customer;
import com.ying.chen.springproject.BankingAppMicroServiceSpringboot.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    @Autowired
    private CheckingAccountService checkingService;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> getAllCustomers(){
        return customerRepository.findAll();
    }

    //once a new customer is created, a new checking account will be created too;
    public void addNewCustomer(Customer customer) {
        Optional<Customer> found =
                customerRepository.getCustomerByEmail(customer.getEmail()); //check if email is presented in the database;
//
        if(found.isPresent()){
            throw new IllegalStateException(">>>>>> Email taken >>>>>>>!");
        }
        customerRepository.save(customer);
        checkingService.activateCheckingAccount(customer);

    }

    public Customer getCustomerById(Long id){
        Optional<Customer> found =
                Optional.of(customerRepository.getById(id));

        if(found.isPresent()){
            return found.get();
        }
        return null;

    }


}

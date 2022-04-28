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
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> getAllCustomers(){

        return customerRepository.findAll();
    }


    public void addNewCustomer(Customer customer) {
        Optional<Customer> found =
                customerRepository.getCustomerByEmail(customer.getEmail()); //check if email is presented in the database;
//
        if(found.isPresent()){
            throw new IllegalStateException(">>>>>> Email taken >>>>>>>!");
        }else{
            Customer toAdd = new Customer();
            toAdd.setEmail(customer.getEmail());
            toAdd.setContactNumber(customer.getContactNumber());
            toAdd.setFirstName(customer.getFirstName());
            toAdd.setLastName(customer.getLastName());
            toAdd.setPassword(customer.getPassword());
            customerRepository.save(toAdd);
        }

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

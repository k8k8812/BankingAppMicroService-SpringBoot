package com.ying.chen.springproject.BankingAppMicroServiceSpringboot.controller;

import com.ying.chen.springproject.BankingAppMicroServiceSpringboot.model.Customer;
import com.ying.chen.springproject.BankingAppMicroServiceSpringboot.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {
    @Autowired
    private CustomerService customerService;


    @GetMapping("/")
    public List<Customer> getCustomers(){
       return customerService.getAllCustomers();
   }

   @PostMapping("/add")
   public void registerNewCustomer(@RequestBody Customer customer){
        customerService.addNewCustomer(customer);

   }
}

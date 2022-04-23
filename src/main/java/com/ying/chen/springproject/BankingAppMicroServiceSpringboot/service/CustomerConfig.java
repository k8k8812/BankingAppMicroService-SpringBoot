package com.ying.chen.springproject.BankingAppMicroServiceSpringboot.service;

import com.ying.chen.springproject.BankingAppMicroServiceSpringboot.model.Customer;
import com.ying.chen.springproject.BankingAppMicroServiceSpringboot.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class CustomerConfig {

    @Autowired
    CustomerRepository customerRepository;

//    @Bean
//    CommandLineRunner commandLineRunner(){   //added two records into database using CommandLineRunner;
//        return args -> {
//            Customer customer1 = new Customer(
//                   -1L,"Mariah", "Klemn", "323-322-2445", "mariahKlemn@gmail.com", null
//            );
//            Customer customer2 = new Customer(
//                    -1L,"Super", "Mario", "887-238-8222", "SuperMario@gmail.com",null
//            );
//            customerRepository.saveAll(List.of(customer1, customer2));
//        };
//
//    }
}

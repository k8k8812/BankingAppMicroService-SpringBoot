package com.ying.chen.springproject.BankingAppMicroServiceSpringboot.repository;


import com.ying.chen.springproject.BankingAppMicroServiceSpringboot.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Optional<Customer> getCustomerByEmail(String email);



}

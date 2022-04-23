package com.ying.chen.springproject.BankingAppMicroServiceSpringboot.repository;


import com.ying.chen.springproject.BankingAppMicroServiceSpringboot.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}

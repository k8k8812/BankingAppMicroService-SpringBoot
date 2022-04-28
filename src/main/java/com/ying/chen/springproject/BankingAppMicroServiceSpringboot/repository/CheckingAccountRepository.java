package com.ying.chen.springproject.BankingAppMicroServiceSpringboot.repository;

import com.ying.chen.springproject.BankingAppMicroServiceSpringboot.model.CheckingAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CheckingAccountRepository extends JpaRepository<CheckingAccount, Long> {

    Optional<CheckingAccount> findByCustomerId(Long customerId);
}

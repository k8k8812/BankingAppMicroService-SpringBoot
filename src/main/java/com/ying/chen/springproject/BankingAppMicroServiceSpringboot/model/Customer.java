package com.ying.chen.springproject.BankingAppMicroServiceSpringboot.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.Check;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table( name = "customer")
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull(message = "First Name Cannot Be Blank.")
    private String firstName;

    @NotBlank(message = "Must Give a Last Name.")
    private String lastName;

    @NotNull(message = "A Contact Number needed.")
    @Column(columnDefinition = "varchar(30) default '000-000' ")
    private String contactNumber;

    @NotBlank(message = "Please Enter your email address.")
    @Column(unique = true, nullable = false)
    private String email;

    @JsonIgnore
    @OneToMany(mappedBy = "customer")
    private List<CheckingAccount> checkingAccountList;

    public CheckingAccount getIndividualAccount(Long id){
        for(int idx = 0; idx<checkingAccountList.size(); idx++){
            if(checkingAccountList.get(idx).getAccount_id() == id){
                return checkingAccountList.get(idx);
            }
        }return new CheckingAccount();
    }

    //one customer can have more than one checking account, hence the addCheckingAccount();
    public void addCheckingAccount(CheckingAccount checkingAccount){
        checkingAccount.setCustomer(this);
        checkingAccountList.add(checkingAccount);
    }

    //update one of the checking accounts;
    public void updateChecking(CheckingAccount checkingAccount){
        CheckingAccount toUpdate = getIndividualAccount(checkingAccount.getAccount_id());
        toUpdate.setAction(checkingAccount.getAction());
        toUpdate.setCurrent_balance(checkingAccount.getCurrent_balance());
        toUpdate.setPrevious_balance(checkingAccount.getPrevious_balance());
        toUpdate.setDate(checkingAccount.getDate());
    }
}

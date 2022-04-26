package com.ying.chen.springproject.BankingAppMicroServiceSpringboot.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CheckingAccount extends Account {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long account_id;

    //    @SequenceGenerator (
//            defines a primary key generator that may be referenced by
//            name when a generator element is specified for the GeneratedValue annotation.
//            but Mysql does not require sequence generator; it's got auto_increment;

//            name = "checking_account_sequence",
//            sequenceName = "checking_account_sequence",
//            initialValue = 1,
//            allocationSize = 1
//    )

    @Column(columnDefinition ="DECIMAL default '0.0' " )
    private BigDecimal current_balance;

    @Column(columnDefinition ="DECIMAL default '0.0' "  )
    private BigDecimal previous_balance;

    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm", timezone = "EST")
    private Date date;

    @NotNull
    private String action;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    private Customer customer;

    //constructor for manually adding one more checking account at CheckingService;
    public CheckingAccount(Long account_id, BigDecimal current_balance, BigDecimal previous_balance, Date date, String action, Long customerId){
        this.account_id = account_id;
        this.current_balance = current_balance;
        this.previous_balance = previous_balance;
        this.date = date;
        this.action = action;
        this.customer.setId(customerId);
    }


    public CheckingAccount(BigDecimal current_balance, BigDecimal previous_balance,String action) {
        super(current_balance, previous_balance, action);
    }



}

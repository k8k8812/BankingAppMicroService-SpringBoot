package com.ying.chen.springproject.BankingAppMicroServiceSpringboot.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CheckingAccount extends Account {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    //    @SequenceGenerator (
//            defines a primary key generator that may be referenced by
//            name when a generator element is specified for the GeneratedValue annotation.
//            but Mysql does not require sequence generator; it's got auto_increment;

//            name = "checking_account_sequence",
//            sequenceName = "checking_account_sequence",
//            initialValue = 1,
//            allocationSize = 1
//    )

    @Column(columnDefinition ="DECIMAL" )
    private BigDecimal current_balance;
    private BigDecimal previous_balance;

    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:MM", timezone = "EST")
    private Date date;

    @NotNull
    private String action;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id", referencedColumnName = "id", nullable = false)
    private Customer customer;



    public CheckingAccount(BigDecimal current_balance, BigDecimal previous_balance,String action) {
        super(current_balance, previous_balance, action);
    }


}

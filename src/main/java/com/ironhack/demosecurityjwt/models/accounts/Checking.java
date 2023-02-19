package com.ironhack.demosecurityjwt.models.accounts;

import com.ironhack.demosecurityjwt.models.users.AccountHolder;
import com.ironhack.demosecurityjwt.tools.Status;
import jakarta.persistence.Entity;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Checking extends Account{
    /* - secretKey: String;
- minimumBalance: BigDecimal;
- monthlyMaintenanceFee: BigDecimal;*/
    private String secretKey;
    private BigDecimal minimumBalance;
    private BigDecimal monthlyMaintenanceFee;

    //should have a minimumBalance of 250
    private static final BigDecimal MINIMUM_BALANCE = new BigDecimal("250.00");

    //should have a monthlyMaintenanceFee of 12
    private static final BigDecimal MONTHLY_MAINTENANCE_FEE = new BigDecimal("12.00");

    public Checking() {
    }

    public Checking(AccountHolder accountHolder) {
        super(BigDecimal.valueOf(0.00), accountHolder, null, LocalDate.now(), null);
        setSecretKey("123");
        setMinimumBalance(null);
        setMonthlyMaintenanceFee(null);
        setStatus(Status.ACTIVE);
    }
    public Checking(BigDecimal balance, AccountHolder primaryOwner, AccountHolder secondaryOwner, LocalDate creationDate, LocalDate updateDate, Status status) {
        super(balance, primaryOwner, secondaryOwner, creationDate, updateDate, status);
    }

    public Checking(BigDecimal balance, String secretKey, AccountHolder primaryOwner, AccountHolder secondaryOwner, LocalDate creationDate) {
        super(balance, primaryOwner, secondaryOwner, creationDate);
        this.creationDate = creationDate;
    }

    public Checking(String secretKey, BigDecimal minimumBalance, BigDecimal monthlyMaintenanceFee) {
        this.secretKey = secretKey;
        setMinimumBalance(minimumBalance);
        setMonthlyMaintenanceFee(monthlyMaintenanceFee);
    }

    public Checking(BigDecimal balance, AccountHolder primaryOwner, AccountHolder secondayOwner, LocalDate creationDate, LocalDate updateDate, Status status, String secretKey, BigDecimal minimumBalance, BigDecimal monthlyMaintenanceFee) {
        super(balance, primaryOwner, secondayOwner, creationDate, updateDate, status);
        this.secretKey = secretKey;
        setMinimumBalance(minimumBalance);
        setMonthlyMaintenanceFee(monthlyMaintenanceFee);
    }


    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public BigDecimal getMinimumBalance() {
        return minimumBalance;
    }

    public void setMinimumBalance(BigDecimal minimumBalance) {
        this.minimumBalance = MINIMUM_BALANCE;
    }

    public BigDecimal getMonthlyMaintenanceFee() {
        return monthlyMaintenanceFee;
    }

    public void setMonthlyMaintenanceFee(BigDecimal monthlyMaintenanceFee) {
        this.monthlyMaintenanceFee = MONTHLY_MAINTENANCE_FEE;
    }
}

package com.ironhack.demosecurityjwt.models.accounts;

import com.ironhack.demosecurityjwt.models.users.AccountHolder;
import com.ironhack.demosecurityjwt.tools.Status;
import jakarta.persistence.Entity;

import java.math.BigDecimal;
import java.util.Date;

@Entity
public class Checking extends Account{
    /* - secretKey: String;
- minimumBalance: BigDecimal;
- monthlyMaintenanceFee: BigDecimal;*/
    private String secretKey;

    private BigDecimal minimumBalance;

    private BigDecimal monthlyMaintenanceFee;

    public Checking() {
    }

    public Checking(BigDecimal balance, AccountHolder primaryOwner, AccountHolder secondayOwner, BigDecimal penaltyFee, Date creationDate, Date updateDate, Status status) {
        super(balance, primaryOwner, secondayOwner, penaltyFee, creationDate, updateDate, status);
    }

    public Checking(String secretKey, BigDecimal minimumBalance, BigDecimal monthlyMaintenanceFee) {
        this.secretKey = secretKey;
        this.minimumBalance = minimumBalance;
        this.monthlyMaintenanceFee = monthlyMaintenanceFee;
    }

    public Checking(BigDecimal balance, AccountHolder primaryOwner, AccountHolder secondayOwner, BigDecimal penaltyFee, Date creationDate, Date updateDate, Status status, String secretKey, BigDecimal minimumBalance, BigDecimal monthlyMaintenanceFee) {
        super(balance, primaryOwner, secondayOwner, penaltyFee, creationDate, updateDate, status);
        this.secretKey = secretKey;
        this.minimumBalance = minimumBalance;
        this.monthlyMaintenanceFee = monthlyMaintenanceFee;
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
        this.minimumBalance = minimumBalance;
    }

    public BigDecimal getMonthlyMaintenanceFee() {
        return monthlyMaintenanceFee;
    }

    public void setMonthlyMaintenanceFee(BigDecimal monthlyMaintenanceFee) {
        this.monthlyMaintenanceFee = monthlyMaintenanceFee;
    }
}

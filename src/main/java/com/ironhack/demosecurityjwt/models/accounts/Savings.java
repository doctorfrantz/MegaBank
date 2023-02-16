package com.ironhack.demosecurityjwt.models.accounts;

import com.ironhack.demosecurityjwt.models.users.AccountHolder;
import com.ironhack.demosecurityjwt.tools.Status;
import jakarta.persistence.Entity;

import java.math.BigDecimal;
import java.util.Date;

@Entity
public class Savings extends Account{
    /* - interestRate: BigDecimal;
- secretKey: String;
- minimumBalance: Money;*/
    private BigDecimal interestRate;

    private String secretKey;
    private BigDecimal minimumBalance;

    public Savings() {
    }

    public Savings(BigDecimal balance, AccountHolder primaryOwner, AccountHolder secondayOwner, BigDecimal penaltyFee, Date creationDate, Date updateDate, Status status) {
        super(balance, primaryOwner, secondayOwner, penaltyFee, creationDate, updateDate, status);
    }

    public Savings(BigDecimal interestRate, String secretKey, BigDecimal minimumBalance) {
        this.interestRate = interestRate;
        this.secretKey = secretKey;
        this.minimumBalance = minimumBalance;
    }

    public Savings(BigDecimal balance, AccountHolder primaryOwner, AccountHolder secondayOwner, BigDecimal penaltyFee, Date creationDate, Date updateDate, Status status, BigDecimal interestRate, String secretKey, BigDecimal minimumBalance) {
        super(balance, primaryOwner, secondayOwner, penaltyFee, creationDate, updateDate, status);
        this.interestRate = interestRate;
        this.secretKey = secretKey;
        this.minimumBalance = minimumBalance;
    }

    public BigDecimal getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(BigDecimal interestRate) {
        this.interestRate = interestRate;
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
}

package com.ironhack.demosecurityjwt.models.accounts;

import com.ironhack.demosecurityjwt.models.users.AccountHolder;
import com.ironhack.demosecurityjwt.tools.Status;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Savings extends Account{
    /* - interestRate: BigDecimal;
- secretKey: String;
- minimumBalance: Money;*/
    private BigDecimal interestRate;
    private String secretKey;
    private BigDecimal minimumBalance;


    // Savings accounts have a default interest rate of 0.0025
    private static final BigDecimal DEFAULT_INTEREST_RATE = new BigDecimal("0.0025");

    // Savings accounts may be instantiated with an interest rate other than the default, with a maximum interest rate of 0.5
    private static final BigDecimal MAX_INTEREST_RATE = new BigDecimal("0.5");

    // Savings accounts should have a default minimumBalance of 1000
    private static final BigDecimal DEFAULT_MINIMUM_BALANCE = new BigDecimal("1000");


    public Savings() {
        super();
        this.interestRate = DEFAULT_INTEREST_RATE;
        this.minimumBalance = DEFAULT_MINIMUM_BALANCE;
    }

    public Savings(BigDecimal balance, AccountHolder primaryOwner, AccountHolder secondayOwner, BigDecimal penaltyFee, LocalDate creationDate, LocalDate updateDate, Status status) {
        super(balance, primaryOwner, secondayOwner, penaltyFee, creationDate, updateDate, status);
    }

    public Savings(BigDecimal interestRate, String secretKey, BigDecimal minimumBalance) {
        setInterestRate(interestRate);
        this.secretKey = secretKey;
        setMinimumBalance(minimumBalance);
    }

    public Savings(String secretKey) {
        this.interestRate = DEFAULT_INTEREST_RATE;
        this.secretKey = secretKey;
        this.minimumBalance = DEFAULT_MINIMUM_BALANCE;
    }

    public Savings(BigDecimal balance, AccountHolder primaryOwner, AccountHolder secondayOwner, BigDecimal penaltyFee, LocalDate creationDate, LocalDate updateDate, Status status, BigDecimal interestRate, String secretKey, BigDecimal minimumBalance) {
        super(balance, primaryOwner, secondayOwner, penaltyFee, creationDate, updateDate, status);
        if (minimumBalance.compareTo(BigDecimal.valueOf(100)) < 0 || minimumBalance.compareTo(DEFAULT_MINIMUM_BALANCE) > 0) {
            throw new IllegalArgumentException("Savings accounts may be instantiated with a minimum balance of less than 1000 but no lower than 100");
        }
        setInterestRate(interestRate);
        this.secretKey = secretKey;
        setMinimumBalance(minimumBalance);
    }

    public Savings(BigDecimal balance, AccountHolder primaryOwner, AccountHolder secondayOwner, BigDecimal penaltyFee, LocalDate creationDate, LocalDate updateDate, Status status, String secretKey) {
        super(balance, primaryOwner, secondayOwner, penaltyFee, creationDate, updateDate, status);
        this.interestRate = DEFAULT_INTEREST_RATE;
        this.secretKey = secretKey;
        this.minimumBalance = DEFAULT_MINIMUM_BALANCE;
    }

    public BigDecimal getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(BigDecimal interestRate) {
        if(interestRate.compareTo(MAX_INTEREST_RATE) > 0) {
            this.interestRate = MAX_INTEREST_RATE;
        } else {
            this.interestRate = interestRate;
        }
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
        if(minimumBalance == null){
            this.minimumBalance = BigDecimal.valueOf(1000);
        } else if (minimumBalance.compareTo(BigDecimal.valueOf(100)) < 0){
            this.minimumBalance = BigDecimal.valueOf(100);
        } else {
            this.minimumBalance = minimumBalance;
        }
    }
}

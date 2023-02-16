package com.ironhack.demosecurityjwt.models.accounts;

import com.ironhack.demosecurityjwt.models.users.AccountHolder;
import com.ironhack.demosecurityjwt.tools.Money;
import com.ironhack.demosecurityjwt.tools.Status;
import jakarta.persistence.Entity;

import java.math.BigDecimal;
import java.util.Date;

@Entity
public class StudentChecking extends Account{
    /* - secretKey: String; */
    private String secretKey;

    public StudentChecking() {
    }

    public StudentChecking(Money balance, AccountHolder primaryOwner, AccountHolder secondayOwner, BigDecimal penaltyFee, Date creationDate, Date updateDate, Status status) {
        super(balance, primaryOwner, secondayOwner, penaltyFee, creationDate, updateDate, status);
    }

    public StudentChecking(String secretKey) {
        this.secretKey = secretKey;
    }

    public StudentChecking(Money balance, AccountHolder primaryOwner, AccountHolder secondayOwner, BigDecimal penaltyFee, Date creationDate, Date updateDate, Status status, String secretKey) {
        super(balance, primaryOwner, secondayOwner, penaltyFee, creationDate, updateDate, status);
        this.secretKey = secretKey;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }
}
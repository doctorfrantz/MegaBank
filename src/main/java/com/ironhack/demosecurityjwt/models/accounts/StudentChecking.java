package com.ironhack.demosecurityjwt.models.accounts;

import com.ironhack.demosecurityjwt.models.users.AccountHolder;
import com.ironhack.demosecurityjwt.tools.Status;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class StudentChecking extends Account{
    /* - secretKey: String; */
    private String secretKey;

    public StudentChecking() {
    }

    public StudentChecking(BigDecimal balance, AccountHolder primaryOwner, AccountHolder secondayOwner, BigDecimal penaltyFee, Date creationDate, Date updateDate, Status status) {
        super(balance, primaryOwner, secondayOwner, penaltyFee, creationDate, updateDate, status);
    }

    public StudentChecking(String secretKey) {
        this.secretKey = secretKey;
    }

    public StudentChecking(BigDecimal balance, AccountHolder primaryOwner, AccountHolder secondayOwner, BigDecimal penaltyFee, Date creationDate, Date updateDate, Status status, String secretKey) {
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

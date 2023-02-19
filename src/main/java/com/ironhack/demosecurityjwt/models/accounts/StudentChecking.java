package com.ironhack.demosecurityjwt.models.accounts;

import com.ironhack.demosecurityjwt.models.users.AccountHolder;
import com.ironhack.demosecurityjwt.tools.Status;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class StudentChecking extends Account{
    /* - secretKey: String; */
    private String secretKey;

    public StudentChecking() {
    }

    public StudentChecking(BigDecimal balance, AccountHolder primaryOwner, AccountHolder secondaryOwner, BigDecimal penaltyFee, LocalDate creationDate, LocalDate updateDate, Status status) {
        super(balance, primaryOwner, secondaryOwner, penaltyFee, creationDate, updateDate, status);
    }

    public StudentChecking(String secretKey) {
        this.secretKey = secretKey;
    }

    public StudentChecking(BigDecimal balance, AccountHolder primaryOwner, AccountHolder secondaryOwner, LocalDate creationDate, String secretKey) {
        super(balance, primaryOwner, secondaryOwner, creationDate);
        this.secretKey = secretKey;
    }

    public StudentChecking(BigDecimal balance, AccountHolder primaryOwner, AccountHolder secondaryOwner, BigDecimal penaltyFee, LocalDate creationDate, LocalDate updateDate, Status status, String secretKey) {
        super(balance, primaryOwner, secondaryOwner, penaltyFee, creationDate, updateDate, status);
        this.secretKey = secretKey;
    }






    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }
}

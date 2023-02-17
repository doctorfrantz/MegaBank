package com.ironhack.demosecurityjwt.models.accounts;

import com.ironhack.demosecurityjwt.models.users.AccountHolder;
import com.ironhack.demosecurityjwt.tools.Status;
import jakarta.persistence.Entity;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class CreditCard extends Account{
    /* - creditLimit: Money;
- interestRate: BigDecimal;*/

    /*
    CreditCard accounts have a default creditLimit of 100
    CreditCards may be instantiated with a creditLimit higher than 100 but not higher than 100000
    CreditCards have a default interestRate of 0.2
    CreditCards may be instantiated with an interestRate less than 0.2 but not lower than 0.1
*/
    private BigDecimal creditLimit;
    private BigDecimal interestRate;

    //CreditCard accounts have a default creditLimit of 100
    private static final BigDecimal DEFAULT_CREDIT_LIMIT = new BigDecimal("100.00");

    private static final BigDecimal MAX_CREDIT_LIMIT = new BigDecimal("100000.00");

    //CreditCards have a default interestRate of 0.2
    private static final BigDecimal DEFAULT_INTEREST_RATE = new BigDecimal(("0.20"));

    //CreditCards may be instantiated with an interestRate less than 0.2 but not lower than 0.1
    private static final BigDecimal MINIMUM_INTEREST_RATE = new BigDecimal("0.10");
    public CreditCard() {
    }

    public CreditCard(BigDecimal balance, AccountHolder primaryOwner, AccountHolder secondayOwner, BigDecimal penaltyFee, Date creationDate, Date updateDate, Status status) {
        super(balance, primaryOwner, secondayOwner, penaltyFee, creationDate, updateDate, status);
    }

    public CreditCard(BigDecimal creditLimit, BigDecimal interestRate) {
        setCreditLimit(creditLimit);
        setInterestRate(interestRate);
    }

    public CreditCard(BigDecimal balance, AccountHolder primaryOwner, AccountHolder secondayOwner, BigDecimal penaltyFee, Date creationDate, Date updateDate, Status status, BigDecimal creditLimit, BigDecimal interestRate) {
        super(balance, primaryOwner, secondayOwner, penaltyFee, creationDate, updateDate, status);
        setCreditLimit(creditLimit);
        setInterestRate(interestRate);
    }

    public BigDecimal getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(BigDecimal creditLimit) {
        this.creditLimit = creditLimit;
        if(creditLimit == null){
            this.creditLimit = DEFAULT_CREDIT_LIMIT;
        } else if (creditLimit.compareTo(DEFAULT_CREDIT_LIMIT) < 0){
            this.creditLimit = DEFAULT_CREDIT_LIMIT;
        } else if (creditLimit.compareTo(MAX_CREDIT_LIMIT) > 100000){
            this.creditLimit = MAX_CREDIT_LIMIT;
        } else {
            this.creditLimit = creditLimit;
        }
    }

    public BigDecimal getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(BigDecimal interestRate) {
        if (interestRate.compareTo(MINIMUM_INTEREST_RATE) < 0 || interestRate.compareTo(DEFAULT_INTEREST_RATE) > 0) {
            throw new IllegalArgumentException("Interest rate must be between 0.1 and 0.2");
        }
        this.interestRate = interestRate;
    }

}

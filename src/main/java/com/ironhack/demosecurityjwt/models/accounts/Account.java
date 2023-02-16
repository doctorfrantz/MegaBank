package com.ironhack.demosecurityjwt.models.accounts;

import com.ironhack.demosecurityjwt.models.users.AccountHolder;
import com.ironhack.demosecurityjwt.tools.Money;
import com.ironhack.demosecurityjwt.tools.Status;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Date;

@Entity
public abstract class Account {
    /* + accountId: Integer - Auto Inc
+ balance: Money
+ primaryOwner: AccountHolder
+ secondaryOwner: @Nullable AccountHolder
+ penaltyFee: BigDecimal
+ creationDate: Date
+ updateDate: @Nullable Date
- status: Enum(FROZEN, ACTIVE);
*/
    @Id
    public Integer accountId;

    public Money balance;

    public AccountHolder primaryOwner;

    public AccountHolder secondayOwner;

    public BigDecimal penaltyFee;

    public Date creationDate;

    public Date updateDate;

    @Enumerated(EnumType.STRING)
    public Status status;

    public Account() {
    }

    public Account(Money balance, AccountHolder primaryOwner, AccountHolder secondayOwner, BigDecimal penaltyFee, Date creationDate, Date updateDate, Status status) {
        this.balance = balance;
        this.primaryOwner = primaryOwner;
        this.secondayOwner = secondayOwner;
        this.penaltyFee = penaltyFee;
        this.creationDate = creationDate;
        this.updateDate = updateDate;
        this.status = status;
    }

    public Money getBalance() {
        return balance;
    }

    public void setBalance(Money balance) {
        this.balance = balance;
    }

    public AccountHolder getPrimaryOwner() {
        return primaryOwner;
    }

    public void setPrimaryOwner(AccountHolder primaryOwner) {
        this.primaryOwner = primaryOwner;
    }

    public AccountHolder getSecondayOwner() {
        return secondayOwner;
    }

    public void setSecondayOwner(AccountHolder secondayOwner) {
        this.secondayOwner = secondayOwner;
    }

    public BigDecimal getPenaltyFee() {
        return penaltyFee;
    }

    public void setPenaltyFee(BigDecimal penaltyFee) {
        this.penaltyFee = penaltyFee;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}

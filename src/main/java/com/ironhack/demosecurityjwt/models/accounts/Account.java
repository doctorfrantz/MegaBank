package com.ironhack.demosecurityjwt.models.accounts;

import com.ironhack.demosecurityjwt.models.users.AccountHolder;
import com.ironhack.demosecurityjwt.tools.Status;
import jakarta.persistence.*;
import org.springframework.lang.Nullable;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Random;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer accountId;

    public BigDecimal balance;

    @ManyToOne
    @JoinColumn(name = "primary_owner_id")
    public AccountHolder primaryOwner;

    @ManyToOne
    @JoinColumn(name = "secondary_owner_id")
    public AccountHolder secondaryOwner;

    public BigDecimal penaltyFee;

    public LocalDate creationDate;

    public LocalDate updateDate;

    @Enumerated(EnumType.STRING)
    public Status status;

    public Account() {
    }

    public Account(BigDecimal balance, AccountHolder primaryOwner, AccountHolder secondaryOwner, LocalDate creationDate) {
        this.balance = balance;
        this.primaryOwner = primaryOwner;
        this.secondaryOwner = secondaryOwner;
        this.creationDate = creationDate;
    }

    public Account(BigDecimal balance, AccountHolder primaryOwner, AccountHolder secondayOwner, BigDecimal penaltyFee, LocalDate creationDate, LocalDate updateDate, Status status) {
        this.balance = balance;
        this.primaryOwner = primaryOwner;
        this.secondaryOwner = secondayOwner;
        this.penaltyFee = penaltyFee;
        this.creationDate = creationDate;
        this.updateDate = updateDate;
        this.status = status;
    }

    public Account(BigDecimal balance, AccountHolder accountHolder, @Nullable AccountHolder secondaryAccountHolder, LocalDate creationDate, @Nullable LocalDate lastModifiedDate) {
        setBalance(balance);
        setPrimaryOwner(accountHolder);
        setPenaltyFee(penaltyFee);
        setSecondaryOwner(secondaryAccountHolder);
        setCreationDate(creationDate);
        setUpdateDate(lastModifiedDate);
    }


    public Account(BigDecimal balance, AccountHolder primaryOwner, AccountHolder secondaryOwner, LocalDate creationDate, LocalDate updateDate, Status status) {
        this.balance = balance;
        this.primaryOwner = primaryOwner;
        this.secondaryOwner = secondaryOwner;
        this.creationDate = creationDate;
        this.updateDate = updateDate;
        this.status = status;
    }

    public void transferMoney(Account accountReceiver, BigDecimal amountToSend) {
        if (balance.compareTo(amountToSend) < 0) {
            throw new IllegalArgumentException("The amount to send cannot be greater than the account's current balance.");
        } else if (Objects.equals(accountId, accountReceiver.getAccountId())) {
            throw new IllegalArgumentException("The amount cannot be sent to the same account.");
        }
        setBalance(balance.subtract(amountToSend));
        accountReceiver.setBalance(accountReceiver.getBalance().add(amountToSend));
    }

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        Random random = new Random();
        this.accountId = random.nextInt(1000) + 1;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public AccountHolder getPrimaryOwner() {
        return primaryOwner;
    }

    public void setPrimaryOwner(AccountHolder primaryOwner) {
        this.primaryOwner = primaryOwner;
    }

    public AccountHolder getSecondaryOwner() {
        return secondaryOwner;
    }

    public void setSecondaryOwner(AccountHolder secondaryOwner) {
        this.secondaryOwner = secondaryOwner;
    }

    public BigDecimal getPenaltyFee() {
        return penaltyFee;
    }

    public void setPenaltyFee(BigDecimal penaltyFee) {
        this.penaltyFee = penaltyFee;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public LocalDate getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(LocalDate updateDate) {
        this.updateDate = updateDate;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}

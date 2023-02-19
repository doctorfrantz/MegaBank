package com.ironhack.demosecurityjwt.services.interfaces.accounts;

import com.ironhack.demosecurityjwt.models.accounts.Account;

import java.math.BigDecimal;
import java.util.List;

public interface AccountServiceInterface {

    boolean transferMoney(Integer senderAccount, String receiverName, Integer receiverAccountId, BigDecimal amount);

    List<Account> getAllAccountsById(Integer userId);
}

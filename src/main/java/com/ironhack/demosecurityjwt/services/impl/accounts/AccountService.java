package com.ironhack.demosecurityjwt.services.impl.accounts;

import com.ironhack.demosecurityjwt.models.DTO.AccountDTO;
import com.ironhack.demosecurityjwt.models.accounts.Account;
import com.ironhack.demosecurityjwt.repositories.accountsrepository.AccountRepository;
import com.ironhack.demosecurityjwt.services.interfaces.accounts.AccountServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class AccountService implements AccountServiceInterface {
    @Autowired
    AccountRepository accountRepository;

    @Autowired
    CheckingService checkingService;
    @Autowired
    SavingsService savingsService;
    @Autowired
    CreditCardService creditCardService;

    @Override
    public boolean transferMoney(Integer senderAccountId, String receiverName, Integer receiverAccountId, BigDecimal amount) {
        Optional<Account> receiverAccount = accountRepository.findByAccountIdAndPrimaryOwnerName(receiverAccountId, receiverName);
        Optional<Account> senderAccount = accountRepository.findByAccountId(senderAccountId);
        if(receiverAccount.isPresent() && senderAccount.isPresent()) {
            senderAccount.get().transferMoney(receiverAccount.get(), amount);
            accountRepository.save(senderAccount.get());
            accountRepository.save(receiverAccount.get());
        }

        return receiverAccount.isPresent() && senderAccount.isPresent();
    }

    @Override
    public List<Account> getAllAccountsById(Integer userId) {
        return accountRepository.findAllByPrimaryOwner_Id(userId);
    }

    public void createAccount(String accountType, String id, AccountDTO accountDTO) {

        switch (accountType) {
            case "checking" -> {
                checkingService.createChecking(accountDTO, id);
                break;
            }
            case "savings" -> {
                savingsService.createSavings(accountDTO, id);
                break;
            }
            case "credit" -> {
                creditCardService.createCredit(accountDTO, id);
                break;
            }
            default -> {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "The account type is not valid, please re-try.");
            }

        }
    }

}

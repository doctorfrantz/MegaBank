package com.ironhack.demosecurityjwt.controllers.impl.accounts;

import com.ironhack.demosecurityjwt.models.DTO.AccountDTO;
import com.ironhack.demosecurityjwt.models.accounts.Savings;
import com.ironhack.demosecurityjwt.repositories.accountsrepository.SavingsRepository;
import com.ironhack.demosecurityjwt.repositories.usersrepository.AccountHolderRepository;
import com.ironhack.demosecurityjwt.services.impl.accounts.SavingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class SavingsController {
    @Autowired
    SavingsService savingsService;

    @Autowired
    AccountHolderRepository accountHolderRepository;

    @Autowired
    SavingsRepository savingsRepository;


    public void createSavings(AccountDTO accountDTO, String id) {
        if (accountHolderRepository.findById(Integer.valueOf(id)).isPresent()) {

            Savings savingsAccount = new Savings();
            /*
            else {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                        "Missing parameters to properly create a Savings Account");
            }
            */

            savingsAccount.setBalance(accountDTO.getBalance());
            savingsAccount.setSecretKey(accountDTO.getSecretKey());
            savingsAccount.setPrimaryOwner(accountHolderRepository.findById(Integer.valueOf(id)).get());
            if (accountDTO.getSecondaryOwner() != null) {
                savingsAccount.setSecondaryOwner(accountDTO.getSecondaryOwner());}
            if (accountDTO.getMinimumBalance() != null) {
                savingsAccount.setMinimumBalance(accountDTO.getMinimumBalance());
            }
            savingsAccount.setCreationDate(accountDTO.getCreationDate());
            if (accountDTO.getInterestRate() == null) {

            } else {
                savingsAccount.setInterestRate(accountDTO.getInterestRate());
            }


            savingsRepository.save(savingsAccount);

        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    "An AccountHolder with this ID doesn't exits in the database");
        }
    }
}

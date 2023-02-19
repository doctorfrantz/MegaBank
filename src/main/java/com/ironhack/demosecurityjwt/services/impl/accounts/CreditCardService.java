package com.ironhack.demosecurityjwt.services.impl.accounts;

import com.ironhack.demosecurityjwt.models.DTO.AccountDTO;
import com.ironhack.demosecurityjwt.models.accounts.CreditCard;
import com.ironhack.demosecurityjwt.repositories.accountsrepository.CreditCardRepository;
import com.ironhack.demosecurityjwt.repositories.usersrepository.AccountHolderRepository;
import com.ironhack.demosecurityjwt.services.interfaces.accounts.CreditCardServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;

@Service
public class CreditCardService implements CreditCardServiceInterface {
    @Autowired
    CreditCardRepository creditCardRepository;

    @Autowired
    AccountHolderRepository accountHolderRepository;

    public void createCredit(AccountDTO accountDTO, String id) {
        if (accountHolderRepository.findById(Integer.valueOf(id)).isPresent()) {

            CreditCard creditCard = new CreditCard();

            creditCard.setBalance(accountDTO.getBalance());
            creditCard.setPrimaryOwner(accountHolderRepository.findById(Integer.valueOf(id)).get());
            if (accountDTO.getSecondaryOwner() != null) {
                creditCard.setSecondaryOwner(accountHolderRepository.findById(Integer.valueOf(id)).get());}
            if (accountDTO.getInterestRate() == null) {

            } else {
                creditCard.setInterestRate(accountDTO.getInterestRate());
            }
            creditCard.getCreditLimit();

            creditCardRepository.save(creditCard);

        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    "An AccountHolder with this ID doesn't exits in the database");
        }
    }
}

package com.ironhack.demosecurityjwt.services.impl.accounts;

import com.ironhack.demosecurityjwt.models.DTO.AccountDTO;
import com.ironhack.demosecurityjwt.models.accounts.Checking;
import com.ironhack.demosecurityjwt.models.accounts.StudentChecking;
import com.ironhack.demosecurityjwt.models.users.AccountHolder;
import com.ironhack.demosecurityjwt.repositories.accountsrepository.CheckingRepository;
import com.ironhack.demosecurityjwt.repositories.accountsrepository.StudentCheckingRepository;
import com.ironhack.demosecurityjwt.repositories.usersrepository.AccountHolderRepository;
import com.ironhack.demosecurityjwt.services.interfaces.accounts.CheckingServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

@Service
public class CheckingService implements CheckingServiceInterface {
    @Autowired
    CheckingRepository checkingRepository;

    @Autowired
    AccountHolderRepository accountHolderRepository;

    @Autowired
    StudentCheckingRepository studentCheckingRepository;



    public void createChecking(AccountDTO accountDTO, String id) {
        if (accountHolderRepository.findById(Integer.valueOf(id)).isPresent()) {

            LocalDate today = LocalDate.now();

            BigDecimal balance = accountDTO.getBalance();
            String secretKey = accountDTO.getSecretKey();
            AccountHolder primaryOwner = accountHolderRepository.findById(Integer.valueOf(id)).get();
            AccountHolder secondaryOwner = accountDTO.getSecondaryOwner();
            BigDecimal minimumBalance = accountDTO.getMinimumBalance();
            LocalDate creationDate;
            if (accountDTO.getCreationDate() != null) {
                creationDate = accountDTO.getCreationDate();
            } else {
                creationDate = today;}

            if (accountHolderRepository.findById(Integer.valueOf(id)).get().getDateOfBirth().isAfter(today.minusYears(24))) {

                StudentChecking studentChecking = new StudentChecking(balance, primaryOwner, secondaryOwner, creationDate, secretKey);

                studentCheckingRepository.save(studentChecking);

            } else {

                Checking checkingAccount = new Checking(balance, secretKey, primaryOwner, secondaryOwner, creationDate);
                if (minimumBalance != null) {
                    checkingAccount.getBalance();
                }

                checkingRepository.save(checkingAccount);
            }

        } else {

            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    "An AccountHolder with this ID doesn't exits in the database");
        }
    }

}

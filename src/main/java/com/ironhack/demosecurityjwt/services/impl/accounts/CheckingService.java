package com.ironhack.demosecurityjwt.services.impl.accounts;

import com.ironhack.demosecurityjwt.repositories.accountsrepository.CheckingRepository;
import com.ironhack.demosecurityjwt.services.interfaces.accounts.CheckingServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CheckingService implements CheckingServiceInterface {
    @Autowired
    CheckingRepository checkingRepository;
}

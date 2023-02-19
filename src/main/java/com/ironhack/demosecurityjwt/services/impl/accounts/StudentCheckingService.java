package com.ironhack.demosecurityjwt.services.impl.accounts;

import com.ironhack.demosecurityjwt.models.accounts.Checking;
import com.ironhack.demosecurityjwt.models.accounts.StudentChecking;
import com.ironhack.demosecurityjwt.repositories.accountsrepository.StudentCheckingRepository;
import com.ironhack.demosecurityjwt.services.interfaces.accounts.StudentCheckingServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentCheckingService implements StudentCheckingServiceInterface {

    @Autowired
    StudentCheckingRepository studentCheckingRepository;


}

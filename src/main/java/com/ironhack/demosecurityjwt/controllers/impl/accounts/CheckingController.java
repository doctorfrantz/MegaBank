package com.ironhack.demosecurityjwt.controllers.impl.accounts;

import com.ironhack.demosecurityjwt.models.accounts.Checking;
import com.ironhack.demosecurityjwt.models.accounts.StudentChecking;
import com.ironhack.demosecurityjwt.models.users.AccountHolder;
import com.ironhack.demosecurityjwt.services.impl.accounts.CheckingService;
import com.ironhack.demosecurityjwt.services.impl.accounts.StudentCheckingService;
import com.ironhack.demosecurityjwt.services.impl.users.AccountHolderService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CheckingController {
    @Autowired
    CheckingService checkingService;

    @Autowired
    AccountHolderService accountHolderService;

    @Autowired
    StudentCheckingService studentCheckingService;


}

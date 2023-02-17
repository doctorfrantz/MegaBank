package com.ironhack.demosecurityjwt.controllers.impl.accounts;

import com.ironhack.demosecurityjwt.services.impl.accounts.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {
    @Autowired
    AccountService accountService;
}

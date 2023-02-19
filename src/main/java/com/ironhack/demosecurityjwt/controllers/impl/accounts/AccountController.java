package com.ironhack.demosecurityjwt.controllers.impl.accounts;

import com.ironhack.demosecurityjwt.models.DTO.AccountDTO;
import com.ironhack.demosecurityjwt.models.DTO.TransferDto;
import com.ironhack.demosecurityjwt.models.accounts.Account;
import com.ironhack.demosecurityjwt.services.impl.accounts.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AccountController {
    @Autowired
    AccountService accountService;

    //Get cuentas por id de usuario
    @GetMapping("/accountsByUserId/{Id}")
    @ResponseStatus(HttpStatus.OK)
    public List<Account> getAllAccountsByUserId(@PathVariable(value = "Id") Integer userId) {
        return accountService.getAllAccountsById(userId);
    }


    //hacer transferencias
    @PatchMapping("/account/transfer/{accountId}")
    @ResponseStatus(HttpStatus.OK)
    public boolean transferMoney(@PathVariable(value = "accountId") Integer accountId, @RequestBody TransferDto request) {
        return accountService.transferMoney(request.getSenderAccountId(), request.getReceiverName(), request.getReceiverAccountId(), request.getAmount());
    }
    /* Body de la transferencia:
    {
    "senderAccountId": 1,
    "receiverName": "George",
    "receiverAccountId": 2,
    "amount": 30.00
    }*/

    //crear cuentas
    @PostMapping("/create/{accountType}/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public void createAccount(@PathVariable String accountType, @PathVariable String id, @RequestBody AccountDTO accountDTO) {

        accountService.createAccount(accountType, id, accountDTO);

    }
}

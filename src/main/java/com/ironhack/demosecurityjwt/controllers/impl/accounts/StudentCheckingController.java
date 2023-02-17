package com.ironhack.demosecurityjwt.controllers.impl.accounts;

import com.ironhack.demosecurityjwt.services.impl.accounts.StudentCheckingService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentCheckingController {
    StudentCheckingService studentCheckingService;
}

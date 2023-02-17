package com.ironhack.demosecurityjwt.controllers.impl.users;

import com.ironhack.demosecurityjwt.services.impl.users.ThirdPartyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ThirdPartyController {
    @Autowired
    ThirdPartyService thirdPartyService;
}

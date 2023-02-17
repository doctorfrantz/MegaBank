package com.ironhack.demosecurityjwt.services.impl.users;

import com.ironhack.demosecurityjwt.repositories.usersrepository.ThirdPartyRepository;
import com.ironhack.demosecurityjwt.services.interfaces.users.ThirdPartyServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ThirdPartyService implements ThirdPartyServiceInterface {

    @Autowired
    ThirdPartyRepository thirdPartyRepository;
}

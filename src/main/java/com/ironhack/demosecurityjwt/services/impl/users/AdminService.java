package com.ironhack.demosecurityjwt.services.impl.users;

import com.ironhack.demosecurityjwt.repositories.usersrepository.AdminRepository;
import com.ironhack.demosecurityjwt.services.interfaces.users.AdminServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService implements AdminServiceInterface {

    @Autowired
    AdminRepository adminRepository;
}

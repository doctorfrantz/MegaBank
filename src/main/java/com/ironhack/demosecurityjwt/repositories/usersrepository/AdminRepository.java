package com.ironhack.demosecurityjwt.repositories.usersrepository;

import com.ironhack.demosecurityjwt.models.users.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer> {

}

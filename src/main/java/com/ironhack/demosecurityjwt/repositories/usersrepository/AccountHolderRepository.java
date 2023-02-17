package com.ironhack.demosecurityjwt.repositories.usersrepository;

import com.ironhack.demosecurityjwt.models.users.AccountHolder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountHolderRepository extends JpaRepository<AccountHolder, Integer> {
}

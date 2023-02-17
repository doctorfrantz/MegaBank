package com.ironhack.demosecurityjwt.repositories.accountsrepository;

import com.ironhack.demosecurityjwt.models.accounts.Checking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CheckingRepository extends JpaRepository<Checking, Integer> {
}

package com.ironhack.demosecurityjwt.repositories.accountsrepository;

import com.ironhack.demosecurityjwt.models.accounts.Savings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SavingsRepository extends JpaRepository<Savings, Integer> {
}

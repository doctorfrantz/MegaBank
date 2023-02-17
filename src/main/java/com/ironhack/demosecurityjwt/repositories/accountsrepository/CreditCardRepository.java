package com.ironhack.demosecurityjwt.repositories.accountsrepository;

import com.ironhack.demosecurityjwt.models.accounts.CreditCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreditCardRepository extends JpaRepository<CreditCard, Integer> {
}

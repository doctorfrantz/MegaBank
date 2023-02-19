package com.ironhack.demosecurityjwt.repositories.accountsrepository;

import com.ironhack.demosecurityjwt.models.accounts.Account;
import jakarta.validation.Valid;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {
    List<Account> findAllByPrimaryOwner_Id(Integer userId);

    Optional<Account> findByAccountIdAndPrimaryOwnerName(@Valid Integer accountId, String primaryOwner_name);
    Optional<Account> findByAccountId(Integer accountId);
}


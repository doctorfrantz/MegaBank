package com.ironhack.demosecurityjwt.repositories.usersrepository;

import com.ironhack.demosecurityjwt.models.users.ThirdParty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ThirdPartyRepository extends JpaRepository<ThirdParty, Integer> {
}

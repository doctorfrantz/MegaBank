package com.ironhack.demosecurityjwt.repositories.accountsrepository;

import com.ironhack.demosecurityjwt.models.accounts.StudentChecking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentCheckingRepository extends JpaRepository<StudentChecking, Integer> {
}

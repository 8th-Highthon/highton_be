package com.example.highton.domain.account.repository;

import com.example.highton.domain.account.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
    Account findByUserId(String userId);
}

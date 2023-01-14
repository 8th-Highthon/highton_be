package com.example.highton.domain.bank.repository;

import com.example.highton.domain.account.Account;
import com.example.highton.domain.bank.PiggyBank;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface PiggyBankRepository extends CrudRepository<PiggyBank, Long> {
    Boolean existsByAccount(Account account);
    Optional<PiggyBank> findByAccount(Account account);
}

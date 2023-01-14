package com.example.highton.domain.account.service;

import com.example.highton.domain.account.Account;
import com.example.highton.domain.account.exception.AccountNotFoundException;
import com.example.highton.domain.account.presentation.dto.request.SignInRequest;
import com.example.highton.domain.account.presentation.dto.response.SignInResponse;
import com.example.highton.domain.account.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountService {
    private final AccountRepository accountRepository;

    public SignInResponse signIn(SignInRequest signInRequest) {
        Account user = accountRepository.findByUserId(signInRequest.getUserId());
        if(user == null) {
            throw new AccountNotFoundException();
        }
        return new SignInResponse(user.getUserId());
    }
}

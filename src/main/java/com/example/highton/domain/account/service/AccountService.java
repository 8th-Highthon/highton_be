package com.example.highton.domain.account.service;

import com.example.highton.domain.account.Account;
import com.example.highton.domain.account.exception.AccountNotFoundException;
import com.example.highton.domain.account.exception.PasswordNotMatchedException;
import com.example.highton.domain.account.presentation.dto.request.SignInRequest;
import com.example.highton.domain.account.presentation.dto.response.SignInResponse;
import com.example.highton.domain.account.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountService {
    private final AccountRepository accountRepository;
    private final PasswordEncoder passwordEncoder;

    public SignInResponse signIn(SignInRequest signInRequest) {
        System.out.println(passwordEncoder.encode(signInRequest.getPassword()));
        Account user = accountRepository.findByUserId(signInRequest.getUserId())
                .orElseThrow(() -> new AccountNotFoundException());
        if(!passwordEncoder.matches(signInRequest.getPassword(), user.getPassword())) {
            throw new PasswordNotMatchedException();
        }
        return new SignInResponse(user.getUserId());
    }
}

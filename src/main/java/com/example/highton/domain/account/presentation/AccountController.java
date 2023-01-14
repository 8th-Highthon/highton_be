package com.example.highton.domain.account.presentation;

import com.example.highton.domain.account.presentation.dto.request.SignInRequest;
import com.example.highton.domain.account.presentation.dto.response.SignInResponse;
import com.example.highton.domain.account.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account")
@RequiredArgsConstructor
public class AccountController {
    private final AccountService accountService;

    @PostMapping("/signin")
    public SignInResponse login(@RequestBody SignInRequest signInRequest) {
        return accountService.signIn(signInRequest);
    }
}

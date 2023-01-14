package com.example.highton.domain.account.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "계정을 찾을 수 없습니다.")
public class AccountNotFoundException extends RuntimeException{
}

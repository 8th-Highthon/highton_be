package com.example.highton.domain.account;

import com.example.highton.domain.bank.BankAccount;
import com.example.highton.domain.bank.PiggyBank;
import com.example.highton.global.base.entity.BaseTimeEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Account extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 60, nullable = false)
    private String userId;

    @Column(length = 30, nullable = false)
    private String password;

    @Column(length = 60, nullable = false)
    private String nickname;

    private String profileImagePath;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "account")
    private BankAccount bankAccount;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "account")
    private List<PiggyBank> piggyBank = new ArrayList<>();
}

package com.example.highton.domain.bank;

import com.example.highton.domain.account.Account;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@Getter
public class PiggyBank {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long point;

    private LocalDateTime startDate;

    private LocalDateTime endDate;

    @OneToOne
    @JoinColumn(name = "account_id")
    private Account account;

    public PiggyBank(Long point, LocalDateTime startDate, LocalDateTime endDate) {
        this.point = point;
        this.startDate = startDate;
        this.endDate = endDate;
    }
}

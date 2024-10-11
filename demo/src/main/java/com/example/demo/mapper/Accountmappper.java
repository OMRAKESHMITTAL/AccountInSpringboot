package com.example.demo.mapper;

import com.example.demo.dto.Accountdto;
import com.example.demo.entity.Account;

public class Accountmappper {

    public static Account mapToAccount(Accountdto accountdto) {
        Account account = new Account(
                accountdto.getId(),
                accountdto.getName(),
                accountdto.getBalance()
        );
        return account;
    }

    public static Accountdto mapToAccountdto(Account account) {
        Accountdto accountdto = new Accountdto(
                account.getId(),
                account.getName(),
                account.getBalance()
        );
                return accountdto;
    }
}

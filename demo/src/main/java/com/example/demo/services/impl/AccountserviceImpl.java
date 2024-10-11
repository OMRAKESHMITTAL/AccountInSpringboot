package com.example.demo.services.impl;

import com.example.demo.dto.Accountdto;
import com.example.demo.entity.Account;
import com.example.demo.mapper.Accountmappper;
import com.example.demo.repositary.AccountRepositary;
import com.example.demo.services.Accountservices;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountserviceImpl implements Accountservices {

    private AccountRepositary accountRepositary;

    public AccountserviceImpl(AccountRepositary accountRepositary) {
        this.accountRepositary = accountRepositary;
    }

    public Accountdto createaccount(Accountdto accountdto){
        Account account = Accountmappper.mapToAccount(accountdto);
        Account savedAccount =  accountRepositary.save(account);
        return Accountmappper.mapToAccountdto(savedAccount);
    }

    public Accountdto getaccountbyid(Long id){
        Account account = accountRepositary.findById(id).orElseThrow(() -> new RuntimeException("Account does not exits"));
        return Accountmappper.mapToAccountdto(account);
    }

    public Accountdto deposit(Long id , double amount){
        Account account = accountRepositary.findById(id).orElseThrow(() -> new RuntimeException("Account does not exits"));
        account.setBalance(account.getBalance()+amount);
        Account savedaccount =accountRepositary.save(account);
        return Accountmappper.mapToAccountdto(savedaccount);
    }

    public Accountdto withdraw(Long id , double amount){
        Account account  = accountRepositary.findById(id).orElseThrow(() -> new RuntimeException("Account does not exits"));
        if(account.getBalance()-amount<0){
            throw new RuntimeException("Account does not have enough money");
        }
        account.setBalance(account.getBalance()-amount);
        Account savedaccount =accountRepositary.save(account);
        return Accountmappper.mapToAccountdto(savedaccount);

    }

    public List<Accountdto> getaccounts(){
        List<Account> accounts = accountRepositary.findAll();
        return accounts.stream().map((account)-> Accountmappper.mapToAccountdto(account)).collect(Collectors.toList());


    }

}

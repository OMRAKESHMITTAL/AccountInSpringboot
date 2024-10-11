package com.example.demo.services;

import com.example.demo.dto.Accountdto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface Accountservices {
    public Accountdto createaccount(Accountdto accountdto);
    public Accountdto getaccountbyid(Long id);
    public Accountdto deposit(Long id , double amount);
    public Accountdto withdraw(Long id , double amount);
    public List<Accountdto> getaccounts();
}

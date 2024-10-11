package com.example.demo.controller;

import com.example.demo.dto.Accountdto;
import com.example.demo.services.Accountservices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/account")
public class AccountController {
    private Accountservices accountservices;

    public AccountController(Accountservices accountservices) {
        this.accountservices = accountservices;
    }
    @PostMapping
    public ResponseEntity<Accountdto>addAccount(@RequestBody Accountdto dto) {
        return new ResponseEntity<>(accountservices.createaccount(dto), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Accountdto>getAccount(@PathVariable Long id) {
        Accountdto dto = accountservices.getaccountbyid(id);
        return ResponseEntity.ok(dto);
    }
    @PutMapping("/{id}/deposit")
    public ResponseEntity<Accountdto> deposit(@PathVariable Long id, @RequestBody Map<String, Double> request) {
        Accountdto dto = accountservices.deposit(id,request.get("amount"));
        return ResponseEntity.ok(dto);
    }
    @PutMapping("/{id}/withdraw")
    public ResponseEntity<Accountdto> withdraw(@PathVariable Long id, @RequestBody Map<String, Double> request) {
        Accountdto dto = accountservices.withdraw(id,request.get("amount"));
        return ResponseEntity.ok(dto);
    }
    @GetMapping
    public ResponseEntity <List<Accountdto>> getAllAccounts() {
        List<Accountdto> accounts = accountservices.getaccounts();
        return ResponseEntity.ok(accounts);

    }

}

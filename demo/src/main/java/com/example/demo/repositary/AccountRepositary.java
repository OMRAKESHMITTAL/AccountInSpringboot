package com.example.demo.repositary;

import com.example.demo.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepositary extends JpaRepository<Account, Long> {

}

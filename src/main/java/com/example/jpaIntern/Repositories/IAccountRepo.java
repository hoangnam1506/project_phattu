package com.example.jpaIntern.Repositories;

import com.example.jpaIntern.Models.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAccountRepo extends JpaRepository<Account, Integer> {
}

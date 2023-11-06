package com.example.jpaIntern.Repositories;

import com.example.jpaIntern.Models.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface    IPaymentRepo extends JpaRepository<Payment, Integer> {
}

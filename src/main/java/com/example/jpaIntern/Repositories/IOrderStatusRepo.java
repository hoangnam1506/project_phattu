package com.example.jpaIntern.Repositories;

import com.example.jpaIntern.Models.Order_Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IOrderStatusRepo extends JpaRepository<Order_Status, Integer> {
}

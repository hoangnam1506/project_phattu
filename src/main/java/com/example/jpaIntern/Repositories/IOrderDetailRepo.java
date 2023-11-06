package com.example.jpaIntern.Repositories;

import com.example.jpaIntern.Models.Order_Detail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IOrderDetailRepo extends JpaRepository<Order_Detail, Integer> {
}

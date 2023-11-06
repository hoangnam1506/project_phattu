package com.example.jpaIntern.Repositories;

import com.example.jpaIntern.Models.Carts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICartsRepo extends JpaRepository<Carts, Integer> {
}

package com.example.jpaIntern.Repositories;

import com.example.jpaIntern.Models.Product_Types;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductTypesRepo extends JpaRepository<Product_Types, Integer> {
}

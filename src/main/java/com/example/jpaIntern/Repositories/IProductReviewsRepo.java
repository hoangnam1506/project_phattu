package com.example.jpaIntern.Repositories;

import com.example.jpaIntern.Models.Product_Reviews;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductReviewsRepo extends JpaRepository<Product_Reviews, Integer> {
}

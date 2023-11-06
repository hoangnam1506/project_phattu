package com.example.jpaIntern.Repositories;

import com.example.jpaIntern.Models.Product_Images;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductImagesRepo extends JpaRepository<Product_Images, Integer> {
}

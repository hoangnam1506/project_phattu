package com.example.jpaIntern.Repositories;

import com.example.jpaIntern.Models.Carts_Items;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICartsItemsRepo extends JpaRepository<Carts_Items, Integer>{

}

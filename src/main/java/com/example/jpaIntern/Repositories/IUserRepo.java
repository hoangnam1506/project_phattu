package com.example.jpaIntern.Repositories;

import com.example.jpaIntern.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IUserRepo extends JpaRepository<User, Integer> {
    Optional<User> findByUserName(String userName);
    Boolean existsByUserName(String userName);

    Boolean existsByEmail(String email);
}

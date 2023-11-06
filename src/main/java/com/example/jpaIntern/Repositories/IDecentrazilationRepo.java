package com.example.jpaIntern.Repositories;

import com.example.jpaIntern.Models.Decentrazilation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDecentrazilationRepo extends JpaRepository<Decentrazilation, Integer> {
}

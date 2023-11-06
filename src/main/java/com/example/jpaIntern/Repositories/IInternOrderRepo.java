package com.example.jpaIntern.Repositories;

import com.example.jpaIntern.Models.InternOrder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IInternOrderRepo extends JpaRepository<InternOrder, Integer> {
    Page<InternOrder> findAllByFullName(String fullName, PageRequest pageRequest);

}

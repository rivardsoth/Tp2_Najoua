package com.example.tp2_najoua.repository;

import com.example.tp2_najoua.entity.ClientOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientOrderRepository extends JpaRepository<ClientOrder, Integer> {
}

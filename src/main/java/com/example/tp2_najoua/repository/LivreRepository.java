package com.example.tp2_najoua.repository;

import com.example.tp2_najoua.entity.Livre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LivreRepository extends JpaRepository<Livre, String> {
}

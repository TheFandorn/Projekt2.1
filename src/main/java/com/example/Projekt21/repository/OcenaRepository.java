package com.example.Projekt21.repository;

import com.example.Projekt21.entity.Ocena;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OcenaRepository extends JpaRepository<Ocena, Long> {
}

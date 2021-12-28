package com.example.Projekt21.repository;

import com.example.Projekt21.entity.Krytyk;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KrytykRepository extends JpaRepository<Krytyk, Long> {
}

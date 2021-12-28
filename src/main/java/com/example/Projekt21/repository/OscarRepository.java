package com.example.Projekt21.repository;

import com.example.Projekt21.entity.Oscar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OscarRepository extends JpaRepository<Oscar, Long> {
}

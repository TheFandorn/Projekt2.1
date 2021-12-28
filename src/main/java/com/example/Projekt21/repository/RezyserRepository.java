package com.example.Projekt21.repository;

import com.example.Projekt21.entity.Rezyser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RezyserRepository extends JpaRepository<Rezyser, Long> {
}

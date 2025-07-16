package com.example.fashion.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.fashion.model.Gens;

public interface GensRepository extends JpaRepository<Gens, Long> {
}

package com.example.fashion.repository;

import com.example.fashion.model.Kids;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KidsRepository extends JpaRepository<Kids, Long> {
}

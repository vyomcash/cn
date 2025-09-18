package com.vit.result_system.repository;

import com.vit.result_system.model.Result;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ResultRepository extends JpaRepository<Result, Integer> {
    
    // Custom method to find a result by registration number
    Optional<Result> findByRegNo(String regNo);
}
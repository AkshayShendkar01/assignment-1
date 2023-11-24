package com.bnt.repository;

import com.bnt.entity.CalculatorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CalculatorRepository extends JpaRepository<CalculatorEntity, Integer> {
}

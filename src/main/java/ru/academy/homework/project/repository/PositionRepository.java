package ru.academy.homework.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ru.academy.homework.project.entity.PositionEnt;

import java.math.BigDecimal;
import java.util.List;


public interface PositionRepository extends JpaRepository<PositionEnt, Long> {
    List<PositionEnt> findByMinSalaryBetween(BigDecimal min, BigDecimal max);
}
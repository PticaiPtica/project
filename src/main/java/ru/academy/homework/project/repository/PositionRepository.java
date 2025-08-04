package ru.academy.homework.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ru.academy.homework.project.entity.PositionEnt;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface PositionRepository extends JpaRepository<PositionEnt, Long> {
    Optional<PositionEnt> findByPositionName(String name);

    List<PositionEnt> findByMinSalaryGreaterThanEqual(BigDecimal minSalary);
}
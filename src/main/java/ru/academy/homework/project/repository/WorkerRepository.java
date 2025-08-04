package ru.academy.homework.project.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.academy.homework.project.entity.WorkerEnt;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;

@Repository
public interface WorkerRepository extends JpaRepository<WorkerEnt, Long> {
    List<WorkerEnt> findByPositionId(Long positionId);

    List<WorkerEnt> findBySalaryBetween(BigDecimal min, BigDecimal max);

    boolean existsByEmail(String email);
}
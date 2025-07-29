package ru.academy.homework.proect.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.academy.homework.proect.entities.PositionEnt;

@Repository
public interface PositionRepository extends JpaRepository<PositionEnt, Integer> {
}

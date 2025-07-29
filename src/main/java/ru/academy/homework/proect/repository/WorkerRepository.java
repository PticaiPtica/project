package ru.academy.homework.proect.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.academy.homework.proect.entities.WorkerEnt;

@Repository
public interface WorkerRepository extends JpaRepository<WorkerEnt, Integer> {
}

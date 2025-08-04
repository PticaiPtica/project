package ru.academy.homework.project.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.academy.homework.project.entity.WorkerEnt;

@Repository
public interface WorkerRepository extends JpaRepository<WorkerEnt, Integer> {
}

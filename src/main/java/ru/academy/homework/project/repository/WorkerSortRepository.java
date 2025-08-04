package ru.academy.homework.project.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import ru.academy.homework.project.entity.WorkerEnt;


@Repository
public interface WorkerSortRepository extends PagingAndSortingRepository<WorkerEnt, Long> {


}

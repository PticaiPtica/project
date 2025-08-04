package ru.academy.homework.proect.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import ru.academy.homework.proect.entities.WorkerEnt;

import java.util.Optional;


@Repository
public interface WorkerSortRepository extends PagingAndSortingRepository<WorkerEnt, Long> {


}

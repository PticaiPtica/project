package ru.academy.homework.project.services;


import ru.academy.homework.project.modelsDto.WorkerDTO;

import java.util.List;

public interface WorkerService {
    WorkerDTO createWorker(WorkerDTO workerDTO);
    WorkerDTO getWorkerById(Long id);
    List<WorkerDTO> getAllWorkers();
    List<WorkerDTO> getWorkersByPositionId(Long positionId);
    WorkerDTO updateWorker(Long id, WorkerDTO workerDTO);
    void deleteWorker(Long id);
}
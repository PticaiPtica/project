package ru.academy.homework.project.services;

import org.springframework.stereotype.Service;
import ru.academy.homework.project.entity.PositionEnt;
import ru.academy.homework.project.entity.WorkerEnt;
import ru.academy.homework.project.mapstruct.WorkerMapper;
import ru.academy.homework.project.modelsDto.WorkerDTO;
import ru.academy.homework.project.repository.PositionRepository;
import ru.academy.homework.project.repository.WorkerRepository;


import java.util.List;
import java.util.stream.Collectors;

@Service
public class WorkerServiceImpl implements WorkerService {

    private final WorkerRepository workerRepository;
    private final PositionRepository positionRepository;
    private final WorkerMapper workerMapper;

    public WorkerServiceImpl(WorkerRepository workerRepository,
                             PositionRepository positionRepository,
                             WorkerMapper workerMapper) {
        this.workerRepository = workerRepository;
        this.positionRepository = positionRepository;
        this.workerMapper = workerMapper;
    }

    @Override
    public WorkerDTO createWorker(WorkerDTO workerDTO) {
        WorkerEnt worker = workerMapper.toEntity(workerDTO);
        PositionEnt position = positionRepository.findById(workerDTO.getPositionId())
                .orElseThrow(() -> new RuntimeException("Position not found"));
        worker.setPosition(position);
        WorkerEnt savedWorker = workerRepository.save(worker);
        return workerMapper.toDto(savedWorker);
    }

    @Override
    public List<WorkerDTO> getWorkersByPositionId(Long positionId) {
        return workerRepository.findByPositionId(positionId).stream()
                .map(workerMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public WorkerDTO getWorkerById(Long id) {
        WorkerEnt worker = workerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Worker not found"));
        return workerMapper.toDto(worker);
    }

    @Override
    public List<WorkerDTO> getAllWorkers() {
        return workerRepository.findAll().stream()
                .map(workerMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public WorkerDTO updateWorker(Long id, WorkerDTO workerDTO) {
        WorkerEnt existingWorker = workerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Worker not found"));
        workerMapper.updateWorkerFromDto(workerDTO, existingWorker);

        if (!existingWorker.getPosition().getId().equals(workerDTO.getPositionId())) {
            PositionEnt newPosition = positionRepository.findById(workerDTO.getPositionId())
                    .orElseThrow(() -> new RuntimeException("Position not found"));
            existingWorker.setPosition(newPosition);
        }

        WorkerEnt updatedWorker = workerRepository.save(existingWorker);
        return workerMapper.toDto(updatedWorker);
    }

    @Override
    public void deleteWorker(Long id) {
        workerRepository.deleteById(id);
    }
}
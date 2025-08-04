package ru.academy.homework.project.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.academy.homework.project.entity.PositionEnt;
import ru.academy.homework.project.exception.NotFoundException;
import ru.academy.homework.project.mapstruct.WorkerMapper;
import ru.academy.homework.project.model.WorkerEnt;
import ru.academy.homework.project.modelsDto.WorkerDTO;
import ru.academy.homework.project.repository.PositionRepository;
import ru.academy.homework.project.repository.WorkerRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
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
    @Transactional
    public WorkerDTO createWorker(WorkerDTO workerDTO) {
        WorkerEnt worker = workerMapper.toEntity(workerDTO);
        PositionEnt position = positionRepository.findById(workerDTO.getPositionId())
                .orElseThrow(() -> new NotFoundException("Position with id " + workerDTO.getPositionId() + " not found"));

        worker.setPosition(position);
        WorkerEnt savedWorker = workerRepository.save(worker);
        return workerMapper.toDto(savedWorker);
    }

    @Override
    @Transactional(readOnly = true)
    public List<WorkerDTO> getWorkersByPositionId(Long positionId) {
        if (!positionRepository.existsById(positionId)) {
            throw new NotFoundException("Position with id " + positionId + " not found");
        }

        return workerRepository.findByPositionId(positionId).stream()
                .map(workerMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public WorkerDTO getWorkerById(Long id) {
        WorkerEnt worker = workerRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Worker with id " + id + " not found"));
        return workerMapper.toDto(worker);
    }

    @Override
    @Transactional(readOnly = true)
    public List<WorkerDTO> getAllWorkers() {
        return workerRepository.findAll().stream()
                .map(workerMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public WorkerDTO updateWorker(Long id, WorkerDTO workerDTO) {
        WorkerEnt existingWorker = workerRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Worker with id " + id + " not found"));

        workerMapper.updateWorkerFromDto(workerDTO, existingWorker);

        if (workerDTO.getPositionId() != null &&
                !existingWorker.getPosition().getId().equals(workerDTO.getPositionId())) {
            PositionEnt newPosition = positionRepository.findById(workerDTO.getPositionId())
                    .orElseThrow(() -> new NotFoundException("Position with id " + workerDTO.getPositionId() + " not found"));
            existingWorker.setPosition(newPosition);
        }

        WorkerEnt updatedWorker = workerRepository.save(existingWorker);
        return workerMapper.toDto(updatedWorker);
    }

    @Override
    @Transactional
    public void deleteWorker(Long id) {
        if (!workerRepository.existsById(id)) {
            throw new NotFoundException("Worker with id " + id + " not found");
        }
        workerRepository.deleteById(id);
    }
}
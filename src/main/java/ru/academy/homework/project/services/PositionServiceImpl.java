package ru.academy.homework.project.services;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.academy.homework.project.entity.PositionEnt;
import ru.academy.homework.project.exception.NotFoundException;
import ru.academy.homework.project.mapstruct.PositionMapper;
import ru.academy.homework.project.modelsDto.PositionDTO;
import ru.academy.homework.project.repository.PositionRepository;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class PositionServiceImpl implements PositionService {

    private final PositionRepository repository;
    private final PositionMapper mapper;

    @Override
    @Transactional
    public PositionDTO create(PositionDTO dto) {
        PositionEnt entity = mapper.toEntity(dto);
        PositionEnt savedEntity = repository.save(entity);
        return mapper.toDto(savedEntity);
    }

    @Override
    @Transactional(readOnly = true)
    public PositionDTO getById(Long id) {
        return mapper.toDto(repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Position with id " + id + " not found")));
    }

    @Override
    @Transactional(readOnly = true)
    public List<PositionDTO> getAll() {
        return repository.findAll().stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public PositionDTO update(Long id, PositionDTO dto) {
        PositionEnt existingEntity = repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Position with id " + id + " not found"));

        mapper.updatePositionFromDto(dto, existingEntity);
        PositionEnt updatedEntity = repository.save(existingEntity);
        return mapper.toDto(updatedEntity);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new NotFoundException("Position with id " + id + " not found");
        }
        repository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<PositionDTO> findBySalaryRange(BigDecimal min, BigDecimal max) {
        if (min.compareTo(max) > 0) {
            throw new IllegalArgumentException("Min salary cannot be greater than max salary");
        }

        return repository.findByMinSalaryBetween(min, max).stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }
}
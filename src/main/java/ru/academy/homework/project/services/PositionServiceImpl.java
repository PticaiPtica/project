package ru.academy.homework.project.services;


import jakarta.persistence.EntityNotFoundException;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.academy.homework.project.entity.PositionEnt;
import ru.academy.homework.project.mapstruct.PositionMapper;
import ru.academy.homework.project.modelsDto.PositionDTO;

import ru.academy.homework.project.repository.PositionRepository;


import java.math.BigDecimal;
import java.util.List;



@Service
@RequiredArgsConstructor
public class PositionServiceImpl implements PositionService {
    private final PositionRepository repository;
    private final PositionMapper mapper;

    @Override
    @Transactional
    public PositionDTO create(PositionDTO dto) {
        PositionEnt entity = mapper.toEntity(dto);
        return mapper.toDto(repository.save(entity));
    }

    @Override
    @Transactional(readOnly = true)
    public PositionDTO getById(Long id) {
        return mapper.toDto(repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Position not found")));
    }

    @Override
    public List<PositionDTO> getAll() {
        return List.of();
    }

    @Override
    @Transactional
    public PositionDTO update(Long id, PositionDTO dto) {
        PositionEnt entity = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Position not found"));
        mapper.updatePositionFromDto(dto, entity);
        return mapper.toDto(repository.save(entity));
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<PositionDTO> findBySalaryRange(BigDecimal min, BigDecimal max) {
        return List.of();
    }
}
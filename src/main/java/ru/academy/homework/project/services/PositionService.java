package ru.academy.homework.project.services;


import ru.academy.homework.project.modelsDto.PositionDTO;

import java.math.BigDecimal;
import java.util.List;

public interface PositionService {
    PositionDTO create(PositionDTO dto);
    PositionDTO getById(Long id);
    List<PositionDTO> getAll();
    PositionDTO update(Long id, PositionDTO dto);
    void delete(Long id);
    List<PositionDTO> findBySalaryRange(BigDecimal min, BigDecimal max);
}

package ru.academy.homework.project.services;



import ru.academy.homework.project.entity.PositionEnt;
import ru.academy.homework.project.modelsDto.PositionDto;

import java.util.List;
import java.util.Optional;

public interface PositionService {

    Optional<Boolean> save(PositionEnt positionDto);

    Optional<PositionDto> update(PositionDto positionDto);

    Optional<PositionDto> delete(PositionDto positionDto);

    Optional<PositionDto> findById(Long id);

    List<PositionDto> findAll();

    Boolean deleteById(Long id);


}

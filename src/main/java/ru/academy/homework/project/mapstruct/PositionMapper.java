package ru.academy.homework.project.mapstruct;


import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import ru.academy.homework.project.entity.PositionEnt;
import ru.academy.homework.project.modelsDto.PositionDTO;


@Mapper(componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface PositionMapper {
    PositionEnt toEntity(PositionDTO dto);
    PositionDTO toDto(PositionEnt entity);
    void updatePositionFromDto(PositionDTO dto, @MappingTarget PositionEnt entity);
}
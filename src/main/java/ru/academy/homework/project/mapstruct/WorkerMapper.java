package ru.academy.homework.project.mapstruct;

import org.mapstruct.*;

import ru.academy.homework.project.entity.WorkerEnt;
import ru.academy.homework.project.modelsDto.WorkerDTO;


@Mapper(componentModel = "spring")
public interface WorkerMapper {

    @Mapping(target = "position", ignore = true)
    WorkerEnt toEntity(WorkerDTO dto);

    @Mapping(target = "positionId", source = "position.id")
    @Mapping(target = "positionName", source = "position.positionName")
    WorkerDTO toDto(WorkerEnt entity);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateWorkerFromDto(WorkerDTO dto, @MappingTarget WorkerEnt entity);
}
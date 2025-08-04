package ru.academy.homework.project.mapstruct;

import org.mapstruct.*;

import ru.academy.homework.project.entity.WorkerEnt;


import ru.academy.homework.project.modelsDto.WorkerDTO;

@Mapper(componentModel = "spring")
public interface WorkerMapper {

    @Mapping(target = "position", ignore = true)
    WorkerEnt toEntity(WorkerDTO workerDTO);

    @Mapping(target = "positionId", source = "position.id")
    @Mapping(target = "positionName", source = "position.positionName")
    WorkerDTO toDto(WorkerEnt workerEnt);

    @AfterMapping
    default void setPositionDetails(WorkerEnt source, @MappingTarget WorkerDTO target) {
        if (source.getPosition() != null) {
            target.setPositionId(source.getPosition().getId());
            target.setPositionName(source.getPosition().getPositionName());
        }
    }
}
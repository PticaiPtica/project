package ru.academy.homework.project.mapstruct;

import org.mapstruct.*;

import ru.academy.homework.project.model.Worker;
import ru.academy.homework.project.model.WorkerEnt;
import ru.academy.homework.project.modelsDto.WorkerDTO;

@Mapper(componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface WorkerMapper {

    @Mapping(target = "position", ignore = true)
    WorkerEnt toEntity(WorkerDTO workerDTO);

    @Mapping(target = "positionId", source = "position.id")
    @Mapping(target = "positionName", source = "position.positionName")
    WorkerDTO toDto(WorkerEnt workerEnt);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    default void updateWorkerFromDto(WorkerDTO workerDTO, @MappingTarget WorkerEnt workerEnt) {
        if (workerDTO.getName() != null) {
            workerEnt.setName(workerDTO.getName());
        }
        if (workerDTO.getSurname() != null) {
            workerEnt.setSurname(workerDTO.getSurname());
        }
        if (workerDTO.getPatronymic() != null) {
            workerEnt.setPatronymic(workerDTO.getPatronymic());
        }
        if (workerDTO.getBirthDate() != null) {
            workerEnt.setBirthDate(workerDTO.getBirthDate());
        }
        if (workerDTO.getPhone() != null) {
            workerEnt.setPhone(workerDTO.getPhone());
        }
        if (workerDTO.getEmail() != null) {
            workerEnt.setEmail(workerDTO.getEmail());
        }
        if (workerDTO.getEmploymentDate() != null) {
            workerEnt.setEmploymentDate(workerDTO.getEmploymentDate());
        }
        if (workerDTO.getSalary() != null) {
            workerEnt.setSalary(workerDTO.getSalary());
        }
    }

    @AfterMapping
    default void setAdditionalFields(WorkerEnt workerEnt, @MappingTarget WorkerDTO workerDTO) {
        if (workerEnt.getPosition() != null) {
            workerDTO.setPositionId(workerEnt.getPosition().getId());
            workerDTO.setPositionName(workerEnt.getPosition().getPositionName());
        }
        if (workerEnt.getCreatedAt() != null) {
            workerDTO.setCreatedAt(workerEnt.getCreatedAt());
        }
    }
}
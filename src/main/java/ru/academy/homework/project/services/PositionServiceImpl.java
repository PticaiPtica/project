package ru.academy.homework.project.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.academy.homework.project.entity.PositionEnt;
import ru.academy.homework.project.modelsDto.PositionDto;
import ru.academy.homework.project.repository.PositionRepository;


import java.util.List;
import java.util.Optional;

@Service
public class PositionServiceImpl implements PositionService {

    @Autowired
    private final PositionRepository positionRepository;

    public PositionServiceImpl(PositionRepository positionRepository) {
        this.positionRepository = positionRepository;
    }


    @Override
    public Optional<Boolean> save(PositionEnt positionDto) {


        return Optional.of(true);
    }

    @Override
    public Optional<PositionDto> update(PositionDto positionDto) {
        return Optional.empty();
    }

    @Override
    public Optional<PositionDto> delete(PositionDto positionDto) {
        return Optional.empty();
    }

    @Override
    public Optional<PositionDto> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public List<PositionDto> findAll() {
        return List.of((PositionDto) positionRepository.findAll());
    }

    @Override
    public Boolean deleteById(Long id) {
        return null;
    }
}

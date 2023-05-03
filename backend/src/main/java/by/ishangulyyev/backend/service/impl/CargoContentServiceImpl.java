package by.ishangulyyev.backend.service.impl;

import by.ishangulyyev.backend.entity.CargoContent;
import by.ishangulyyev.backend.exception.EntityNotFoundException;
import by.ishangulyyev.backend.model.CargoContentDTO;
import by.ishangulyyev.backend.repository.CargoContentRepository;
import by.ishangulyyev.backend.service.CargoContentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CargoContentServiceImpl implements CargoContentService {
    private final CargoContentRepository repository;
    private final ModelMapper mapper;
    @Override
    public CargoContent save(@Valid CargoContentDTO cargoContent) {
        cargoContent.setId(null);
        return repository.save(mapper.map(cargoContent, CargoContent.class));
    }

    @Override
    public CargoContent update(@Valid CargoContentDTO cargoContent, String id) {
        CargoContent entity = repository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
        entity.setHeight(cargoContent.getHeight());
        entity.setWidth(cargoContent.getWidth());
        entity.setLength(cargoContent.getLength());
        entity.setWeight(cargoContent.getWeight());
        return repository.save(entity);
    }
}

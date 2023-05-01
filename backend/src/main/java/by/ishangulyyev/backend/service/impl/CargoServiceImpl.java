package by.ishangulyyev.backend.service.impl;

import by.ishangulyyev.backend.model.CargoDTO;
import by.ishangulyyev.backend.model.CargoPage;
import by.ishangulyyev.backend.repository.CargoRepository;
import by.ishangulyyev.backend.service.CargoService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CargoServiceImpl implements CargoService {
    private final CargoRepository repository;
    private final ModelMapper mapper;
    @Override
    public Page<CargoPage> findAll(Pageable pageable) {
        return repository.findAll(pageable)
                .map(cargo -> mapper.map(cargo, CargoPage.class));
    }

    @Override
    @Transactional
    public CargoDTO save(CargoDTO cargo) {
        return null;
    }

    @Override
    @Transactional
    public CargoDTO findBy(String id) {
        return null;
    }

    @Override
    @Transactional
    public CargoDTO update(CargoDTO cargo, String id) {
        return null;
    }

    @Override
    @Transactional
    public void delete(String id) {

    }
}

package by.ishangulyyev.backend.service;

import by.ishangulyyev.backend.model.CargoDTO;
import by.ishangulyyev.backend.model.CargoPage;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CargoService {
    Page<CargoPage> findAll(Pageable pageable);
    CargoDTO save(CargoDTO cargo);
    CargoDTO findBy(String id);
    CargoDTO update(CargoDTO cargo, String id);
    void accept(String id);
    void decline(String id, String reason);
    void delete(String id);
}

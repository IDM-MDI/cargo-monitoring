package by.ishangulyyev.backend.service;

import by.ishangulyyev.backend.entity.Cargo;
import by.ishangulyyev.backend.model.DeclinedCargoDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface DeclinedCargoService {
    void decline(Cargo cargo, String login, String reason);
    Page<DeclinedCargoDTO> findAll(Pageable pageable);
}

package by.ishangulyyev.backend.service.impl;

import by.ishangulyyev.backend.entity.Cargo;
import by.ishangulyyev.backend.entity.DeclinedCargo;
import by.ishangulyyev.backend.exception.EntityNotFoundException;
import by.ishangulyyev.backend.model.DeclinedCargoDTO;
import by.ishangulyyev.backend.repository.DeclinedCargoRepository;
import by.ishangulyyev.backend.service.DeclinedCargoService;
import by.ishangulyyev.backend.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class DeclinedCargoServiceImpl implements DeclinedCargoService {
    private final DeclinedCargoRepository declinedCargoRepository;
    private final EmployeeService employeeService;
    private final ModelMapper mapper;
    @Override
    public void decline(Cargo cargo, String login, String reason) {
        declinedCargoRepository.save(
                DeclinedCargo.builder()
                        .cargo(cargo)
                        .employee(
                                employeeService.findByLogin(login)
                                        .orElseThrow(EntityNotFoundException::new)
                        )
                        .pointcut(cargo.getPointcut())
                        .reason(reason)
                        .time(LocalDateTime.now())
                        .build()
        );
    }

    @Override
    public Page<DeclinedCargoDTO> findAll(Pageable pageable) {
        return declinedCargoRepository.findAll(pageable)
                .map(cargo -> mapper.map(cargo, DeclinedCargoDTO.class));
    }
}

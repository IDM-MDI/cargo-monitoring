package by.ishangulyyev.backend.service.impl;

import by.ishangulyyev.backend.entity.AcceptedCargo;
import by.ishangulyyev.backend.entity.Cargo;
import by.ishangulyyev.backend.entity.Employee;
import by.ishangulyyev.backend.exception.EntityNotFoundException;
import by.ishangulyyev.backend.repository.AcceptedCargoRepository;
import by.ishangulyyev.backend.service.AcceptedCargoService;
import by.ishangulyyev.backend.service.EmployeeService;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class AcceptedCargoServiceImpl implements AcceptedCargoService {
    private final AcceptedCargoRepository acceptedCargoRepository;
    private final EmployeeService employeeService;
    @Override
    public void accept(@NotNull Cargo cargo, String login) {
        acceptedCargoRepository.save(
                AcceptedCargo.builder()
                        .cargo(cargo)
                        .employee(
                                employeeService.findByLogin(login)
                                        .orElseThrow(EntityNotFoundException::new)
                        )
                        .pointcut(cargo.getPointcut())
                        .time(LocalDateTime.now())
                        .build()
        );
    }
}

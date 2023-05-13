package by.ishangulyyev.backend.service.impl;

import by.ishangulyyev.backend.entity.AcceptedCargo;
import by.ishangulyyev.backend.entity.Cargo;
import by.ishangulyyev.backend.entity.DeclinedCargo;
import by.ishangulyyev.backend.entity.type.CargoStatus;
import by.ishangulyyev.backend.exception.EntityNotFoundException;
import by.ishangulyyev.backend.model.CargoDTO;
import by.ishangulyyev.backend.model.CargoPage;
import by.ishangulyyev.backend.repository.AcceptedCargoRepository;
import by.ishangulyyev.backend.repository.CargoRepository;
import by.ishangulyyev.backend.repository.DeclinedCargoRepository;
import by.ishangulyyev.backend.service.AirportService;
import by.ishangulyyev.backend.service.CargoContentService;
import by.ishangulyyev.backend.service.CargoService;
import by.ishangulyyev.backend.service.CompanyService;
import by.ishangulyyev.backend.service.EmployeeService;
import by.ishangulyyev.backend.service.PersonService;
import by.ishangulyyev.backend.service.PointcutService;
import by.ishangulyyev.backend.util.CargoUtil;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CargoServiceImpl implements CargoService {
    private final CargoRepository repository;
    private final AcceptedCargoRepository acceptedCargoRepository;
    private final DeclinedCargoRepository declinedCargoRepository;
    private final PersonService personService;
    private final AirportService airportService;
    private final CompanyService companyService;
    private final CargoContentService cargoContentService;
    private final EmployeeService employeeService;
    private final PointcutService pointcutService;
    private final ModelMapper mapper;
    @Override
    public Page<CargoPage> findAll(Pageable pageable) {
        return repository.findAll(pageable)
                .map(cargo -> mapper.map(cargo, CargoPage.class));
    }

    @Override
    @Transactional
    public CargoDTO save(CargoDTO cargo) {
        Cargo entity = mapper.map(cargo, Cargo.class);
        entity.setContent(cargoContentService.save(cargo.getContent()));
        entity.setCompany(companyService.save(cargo.getCompany()));
        entity.setPerson(personService.save(cargo.getPerson()));
        entity.setDepartureAirport(airportService.save(cargo.getDepartureAirport()));
        entity.setPointcut(pointcutService.findMinimumOrder());
        return CargoUtil.mapQR(mapper.map(repository.save(entity), CargoDTO.class));
    }

    @Override
    @Transactional
    public CargoDTO findBy(String id) {
        return repository.findById(id)
                .map(cargo -> mapper.map(cargo, CargoDTO.class))
                .map(CargoUtil::mapQR)
                .orElseThrow(EntityNotFoundException::new);
    }

    @Override
    @Transactional
    public CargoDTO update(CargoDTO cargo, String id) {
        Cargo entity = repository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
        entity.setContent(cargoContentService.update(cargo.getContent(), entity.getContent().getId()));
        entity.setDepartureAirport(airportService.save(cargo.getDepartureAirport()));
        entity.setCompany(companyService.save(cargo.getCompany()));
        entity.setArrivalTime(cargo.getArrivalTime());
        entity.setPerson(personService.update(cargo.getPerson(), entity.getPerson().getId()));
        entity.setType(cargo.getType());
        return CargoUtil.mapQR(mapper.map(repository.save(entity), CargoDTO.class));
    }

    @Override
    public void accept(String id, String login) {
        Cargo cargo = repository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
        cargo.setStatus(CargoStatus.ACCEPTED);
        repository.save(cargo);
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

    @Override
    public void decline(String id, String login, String reason) {
        Cargo cargo = repository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
        cargo.setStatus(CargoStatus.DECLINED);
        repository.save(cargo);
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
    @Transactional
    public void delete(String id) {
        Cargo cargo = repository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
        cargo.setStatus(CargoStatus.DELETED);
        repository.save(cargo);
    }
}

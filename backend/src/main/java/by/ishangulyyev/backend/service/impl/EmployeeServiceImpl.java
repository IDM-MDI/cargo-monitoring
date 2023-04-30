package by.ishangulyyev.backend.service.impl;

import by.ishangulyyev.backend.entity.Employee;
import by.ishangulyyev.backend.entity.type.EmployeeStatus;
import by.ishangulyyev.backend.model.EmployeeDTO;
import by.ishangulyyev.backend.model.EmployeePage;
import by.ishangulyyev.backend.repository.EmployeeRepository;
import by.ishangulyyev.backend.service.AuthenticationService;
import by.ishangulyyev.backend.service.EmployeeService;
import by.ishangulyyev.backend.service.PersonService;
import by.ishangulyyev.backend.service.PositionService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository repository;
    private final PersonService personService;
    private final PositionService positionService;
    private final AuthenticationService authenticationService;
    private final ModelMapper mapper;
    @Override
    public Page<EmployeePage> findAll(Pageable pageable) {
        return repository.findAll(pageable)
                .map(employee -> mapper.map(employee, EmployeePage.class));
    }

    @Override
    @Transactional
    public EmployeeDTO save(EmployeeDTO employee) {
        Employee entity = mapper.map(employee, Employee.class);
        entity.setPerson(personService.save(employee.getPerson()));
        entity.setPosition(positionService.save(employee.getPosition()));
        entity.setAuthentication(authenticationService.registration(employee.getAuthentication()));
        return mapper.map(repository.save(entity), EmployeeDTO.class);
    }
}

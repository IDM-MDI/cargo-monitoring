package by.ishangulyyev.backend.service.impl;

import by.ishangulyyev.backend.entity.Employee;
import by.ishangulyyev.backend.entity.type.EmployeeStatus;
import by.ishangulyyev.backend.model.EmployeeDTO;
import by.ishangulyyev.backend.model.EmployeePage;
import by.ishangulyyev.backend.repository.EmployeeRepository;
import by.ishangulyyev.backend.service.EmployeeService;
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
    private final ModelMapper mapper;
    @Override
    public Page<EmployeePage> findAll(Pageable pageable) {
        return repository.findAll(pageable)
                .map(employee -> mapper.map(employee, EmployeePage.class));
    }

    @Override
    public EmployeeDTO save(EmployeeDTO employee) {
        Employee entity = mapper.map(employee, Employee.class);
        entity.setStatus(EmployeeStatus.ACTIVE);
        return null;
    }
}

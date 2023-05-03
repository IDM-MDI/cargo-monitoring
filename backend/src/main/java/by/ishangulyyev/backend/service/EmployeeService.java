package by.ishangulyyev.backend.service;

import by.ishangulyyev.backend.entity.Employee;
import by.ishangulyyev.backend.model.EmployeeDTO;
import by.ishangulyyev.backend.model.EmployeePage;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface EmployeeService {
    Page<EmployeePage> findAll(Pageable pageable);
    EmployeeDTO save(EmployeeDTO employee);
    EmployeeDTO findBy(String id);
    EmployeeDTO update(EmployeeDTO employee, String id);
    void delete(String id);

    Optional<Employee> findByLogin(String login);
}

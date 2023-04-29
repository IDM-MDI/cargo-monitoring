package by.ishangulyyev.backend.service;

import by.ishangulyyev.backend.model.EmployeePage;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface EmployeeService {
    Page<EmployeePage> findAll(Pageable pageable);
}

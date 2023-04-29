package by.ishangulyyev.backend.repository;

import by.ishangulyyev.backend.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, String> {
}

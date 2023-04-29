package by.ishangulyyev.backend.controller;

import by.ishangulyyev.backend.model.EmployeePage;
import by.ishangulyyev.backend.service.impl.EmployeeServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/employees")
@RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeServiceImpl service;

    public Page<EmployeePage> findAll(Pageable pageable) {
        return service.findAll(pageable);
    }
}
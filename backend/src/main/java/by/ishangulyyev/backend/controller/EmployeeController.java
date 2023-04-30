package by.ishangulyyev.backend.controller;

import by.ishangulyyev.backend.model.EmployeeDTO;
import by.ishangulyyev.backend.model.EmployeePage;
import by.ishangulyyev.backend.service.impl.EmployeeServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/employees")
@RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeServiceImpl service;

    @GetMapping
    public Page<EmployeePage> findAll(Pageable pageable) {
        return service.findAll(pageable);
    }

    @PostMapping
    public EmployeeDTO save(@RequestBody @Valid EmployeeDTO employee) {
        return service.save(employee);
    }

    @GetMapping("/{id}")
    public EmployeeDTO findBy(@PathVariable String id) {
        return service.findBy(id);
    }

    @PutMapping("/{id}")
    public EmployeeDTO update(@PathVariable String id, @RequestBody @Valid EmployeeDTO employee) {
        return service.update(employee, id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable String id) {
        service.delete(id);
        return ResponseEntity.ok("Employee was successfully deleted");
    }
}

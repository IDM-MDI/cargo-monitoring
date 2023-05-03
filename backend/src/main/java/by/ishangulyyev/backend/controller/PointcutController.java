package by.ishangulyyev.backend.controller;

import by.ishangulyyev.backend.model.PointcutDTO;
import by.ishangulyyev.backend.service.PointcutService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/pointcuts")
@RequiredArgsConstructor
public class PointcutController {
    private final PointcutService service;

    @GetMapping
    public Page<PointcutDTO> findAll(Pageable pageable) {
        return service.findAll(pageable);
    }

    @PostMapping
    public PointcutDTO save(@Valid PointcutDTO pointcut) {
        return service.save(pointcut);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable String id) {
        service.delete(id);
        return ResponseEntity.ok("Pointcut was successfully deleted");
    }
}

package by.ishangulyyev.backend.controller;

import by.ishangulyyev.backend.model.CargoDTO;
import by.ishangulyyev.backend.model.CargoPage;
import by.ishangulyyev.backend.service.CargoService;
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
@RequestMapping("/api/v1/cargos")
@RequiredArgsConstructor
public class CargoController {
    private final CargoService service;

    @GetMapping
    public Page<CargoPage> findAll(Pageable pageable) {
        return service.findAll(pageable);
    }

    @PostMapping
    public CargoDTO save(@RequestBody @Valid CargoDTO cargo) {
        return service.save(cargo);
    }

    @GetMapping("/{id}")
    public CargoDTO findBy(@PathVariable String id) {
        return service.findBy(id);
    }

    @PutMapping("/{id}")
    public CargoDTO update(@PathVariable String id, @RequestBody @Valid CargoDTO cargo) {
        return service.update(cargo, id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable String id) {
        service.delete(id);
        return ResponseEntity.ok("Cargo was successfully deleted");
    }
}

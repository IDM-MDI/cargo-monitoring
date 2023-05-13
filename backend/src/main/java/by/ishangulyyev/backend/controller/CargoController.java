package by.ishangulyyev.backend.controller;

import by.ishangulyyev.backend.model.CargoDTO;
import by.ishangulyyev.backend.model.CargoPage;
import by.ishangulyyev.backend.service.CargoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static by.ishangulyyev.backend.util.ContextUtil.getLogin;

@RestController
@RequestMapping("/api/v1/cargos")
@RequiredArgsConstructor
public class CargoController {
    private final CargoService service;

    @GetMapping
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
    public Page<CargoPage> findAll(Pageable pageable) {
        return service.findAll(pageable);
    }

    @PostMapping
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public CargoDTO save(@RequestBody @Valid CargoDTO cargo) {
        return service.save(cargo);
    }

    @PatchMapping("/{id}/accept")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
    public ResponseEntity<String> accept(@PathVariable String id) {
        service.accept(id, getLogin());
        return ResponseEntity.ok("Cargo was accepted");
    }

    @PatchMapping("/{id}/decline")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
    public ResponseEntity<String> decline(@PathVariable String id, @RequestParam("reason") String reason) {
        service.decline(id, getLogin(), reason);
        return ResponseEntity.ok("Cargo was declined");
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
    public CargoDTO findBy(@PathVariable String id) {
        return service.findBy(id);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public CargoDTO update(@PathVariable String id, @RequestBody @Valid CargoDTO cargo) {
        return service.update(cargo, id);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public ResponseEntity<String> delete(@PathVariable String id) {
        service.delete(id);
        return ResponseEntity.ok("Cargo was successfully deleted");
    }
}

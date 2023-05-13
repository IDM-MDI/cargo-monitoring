package by.ishangulyyev.backend.controller;

import by.ishangulyyev.backend.model.DeclinedCargoDTO;
import by.ishangulyyev.backend.service.DeclinedCargoService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/cargos/decline")
@RequiredArgsConstructor
public class DeclineCargoController {
    private final DeclinedCargoService service;

    @GetMapping
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
    public Page<DeclinedCargoDTO> findAll(Pageable pageable) {
        return service.findAll(pageable);
    }
}

package by.ishangulyyev.backend.controller;

import by.ishangulyyev.backend.model.CargoStatistic;
import by.ishangulyyev.backend.service.impl.CargoStatisticService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/statistics")
@RequiredArgsConstructor
public class StatisticController {
    private final CargoStatisticService cargoStatisticService;
    @GetMapping("/cargo")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
    public CargoStatistic find() {
        return cargoStatisticService.find();
    }
}

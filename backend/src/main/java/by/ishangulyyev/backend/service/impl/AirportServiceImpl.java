package by.ishangulyyev.backend.service.impl;

import by.ishangulyyev.backend.entity.Airport;
import by.ishangulyyev.backend.model.AirportDTO;
import by.ishangulyyev.backend.repository.AirportRepository;
import by.ishangulyyev.backend.service.AirportService;
import by.ishangulyyev.backend.service.CompanyService;
import by.ishangulyyev.backend.service.OriginService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AirportServiceImpl implements AirportService {
    private final AirportRepository repository;
    private final CompanyService companyService;
    private final OriginService originService;
    @Override
    public Airport save(AirportDTO airport) {
        return repository.findByNameIgnoreCase(airport.getName())
                .orElseGet(() -> repository.save(
                        Airport.builder()
                                .name(airport.getName())
                                .origin(originService.save(airport.getOrigin()))
                                .company(companyService.save(airport.getCompany()))
                                .build()
                ));
    }
}

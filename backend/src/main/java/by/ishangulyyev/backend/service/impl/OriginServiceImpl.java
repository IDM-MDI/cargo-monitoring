package by.ishangulyyev.backend.service.impl;

import by.ishangulyyev.backend.entity.City;
import by.ishangulyyev.backend.entity.Country;
import by.ishangulyyev.backend.entity.Origin;
import by.ishangulyyev.backend.model.OriginDTO;
import by.ishangulyyev.backend.repository.OriginRepository;
import by.ishangulyyev.backend.service.CityService;
import by.ishangulyyev.backend.service.CountryService;
import by.ishangulyyev.backend.service.OriginService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class OriginServiceImpl implements OriginService {
    private final OriginRepository repository;
    private final CountryService countryService;
    private final CityService cityService;
    @Override
    @Transactional
    public Origin save(@Valid OriginDTO origin) {
        return repository.findByCountry_NameIgnoreCaseAndCity_NameIgnoreCase(origin.getCountry(), origin.getCity())
                .orElse(save(
                        Origin.builder()
                                .country(Country.builder().name(origin.getCountry()).build())
                                .city(City.builder().name(origin.getCity()).build())
                                .build()
                ));
    }

    private Origin save(Origin origin) {
        origin.setCountry(countryService.save(origin.getCountry().getName()));
        origin.setCity(cityService.save(origin.getCity().getName()));
        return repository.save(origin);
    }
}

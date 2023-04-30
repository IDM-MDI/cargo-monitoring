package by.ishangulyyev.backend.service.impl;

import by.ishangulyyev.backend.entity.Origin;
import by.ishangulyyev.backend.model.OriginDTO;
import by.ishangulyyev.backend.repository.OriginRepository;
import by.ishangulyyev.backend.service.CityService;
import by.ishangulyyev.backend.service.CountryService;
import by.ishangulyyev.backend.service.OriginService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OriginServiceImpl implements OriginService {
    private final OriginRepository repository;
    private final CountryService countryService;
    private final CityService cityService;
    private final ModelMapper mapper;
    @Override
    public Origin save(@Valid OriginDTO origin) {
        return repository.findByCountry_NameEqualsIgnoreCaseAndCity_NameEqualsIgnoreCase(origin.getCountry(), origin.getCity())
                .orElse(save(mapper.map(origin, Origin.class)));
    }

    private Origin save(Origin origin) {
        origin.setCountry(countryService.save(origin.getCountry().getName()));
        origin.setCity(cityService.save(origin.getCity().getName()));
        return repository.save(origin);
    }
}

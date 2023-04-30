package by.ishangulyyev.backend.service.impl;

import by.ishangulyyev.backend.entity.City;
import by.ishangulyyev.backend.repository.CityRepository;
import by.ishangulyyev.backend.service.CityService;
import by.ishangulyyev.backend.util.StringUtil;
import jakarta.validation.constraints.NotBlank;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CityServiceImpl implements CityService {
    private final CityRepository repository;
    @Override
    public City save(@NotBlank String city) {
        return repository.findByNameEqualsIgnoreCase(city)
                .orElse(repository.save(
                        City.builder()
                                .name(StringUtil.pascalCase(city))
                                .build()
                ));
    }
}

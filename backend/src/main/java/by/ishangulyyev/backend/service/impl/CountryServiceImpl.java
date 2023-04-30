package by.ishangulyyev.backend.service.impl;

import by.ishangulyyev.backend.entity.Country;
import by.ishangulyyev.backend.repository.CountryRepository;
import by.ishangulyyev.backend.service.CountryService;
import by.ishangulyyev.backend.util.StringUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CountryServiceImpl implements CountryService {
    private final CountryRepository repository;
    @Override
    public Country save(String country) {
        return repository.findByNameEqualsIgnoreCase(country)
                .orElse(repository.save(
                        Country.builder()
                                .name(StringUtil.pascalCase(country))
                                .build()
                ));
    }
}

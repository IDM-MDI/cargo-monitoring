package by.ishangulyyev.backend.service.impl;

import by.ishangulyyev.backend.entity.Company;
import by.ishangulyyev.backend.model.CompanyDTO;
import by.ishangulyyev.backend.repository.CompanyRepository;
import by.ishangulyyev.backend.service.CompanyService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CompanyServiceImpl implements CompanyService {
    private final CompanyRepository repository;
    private final ModelMapper mapper;
    @Override
    public Company save(@Valid CompanyDTO company) {
        company.setId(null);
        return repository.findByNameIgnoreCase(company.getName())
                .orElseGet(() -> repository.save(mapper.map(company, Company.class)));
    }
}

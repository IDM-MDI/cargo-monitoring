package by.ishangulyyev.backend.service;

import by.ishangulyyev.backend.entity.Company;
import by.ishangulyyev.backend.model.CompanyDTO;

public interface CompanyService {
    Company save(CompanyDTO company);
}

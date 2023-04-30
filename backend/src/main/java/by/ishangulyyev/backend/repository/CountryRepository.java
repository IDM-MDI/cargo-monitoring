package by.ishangulyyev.backend.repository;

import by.ishangulyyev.backend.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CountryRepository extends JpaRepository<Country, String> {
    Optional<Country> findByNameIgnoreCase(String name);
}

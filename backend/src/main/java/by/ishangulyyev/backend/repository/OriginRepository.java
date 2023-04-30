package by.ishangulyyev.backend.repository;

import by.ishangulyyev.backend.entity.Origin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OriginRepository extends JpaRepository<Origin, String> {
    Optional<Origin> findByCountry_NameEqualsIgnoreCaseAndCity_NameEqualsIgnoreCase(String country, String city);
}

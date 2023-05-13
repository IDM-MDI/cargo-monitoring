package by.ishangulyyev.backend.repository;

import by.ishangulyyev.backend.entity.Cargo;
import by.ishangulyyev.backend.entity.type.CargoStatus;
import by.ishangulyyev.backend.entity.type.CargoType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface CargoRepository extends JpaRepository<Cargo, String> {
    Optional<Long> countByStatus(CargoStatus status);
    Optional<Cargo> findFirstByOrderByContent_WeightDesc();
    Optional<Cargo> findFirstByOrderByContent_WeightAsc();
    @Query(value = "SELECT c.type FROM Cargo c " +
            "GROUP BY c.type " +
            "ORDER BY COUNT(c.type) ASC")
    Optional<CargoType> mostShippedType();
    @Query(value = "SELECT c.person.origin.country FROM Cargo c " +
            "GROUP BY c.person.origin.country " +
            "ORDER BY COUNT(c.person.origin.country) DESC")
    Optional<String> mostPopularCountry();
    @Query(value = "SELECT c.person.origin.country FROM Cargo c " +
            "GROUP BY c.person.origin.country " +
            "ORDER BY COUNT(c.person.origin.country) ASC")
    Optional<String> mostUnpopularCountry();
}

package by.ishangulyyev.backend.repository;

import by.ishangulyyev.backend.entity.Position;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PositionRepository extends JpaRepository<Position, String> {
    Optional<Position> findByNameEqualsIgnoreCase(String name);
}

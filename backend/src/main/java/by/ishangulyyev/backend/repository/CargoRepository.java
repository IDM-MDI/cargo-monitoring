package by.ishangulyyev.backend.repository;

import by.ishangulyyev.backend.entity.Cargo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CargoRepository extends JpaRepository<Cargo, String> {
}

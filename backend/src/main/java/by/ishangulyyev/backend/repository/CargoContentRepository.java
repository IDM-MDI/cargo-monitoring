package by.ishangulyyev.backend.repository;

import by.ishangulyyev.backend.entity.CargoContent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CargoContentRepository extends JpaRepository<CargoContent, String> {
}

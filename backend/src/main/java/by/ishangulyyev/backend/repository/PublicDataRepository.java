package by.ishangulyyev.backend.repository;

import by.ishangulyyev.backend.entity.PublicData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PublicDataRepository extends JpaRepository<PublicData, String> {
}

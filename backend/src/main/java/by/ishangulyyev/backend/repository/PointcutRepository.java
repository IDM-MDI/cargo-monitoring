package by.ishangulyyev.backend.repository;

import by.ishangulyyev.backend.entity.Pointcut;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PointcutRepository extends JpaRepository<Pointcut, String> {
    Optional<Pointcut> findFirstByOrderByNumberAsc();
}

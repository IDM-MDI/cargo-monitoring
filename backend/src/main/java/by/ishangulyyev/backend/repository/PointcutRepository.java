package by.ishangulyyev.backend.repository;

import by.ishangulyyev.backend.entity.Pointcut;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface PointcutRepository extends JpaRepository<Pointcut, String> {
    Optional<Pointcut> findFirstByOrderByNumberAsc();
    Optional<Pointcut> findFirstByOrderByNumberDesc();
    Optional<Pointcut> findByNumber(Long number);
    Optional<Pointcut> findByEmployee_Authentication_Login(String login);
    @Query(value = "SELECT p.number FROM Pointcut p " +
            "ORDER BY p.number ASC")
    List<Long> findAllNumbers();
}

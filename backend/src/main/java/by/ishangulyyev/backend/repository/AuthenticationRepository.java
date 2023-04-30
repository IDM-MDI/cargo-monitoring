package by.ishangulyyev.backend.repository;

import by.ishangulyyev.backend.entity.Authentication;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthenticationRepository extends JpaRepository<Authentication, String> {
}

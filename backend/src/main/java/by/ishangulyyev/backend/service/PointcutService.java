package by.ishangulyyev.backend.service;

import by.ishangulyyev.backend.entity.Pointcut;
import by.ishangulyyev.backend.model.PointcutDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface PointcutService {
    Pointcut findMinimumOrder();
    Page<PointcutDTO> findAll(Pageable pageable);
    PointcutDTO save(PointcutDTO pointcut);
    void delete(String id);
    Optional<Pointcut> findNext(Pointcut pointcut);
    PointcutDTO patchLogin(String id, String login);
}

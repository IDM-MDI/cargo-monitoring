package by.ishangulyyev.backend.service;

import by.ishangulyyev.backend.entity.Pointcut;
import by.ishangulyyev.backend.model.PointcutDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PointcutService {
    Pointcut findMinimumOrder();
    Page<PointcutDTO> findAll(Pageable pageable);
    PointcutDTO save(PointcutDTO pointcut);
    void delete(String id);

    PointcutDTO patchLogin(String id, String login);
}

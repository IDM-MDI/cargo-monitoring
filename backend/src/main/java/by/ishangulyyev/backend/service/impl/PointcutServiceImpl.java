package by.ishangulyyev.backend.service.impl;

import by.ishangulyyev.backend.entity.Pointcut;
import by.ishangulyyev.backend.exception.EntityNotFoundException;
import by.ishangulyyev.backend.repository.PointcutRepository;
import by.ishangulyyev.backend.service.PointcutService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PointcutServiceImpl implements PointcutService {
    private final PointcutRepository repository;
    @Override
    public Pointcut findMinimumOrder() {
        return repository.findFirstByOrderByNumberAsc()
                .orElseThrow(EntityNotFoundException::new);
    }
}

package by.ishangulyyev.backend.service.impl;

import by.ishangulyyev.backend.entity.Position;
import by.ishangulyyev.backend.repository.PositionRepository;
import by.ishangulyyev.backend.service.PositionService;
import by.ishangulyyev.backend.util.StringUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PositionServiceImpl implements PositionService {
    private final PositionRepository repository;
    @Override
    public Position save(String position) {
        return repository.findByNameEqualsIgnoreCase(position)
                .orElse(repository.save(
                        Position.builder()
                                .name(StringUtil.pascalCase(position))
                                .build()
                ));
    }
}

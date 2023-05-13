package by.ishangulyyev.backend.service.impl;

import by.ishangulyyev.backend.entity.type.CargoStatus;
import by.ishangulyyev.backend.entity.type.CargoType;
import by.ishangulyyev.backend.model.CargoStatistic;
import by.ishangulyyev.backend.repository.CargoRepository;
import by.ishangulyyev.backend.service.StatisticService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CargoStatisticService implements StatisticService {
    private final CargoRepository repository;

    @Override
    public CargoStatistic find() {
        return CargoStatistic.builder()
                .type(
                        repository.mostShippedType(Pageable.ofSize(1))
                                .stream()
                                .findFirst()
                                .orElse(CargoType.GLASS)
                )
                .finished(
                        repository.countByStatus(CargoStatus.FINISHED)
                                .orElse(0L)
                )
                .popularCountry(
                        repository.mostPopularCountry(Pageable.ofSize(1))
                                .stream()
                                .findFirst()
                                .orElse("Empty")
                )
                .unpopularCountry(
                        repository.mostUnpopularCountry(Pageable.ofSize(1))
                                .stream()
                                .findFirst()
                                .orElse("Empty")
                )
                .minWeight(
                        repository.findFirstByOrderByContent_WeightAsc()
                                .map(cargo -> cargo.getContent().getWeight())
                                .orElse(0D)
                )
                .maxWeight(
                        repository.findFirstByOrderByContent_WeightDesc()
                                .map(cargo -> cargo.getContent().getWeight())
                                .orElse(0D)
                )
                .build();
    }
}

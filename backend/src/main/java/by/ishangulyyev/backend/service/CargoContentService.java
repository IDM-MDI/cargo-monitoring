package by.ishangulyyev.backend.service;

import by.ishangulyyev.backend.entity.CargoContent;
import by.ishangulyyev.backend.model.CargoContentDTO;

public interface CargoContentService {
    CargoContent save(CargoContentDTO cargoContent);
    CargoContent update(CargoContentDTO cargoContent, String id);
}

package by.ishangulyyev.backend.service;

import by.ishangulyyev.backend.entity.Airport;
import by.ishangulyyev.backend.model.AirportDTO;

public interface AirportService {
    Airport save(AirportDTO airport);
}

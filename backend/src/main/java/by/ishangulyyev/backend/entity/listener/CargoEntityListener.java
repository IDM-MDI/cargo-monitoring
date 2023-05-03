package by.ishangulyyev.backend.entity.listener;

import by.ishangulyyev.backend.entity.Cargo;
import by.ishangulyyev.backend.entity.type.CargoStatus;
import jakarta.persistence.PrePersist;

public class CargoEntityListener {
    @PrePersist
    public void setCreationDate(Cargo entity) {
        entity.setStatus(CargoStatus.ACTIVE);
    }
}

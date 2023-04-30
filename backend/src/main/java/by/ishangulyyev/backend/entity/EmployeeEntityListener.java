package by.ishangulyyev.backend.entity;

import by.ishangulyyev.backend.entity.type.EmployeeStatus;
import jakarta.persistence.PrePersist;

import java.time.LocalDate;

public class EmployeeEntityListener {
    @PrePersist
    public void setCreationDate(Employee entity) {
        entity.setStartWork(LocalDate.now());
        entity.setStatus(EmployeeStatus.ACTIVE);
    }
}

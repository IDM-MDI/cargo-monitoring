package by.ishangulyyev.cargomonitoring.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmployeePage {
    private String id;
    private String name;
    private String surname;
    private String position;
    private String status;
}
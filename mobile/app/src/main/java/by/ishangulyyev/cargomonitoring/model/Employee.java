package by.ishangulyyev.cargomonitoring.model;

import by.ishangulyyev.cargomonitoring.adapter.LocalDateAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.annotations.JsonAdapter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    private String id;
    @SerializedName("authentication")
    private Authentication authentication;
    @SerializedName("person")
    private Person person;
    @SerializedName("salary")
    private int salary;
    @JsonAdapter(LocalDateAdapter.class)
    private LocalDate startWork;
    @SerializedName("position")
    private String position;
    private String status;
}

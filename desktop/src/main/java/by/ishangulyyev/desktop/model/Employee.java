package by.ishangulyyev.desktop.model;

import com.google.gson.annotations.SerializedName;
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
    @SerializedName("id")
    private String id;
    @SerializedName("authentication")
    private AuthenticationRequest authentication;
    @SerializedName("person")
    private Person person;
    @SerializedName("salary")
    private int salary;
    @SerializedName("startWork")
    private LocalDate startWork;
    @SerializedName("position")
    private String position;
    @SerializedName("status")
    private String status;
}

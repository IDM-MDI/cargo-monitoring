package by.ishangulyyev.cargomonitoring.model;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Authentication {
    private String login;
    private String password;

    private String role;
    private String token;
}

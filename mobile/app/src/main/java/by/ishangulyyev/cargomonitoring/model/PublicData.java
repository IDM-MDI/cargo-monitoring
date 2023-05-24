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
public class PublicData {
    @SerializedName("email")
    private String email;
    @SerializedName("phone")
    private String phone;
}

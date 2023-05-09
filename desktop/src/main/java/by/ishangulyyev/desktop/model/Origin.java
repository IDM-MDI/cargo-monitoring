package by.ishangulyyev.desktop.model;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Origin {
    @SerializedName("country")
    private String country;
    @SerializedName("city")
    private String city;
}

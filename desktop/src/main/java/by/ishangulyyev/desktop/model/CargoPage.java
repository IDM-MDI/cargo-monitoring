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
public class CargoPage {
    @SerializedName("id")
    private String id;
    @SerializedName("client")
    private String client;
    @SerializedName("country")
    private String country;
    @SerializedName("type")
    private String type;
    @SerializedName("status")
    private String status;
}

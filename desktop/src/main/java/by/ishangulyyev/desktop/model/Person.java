package by.ishangulyyev.desktop.model;

import by.ishangulyyev.desktop.adapter.LocalDateAdapter;
import com.google.gson.annotations.JsonAdapter;
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
public class Person {
    private String id;
    @SerializedName("name")
    private String name;
    @SerializedName("surname")
    private String surname;
    @SerializedName("lastname")
    private String lastname;
    @SerializedName("birthday")
    @JsonAdapter(LocalDateAdapter.class)
    private LocalDate birthday;
    @SerializedName("origin")
    private Origin origin;
    @SerializedName("gender")
    private String gender;
    @SerializedName("publicData")
    private PublicData publicData;
}

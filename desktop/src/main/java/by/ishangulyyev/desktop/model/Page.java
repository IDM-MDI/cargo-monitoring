package by.ishangulyyev.desktop.model;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.TreeMap;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Page {
    @SerializedName("content")
    private List<TreeMap<String,String>> content;
    @SerializedName("number")
    private int number;
    @SerializedName("last")
    private boolean last;
    @SerializedName("first")
    private boolean first;
    @SerializedName("empty")
    private boolean empty;
}

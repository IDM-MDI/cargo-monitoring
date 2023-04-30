package by.ishangulyyev.backend.util;

import jakarta.validation.constraints.NotBlank;
import lombok.experimental.UtilityClass;

import java.util.Arrays;
import java.util.stream.Collectors;

@UtilityClass
public class StringUtil {
    private static final String EMPTY = " ";
    public static String pascalCase(@NotBlank String string) {
        string = string.toLowerCase();
        return Arrays.stream(string.split(EMPTY))
                .map(s -> s.substring(0, 1).toUpperCase().concat(s.substring(1)))
                .collect(Collectors.joining(" "));
    }
}

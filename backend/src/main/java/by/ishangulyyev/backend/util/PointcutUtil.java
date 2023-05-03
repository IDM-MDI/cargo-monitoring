package by.ishangulyyev.backend.util;

import lombok.experimental.UtilityClass;

import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

@UtilityClass
public class PointcutUtil {
    public static Optional<Long> findSpaceNumber(List<Long> numbers) {
        return IntStream.range(0, numbers.size() - 1)
                .filter(i -> numbers.get(i + 1) - numbers.get(i) > 1)
                .mapToObj(i -> numbers.get(i) + 1)
                .findFirst();
    }
}

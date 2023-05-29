package by.ishangulyyev.desktop.validator;

import lombok.experimental.UtilityClass;

@UtilityClass
public class CargoValidator {
    private static final String LOCAL_DATE_TIME_PATTERN = "\\d{4}-\\d{1,2}-\\d{1,2}T\\d{1,2}:\\d{1,2}";
    private static final String COTTON = "COTTON";
    private static final String GLASS = "GLASS";
    private static final String TECHNIQUE = "TECHNIQUE";

    public boolean isLocalDateTimeValid(String date) {
        return date.matches(LOCAL_DATE_TIME_PATTERN);
    }
    public boolean isType(String type) {
        return COTTON.equals(type) || GLASS.equals(type) || TECHNIQUE.equals(type);
    }
}

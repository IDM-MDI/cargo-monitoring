package by.ishangulyyev.desktop.validator;

import lombok.NonNull;
import lombok.experimental.UtilityClass;

@UtilityClass
public class PersonValidator {
    private static final String LOCAL_DATE_PATTERN = "\\d{4}-\\d{1,2}-\\d{1,2}";
    private static final String NUMBER_PATTERN = "\\d{1,}";
    private static final String PHONE_PATTERN = "^\\+\\d{1,3}-\\d{1,4}-\\d{1,4}-\\d{1,4}$";
    private static final String EMAIL_PATTERN = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\\\.[A-Za-z0-9-]+)*(\\\\.[A-Za-z]{2,})$";
    public boolean isStringValid(@NonNull String string) {
        return !string.isBlank() && string.length() >= 2 && string.length() <= 50;
    }
    public boolean isLocalDateValid(String date) {
        return date.matches(LOCAL_DATE_PATTERN);
    }
    public boolean isNumber(String number) {
        return number.matches(NUMBER_PATTERN);
    }

    public boolean isPhone(String phone) {
        return phone.matches(PHONE_PATTERN);
    }

    public boolean isEmail(String email) {
        return email.matches(EMAIL_PATTERN);
    }
}

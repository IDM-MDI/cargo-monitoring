package by.ishangulyyev.desktop.service.impl;

import by.ishangulyyev.desktop.model.Origin;
import by.ishangulyyev.desktop.util.AlertUtil;
import by.ishangulyyev.desktop.validator.PersonValidator;

public class OriginServiceImpl {
    public static Origin getOrigin(String country, String city) {
        if(!PersonValidator.isStringValid(country)) {
            AlertUtil.errorMessage("Country not valid", "Country must be not empty and length between 2 and 50");
            throw new RuntimeException("Country not valid");
        } else if(!PersonValidator.isStringValid(city)) {
            AlertUtil.errorMessage("City not valid", "City must be not empty and length between 2 and 50");
            throw new RuntimeException("City not valid");
        }
        return Origin.builder()
                .country(country)
                .city(city)
                .build();
    }
}

package by.ishangulyyev.desktop.service.impl;

import by.ishangulyyev.desktop.model.Person;
import by.ishangulyyev.desktop.util.AlertUtil;
import by.ishangulyyev.desktop.validator.PersonValidator;

import java.time.LocalDate;

public class PersonServiceImpl {
    public static Person getPerson(String name,
                                   String surname,
                                   String lastname,
                                   String birthday,
                                   String gender,
                                   String country,
                                   String city,
                                   String email,
                                   String phone) {
        if(!PersonValidator.isStringValid(name)) {
            AlertUtil.errorMessage("Name not valid", "Name must be not empty and length between 2 and 50");
            throw new RuntimeException("Name not valid");
        } else if(!PersonValidator.isStringValid(surname)) {
            AlertUtil.errorMessage("Surname not valid", "Surname must be not empty and length between 2 and 50");
            throw new RuntimeException("Surname not valid");
        } else if(!PersonValidator.isStringValid(lastname)) {
            AlertUtil.errorMessage("Lastname not valid", "Lastname must be not empty and length between 2 and 50");
            throw new RuntimeException("Lastname not valid");
        } else if(!PersonValidator.isLocalDateValid(birthday)) {
            AlertUtil.errorMessage("Birthday not valid", "Birthday day need to be year-month-day");
            throw new RuntimeException("Birthday not valid");
        } else if(!PersonValidator.isGenderValid(gender)) {
            AlertUtil.errorMessage("Gender not valid", "Gender must be not empty and length between 2 and 50 AND MALE OR FEMALE");
            throw new RuntimeException("Gender not valid");
        }
        return Person.builder()
                .name(name)
                .surname(surname)
                .lastname(lastname)
                .birthday(LocalDate.parse(birthday))
                .gender(gender)
                .publicData(PublicDataServiceImpl.getPublicData(email, phone))
                .origin(OriginServiceImpl.getOrigin(country,city))
                .build();
    }
}

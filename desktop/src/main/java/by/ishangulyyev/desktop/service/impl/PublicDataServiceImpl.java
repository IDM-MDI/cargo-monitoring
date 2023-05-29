package by.ishangulyyev.desktop.service.impl;

import by.ishangulyyev.desktop.model.PublicData;
import by.ishangulyyev.desktop.util.AlertUtil;
import by.ishangulyyev.desktop.validator.PersonValidator;

public class PublicDataServiceImpl {

    public static PublicData getPublicData(String email, String phone) {
        if(!PersonValidator.isPhone(phone)) {
            AlertUtil.errorMessage("Phone not valid", "Phone must +number{1,3}-number{1,4}-number{1,4}-number{1,4}");
            throw new RuntimeException("Phone not valid");
        } else if(!PersonValidator.isEmail(email)) {
            AlertUtil.errorMessage("Email not valid", "Input value must be email");
            throw new RuntimeException("Email not valid");
        }
        return PublicData.builder()
                .phone(phone)
                .email(email)
                .build();
    }
}

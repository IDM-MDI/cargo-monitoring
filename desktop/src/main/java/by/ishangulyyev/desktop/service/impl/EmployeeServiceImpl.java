package by.ishangulyyev.desktop.service.impl;

import by.ishangulyyev.desktop.model.Employee;
import by.ishangulyyev.desktop.service.AuthenticationService;
import by.ishangulyyev.desktop.util.AlertUtil;
import by.ishangulyyev.desktop.validator.PersonValidator;

public class EmployeeServiceImpl {
    public static Employee getEmployee(String login,
                                       String password,
                                       String name,
                                       String surname,
                                       String lastname,
                                       String gender,
                                       String birthday,
                                       String country,
                                       String city,
                                       String email,
                                       String phone,
                                       String salary,
                                       String position) {
        if(!PersonValidator.isStringValid(position)) {
            AlertUtil.errorMessage("Position not valid", "Position must be not empty and length between 2 and 50");
            throw new RuntimeException("Position not valid");
        } else if(!PersonValidator.isNumber(salary)) {
            AlertUtil.errorMessage("Salary not valid", "Salary must be number");
            throw new RuntimeException("Salary not valid");
        }
        return Employee.builder()
                .authentication(AuthenticationService.getAuthentication(login, password))
                .person(PersonServiceImpl.getPerson(name, surname, lastname, birthday, gender, country, city, email, phone))
                .position(position)
                .salary(Integer.parseInt(salary))
                .build();
    }
}

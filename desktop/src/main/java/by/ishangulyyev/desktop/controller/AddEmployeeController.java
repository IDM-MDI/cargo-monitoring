package by.ishangulyyev.desktop.controller;

import by.ishangulyyev.desktop.button.AcceptButton;
import by.ishangulyyev.desktop.button.BackButton;
import by.ishangulyyev.desktop.model.Authentication;
import by.ishangulyyev.desktop.model.Employee;
import by.ishangulyyev.desktop.model.Origin;
import by.ishangulyyev.desktop.model.Person;
import by.ishangulyyev.desktop.model.PublicData;
import by.ishangulyyev.desktop.service.impl.RestApi;
import by.ishangulyyev.desktop.util.AlertUtil;
import by.ishangulyyev.desktop.util.SceneUtil;
import by.ishangulyyev.desktop.validator.PersonValidator;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.time.LocalDate;

import static by.ishangulyyev.desktop.controller.EmployeeController.EMPLOYEE_PAGE_URL;

public class AddEmployeeController implements BackButton, AcceptButton {
    private final RestApi<Employee> restApi;
    @FXML
    private TextField nameField;
    @FXML
    private TextField surnameField;
    @FXML
    private TextField lastnameField;
    @FXML
    private TextField loginField;
    @FXML
    private TextField passwordField;
    @FXML
    private TextField salaryField;
    @FXML
    private TextField positionField;
    @FXML
    private TextField genderField;
    @FXML
    private TextField birthdayField;
    @FXML
    private TextField emailField;
    @FXML
    private TextField phoneField;
    @FXML
    private TextField countryField;
    @FXML
    private TextField cityField;

    public AddEmployeeController() {
        this.restApi = new RestApi<>();
    }

    @Override
    public void onBackClick(MouseEvent event) {
        SceneUtil.switchScene(event, "employees.fxml");
    }

    @Override
    public void accept(ActionEvent event) {
        restApi.post(
                EMPLOYEE_PAGE_URL,
                getEmployee(
                        loginField,
                        passwordField,
                        nameField,
                        surnameField,
                        lastnameField,
                        birthdayField,
                        genderField,
                        countryField,
                        cityField,
                        emailField,
                        phoneField,
                        salaryField,
                        positionField
                ),
                Employee.class
                );
        SceneUtil.switchScene(event, "employees.fxml");
    }

    public static Employee getEmployee(TextField loginField,
                                       TextField passwordField,
                                       TextField nameField,
                                       TextField surnameField,
                                       TextField lastnameField,
                                       TextField birthdayField,
                                       TextField genderField,
                                       TextField countryField,
                                       TextField cityField,
                                       TextField emailField,
                                       TextField phoneField,
                                       TextField salaryField,
                                       TextField positionField
    ) {
        if(!PersonValidator.isStringValid(loginField.getText())) {
            AlertUtil.errorMessage("Login not valid", "Login must be not empty and length between 2 and 50");
            throw new RuntimeException("Login not valid");
        } else if(!PersonValidator.isStringValid(passwordField.getText())) {
            AlertUtil.errorMessage("Password not valid", "Password must be not empty and length between 2 and 50");
            throw new RuntimeException("Password not valid");
        } else if(!PersonValidator.isStringValid(nameField.getText())) {
            AlertUtil.errorMessage("Name not valid", "Name must be not empty and length between 2 and 50");
            throw new RuntimeException("Name not valid");
        } else if(!PersonValidator.isStringValid(surnameField.getText())) {
            AlertUtil.errorMessage("Surname not valid", "Surname must be not empty and length between 2 and 50");
            throw new RuntimeException("Surname not valid");
        } else if(!PersonValidator.isStringValid(lastnameField.getText())) {
            AlertUtil.errorMessage("Lastname not valid", "Lastname must be not empty and length between 2 and 50");
            throw new RuntimeException("Lastname not valid");
        } else if(!PersonValidator.isLocalDateValid(birthdayField.getText())) {
            AlertUtil.errorMessage("Birthday not valid", "Birthday day need to be year-month-day");
            throw new RuntimeException("Birthday not valid");
        } else if(!PersonValidator.isStringValid(countryField.getText())) {
            AlertUtil.errorMessage("Country not valid", "Country must be not empty and length between 2 and 50");
            throw new RuntimeException("Country not valid");
        } else if(!PersonValidator.isStringValid(cityField.getText())) {
            AlertUtil.errorMessage("City not valid", "City must be not empty and length between 2 and 50");
            throw new RuntimeException("City not valid");
        } else if(!PersonValidator.isGenderValid(genderField.getText())) {
            AlertUtil.errorMessage("Gender not valid", "Gender must be not empty and length between 2 and 50 AND MALE OR FEMALE");
            throw new RuntimeException("Gender not valid");
        } else if(!PersonValidator.isPhone(phoneField.getText())) {
            AlertUtil.errorMessage("Phone not valid", "Phone must +number{1,3}-number{1,4}-number{1,4}-number{1,4}");
            throw new RuntimeException("Phone not valid");
        } else if(!PersonValidator.isEmail(emailField.getText())) {
            AlertUtil.errorMessage("Email not valid", "Input value must be email");
            throw new RuntimeException("Email not valid");
        } else if(!PersonValidator.isStringValid(positionField.getText())) {
            AlertUtil.errorMessage("Position not valid", "Position must be not empty and length between 2 and 50");
            throw new RuntimeException("Position not valid");
        } else if(!PersonValidator.isNumber(salaryField.getText())) {
            AlertUtil.errorMessage("Salary not valid", "Salary must be number");
            throw new RuntimeException("Salary not valid");
        }
        return Employee.builder()
                .authentication(
                        Authentication.builder()
                                .login(loginField.getText())
                                .password(passwordField.getText())
                                .build()
                )
                .person(
                        Person.builder()
                                .name(nameField.getText())
                                .surname(surnameField.getText())
                                .lastname(lastnameField.getText())
                                .birthday(LocalDate.parse(birthdayField.getText()))
                                .gender(genderField.getText())
                                .origin(
                                        Origin.builder()
                                                .country(countryField.getText())
                                                .city(cityField.getText())
                                                .build()
                                )
                                .publicData(
                                        PublicData.builder()
                                                .email(emailField.getText())
                                                .phone(phoneField.getText())
                                                .build()
                                )
                                .build()
                )
                .salary(Integer.parseInt(salaryField.getText()))
                .position(positionField.getText())
                .build();
    }
}

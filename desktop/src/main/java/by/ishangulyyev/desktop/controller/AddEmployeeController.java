package by.ishangulyyev.desktop.controller;

import by.ishangulyyev.desktop.button.AcceptButton;
import by.ishangulyyev.desktop.button.BackButton;
import by.ishangulyyev.desktop.model.Authentication;
import by.ishangulyyev.desktop.model.Employee;
import by.ishangulyyev.desktop.model.Origin;
import by.ishangulyyev.desktop.model.Person;
import by.ishangulyyev.desktop.model.PublicData;
import by.ishangulyyev.desktop.service.impl.RestApi;
import by.ishangulyyev.desktop.util.SceneUtil;
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

    public static Employee getEmployee(TextField loginField, TextField passwordField, TextField nameField, TextField surnameField, TextField lastnameField, TextField birthdayField, TextField genderField, TextField countryField, TextField cityField, TextField emailField, TextField phoneField, TextField salaryField, TextField positionField) {
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

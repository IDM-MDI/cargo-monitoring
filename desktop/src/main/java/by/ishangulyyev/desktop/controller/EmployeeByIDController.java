package by.ishangulyyev.desktop.controller;

import by.ishangulyyev.desktop.model.Employee;
import by.ishangulyyev.desktop.model.EmployeePage;
import by.ishangulyyev.desktop.service.WebFetch;
import by.ishangulyyev.desktop.service.impl.RestApiFetch;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import static by.ishangulyyev.desktop.controller.EmployeeController.EMPLOYEE_PAGE_URL;

public class EmployeeByIDController implements BackButton {
    private final WebFetch<Employee> webFetch;
    private Employee employee;

    @FXML
    private TextField nameField;
    @FXML
    private TextField surnameField;
    @FXML
    private TextField lastnameField;
    @FXML
    private TextField birthdayField;
    @FXML
    private TextField genderField;
    @FXML
    private TextField countryField;
    @FXML
    private TextField cityField;
    @FXML
    private TextField phoneField;
    @FXML
    private TextField emailField;
    @FXML
    private TextField loginField;
    @FXML
    private TextField positionField;
    @FXML
    private TextField salaryField;
    @FXML
    private TextField startDateField;
    @FXML
    private TextField statusField;

    public EmployeeByIDController() {
        this.webFetch = new RestApiFetch<>();
    }

    public void setId(EmployeePage employeePage) {
        this.employee = webFetch.getDTO(EMPLOYEE_PAGE_URL, employeePage.getId(), Employee.class);
        nameField.setText(employee.getPerson().getName());
        surnameField.setText(employee.getPerson().getSurname());
        lastnameField.setText(employee.getPerson().getLastname());
        birthdayField.setText(employee.getPerson().getBirthday().toString());
        genderField.setText(employee.getPerson().getGender());
        countryField.setText(employee.getPerson().getOrigin().getCountry());
        cityField.setText(employee.getPerson().getOrigin().getCity());
        phoneField.setText(employee.getPerson().getPublicData().getPhone());
        emailField.setText(employee.getPerson().getPublicData().getEmail());
        loginField.setText(employee.getAuthentication().getLogin());
        positionField.setText(employee.getPosition());
        salaryField.setText(String.valueOf(employee.getSalary()));
        startDateField.setText(employee.getStartWork().toString());
        statusField.setText(employee.getStatus());
    }


    @Override
    public void back(ActionEvent event) {

    }

}

package by.ishangulyyev.desktop.controller;

import by.ishangulyyev.desktop.model.AuthenticationRequest;
import by.ishangulyyev.desktop.model.Employee;
import by.ishangulyyev.desktop.model.EmployeePage;
import by.ishangulyyev.desktop.model.Origin;
import by.ishangulyyev.desktop.model.Person;
import by.ishangulyyev.desktop.model.PublicData;
import by.ishangulyyev.desktop.service.impl.RestApi;
import by.ishangulyyev.desktop.util.PageUtil;
import by.ishangulyyev.desktop.util.SceneUtil;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

import java.time.LocalDate;

import static by.ishangulyyev.desktop.controller.AddEmployeeController.getEmployee;
import static by.ishangulyyev.desktop.controller.EmployeeController.EMPLOYEE_PAGE_URL;

public class EmployeeByIDController implements BackButton, EditButton, DeleteButton {
    private final RestApi<Employee> restApi;
    private Employee employee;
    private boolean isEdit;
    @FXML
    private Text mainText;
    @FXML
    private Button editButton;
    @FXML
    private HBox statusBlock;
    @FXML
    private HBox startDateBlock;
    @FXML
    private HBox passwordBlock;
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
    private TextField passwordField;
    @FXML
    private TextField positionField;
    @FXML
    private TextField salaryField;
    @FXML
    private TextField startDateField;
    @FXML
    private TextField statusField;

    public EmployeeByIDController() {
        this.restApi = new RestApi<>();
    }

    public void setId(EmployeePage employeePage) {
        isEdit = false;
        this.employee = restApi.getDTO(EMPLOYEE_PAGE_URL, employeePage.getId(), Employee.class);
        setScene();
    }

    private void setScene() {
        editButton.setText("Edit");
        isEdit = false;
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
        PageUtil.setDisableNonEditable(nameField);
        PageUtil.setDisableNonEditable(surnameField);
        PageUtil.setDisableNonEditable(lastnameField);
        PageUtil.setDisableNonEditable(birthdayField);
        PageUtil.setDisableNonEditable(genderField);
        PageUtil.setDisableNonEditable(countryField);
        PageUtil.setDisableNonEditable(cityField);
        PageUtil.setDisableNonEditable(phoneField);
        PageUtil.setDisableNonEditable(emailField);
        PageUtil.setDisableNonEditable(loginField);
        PageUtil.setDisableNonEditable(positionField);
        PageUtil.setDisableNonEditable(salaryField);
        PageUtil.setDisableNonEditable(statusField);
        PageUtil.setDisableNonEditable(startDateField);
        PageUtil.setVisible(statusBlock);
        PageUtil.setVisible(startDateBlock);
        PageUtil.setInvisible(passwordBlock);
    }


    @Override
    public void onBackClick(MouseEvent event) {
        SceneUtil.switchScene(event, "employees.fxml");
    }

    @Override
    public void edit(ActionEvent event) {
        if(!isEdit) {
            isEdit = true;
            editButton.setText("OK");
            PageUtil.setEditable(nameField);
            PageUtil.setEditable(surnameField);
            PageUtil.setEditable(lastnameField);
            PageUtil.setEditable(birthdayField);
            PageUtil.setEditable(genderField);
            PageUtil.setEditable(countryField);
            PageUtil.setEditable(cityField);
            PageUtil.setEditable(emailField);
            PageUtil.setEditable(phoneField);
            PageUtil.setEditable(loginField);
            PageUtil.setEditable(positionField);
            PageUtil.setEditable(salaryField);
            PageUtil.setVisible(passwordBlock);
            PageUtil.setInvisible(startDateBlock);
            PageUtil.setInvisible(statusBlock);
            mainText.setText("EMPLOYEE(EDIT)");
        } else {
            isEdit = false;
            mainText.setText("EMPLOYEE");
            // TODO: 5/9/2023 ADD VALIDATION
            this.employee = restApi.put(EMPLOYEE_PAGE_URL, employee.getId() , createEmployee(), Employee.class);
            setScene();
        }
    }
    public Employee createEmployee() {
        return getEmployee(loginField, passwordField, nameField, surnameField, lastnameField, birthdayField, genderField, countryField, cityField, emailField, phoneField, salaryField, positionField);
    }

    @Override
    public void delete(ActionEvent event) {
        if(restApi.delete(EMPLOYEE_PAGE_URL, employee.getId()) == 200) {
            SceneUtil.switchScene(event, "employees.fxml");
        }
    }
}

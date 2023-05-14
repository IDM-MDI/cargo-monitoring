package by.ishangulyyev.desktop.controller;

import by.ishangulyyev.desktop.button.AcceptButton;
import by.ishangulyyev.desktop.button.DeleteButton;
import by.ishangulyyev.desktop.button.EditButton;
import by.ishangulyyev.desktop.model.Cargo;
import by.ishangulyyev.desktop.model.CargoScene;
import by.ishangulyyev.desktop.service.impl.RestApi;
import by.ishangulyyev.desktop.util.PageUtil;
import by.ishangulyyev.desktop.util.SceneUtil;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.function.Consumer;

import static by.ishangulyyev.desktop.controller.CargoController.CARGO_PAGE_URL;

public abstract class CargoByIDNavigation implements EditButton, DeleteButton, AcceptButton {
    protected RestApi<Cargo> restApi;
    protected Cargo cargo;
    protected boolean isEdit;
    protected CargoScene cargoScene;
    @FXML
    protected ImageView image;
    @FXML
    protected TextField mainIDField;
    @FXML
    protected TextField mainTypeField;
    @FXML
    protected TextField mainStatusField;
    @FXML
    protected TextField mainArrivalField;
    @FXML
    protected TextField mainPointcutField;
    @FXML
    protected TextField clientNameField;
    @FXML
    protected TextField clientSurnameField;
    @FXML
    protected TextField clientLastnameField;
    @FXML
    protected TextField clientBirthdayField;
    @FXML
    protected TextField clientGenderField;
    @FXML
    protected TextField clientEmailField;
    @FXML
    protected TextField clientPhoneField;
    @FXML
    protected TextField companyNameField;
    @FXML
    protected TextField companyEmailField;
    @FXML
    protected TextField companyPhoneField;
    @FXML
    protected TextField companyCountryField;
    @FXML
    protected TextField companyCityField;
    @FXML
    protected TextField departureNameField;
    @FXML
    protected TextField departureArrivalField;
    @FXML
    protected TextField departureCompanyField;
    @FXML
    protected TextField departureCountryField;
    @FXML
    protected TextField departureCityField;
    @FXML
    protected TextField parameterLengthField;
    @FXML
    protected TextField parameterWidthField;
    @FXML
    protected TextField parameterHeightField;
    @FXML
    protected TextField parameterWeightField;

    protected CargoByIDNavigation() {
        restApi = new RestApi<>();
    }

    @FXML
    protected void main(ActionEvent event) {
        setEmployeeByFieldValuesBeforeSwitch();
        Consumer<CargoByIDController> consumer = controller -> controller.setContent(cargo, isEdit, CargoScene.MAIN);
        SceneUtil.switchScene(event, "cargo-by-id-main.fxml", consumer);
    }
    @FXML
    protected void client(ActionEvent event) {
        setEmployeeByFieldValuesBeforeSwitch();
        Consumer<CargoByIDController> consumer = controller -> controller.setContent(cargo, isEdit, CargoScene.CLIENT);
        SceneUtil.switchScene(event, "cargo-by-id-client.fxml", consumer);
    }
    @FXML
    protected void from(ActionEvent event) {
        setEmployeeByFieldValuesBeforeSwitch();
        Consumer<CargoByIDController> consumer = controller -> controller.setContent(cargo, isEdit, CargoScene.FROM);
        SceneUtil.switchScene(event, "cargo-by-id-from.fxml", consumer);
    }
    @FXML
    protected void departure(ActionEvent event) {
        setEmployeeByFieldValuesBeforeSwitch();
        Consumer<CargoByIDController> consumer = controller -> controller.setContent(cargo, isEdit, CargoScene.DEPARTURE);
        SceneUtil.switchScene(event, "cargo-by-id-departure.fxml", consumer);
    }
    @FXML
    protected void parameters(ActionEvent event) {
        setEmployeeByFieldValuesBeforeSwitch();
        Consumer<CargoByIDController> consumer = controller -> controller.setContent(cargo, isEdit, CargoScene.PARAMETERS);
        SceneUtil.switchScene(event, "cargo-by-id-parameters.fxml", consumer);
    }

    protected void setInitial(String id) {
        this.cargo = restApi.getDTO(CARGO_PAGE_URL, id, Cargo.class);
        this.isEdit = false;
        this.cargoScene = CargoScene.MAIN;
        setFields();
        setEditableFields();
    }

    protected void setContent(Cargo cargo, boolean isEdit, CargoScene cargoScene) {
        this.isEdit = isEdit;
        this.cargo = cargo;
        this.cargoScene = cargoScene;
        setFields();
        setEditableFields();
    }
    protected void setFields() {
        image.setImage(new Image(cargo.getQrCodeURL()));
        switch (cargoScene) {
            case MAIN -> {
                mainIDField.setText(cargo.getId());
                mainArrivalField.setText(cargo.getArrivalTime().toString());
                mainTypeField.setText(cargo.getType());
                mainPointcutField.setText(cargo.getPointcut());
                mainStatusField.setText(cargo.getStatus());
            }
            case CLIENT -> {
                clientNameField.setText(cargo.getPerson().getName());
                clientSurnameField.setText(cargo.getPerson().getSurname());
                clientLastnameField.setText(cargo.getPerson().getLastname());
                clientBirthdayField.setText(cargo.getPerson().getBirthday().toString());
                clientGenderField.setText(cargo.getPerson().getGender());
                clientEmailField.setText(cargo.getPerson().getPublicData().getEmail());
                clientPhoneField.setText(cargo.getPerson().getPublicData().getPhone());
            }
            case FROM -> {
                companyNameField.setText(cargo.getCompany().getName());
                companyCountryField.setText(cargo.getPerson().getOrigin().getCountry());
                companyCityField.setText(cargo.getPerson().getOrigin().getCity());
                companyEmailField.setText(cargo.getCompany().getPublicData().getEmail());
                companyPhoneField.setText(cargo.getCompany().getPublicData().getPhone());
            }
            case DEPARTURE -> {
                departureNameField.setText(cargo.getDepartureAirport().getName());
                departureCompanyField.setText(cargo.getDepartureAirport().getCompany().getName());
                departureCountryField.setText(cargo.getDepartureAirport().getOrigin().getCountry());
                departureCityField.setText(cargo.getDepartureAirport().getOrigin().getCity());
                departureArrivalField.setText(cargo.getArrivalTime().toString());
            }
            case PARAMETERS -> {
                parameterHeightField.setText(String.valueOf(cargo.getContent().getHeight()));
                parameterLengthField.setText(String.valueOf(cargo.getContent().getLength()));
                parameterWeightField.setText(String.valueOf(cargo.getContent().getWeight()));
                parameterWidthField.setText(String.valueOf(cargo.getContent().getWidth()));
            }
        }
    }
    protected void setEditableFields() {
        switch (cargoScene) {
            case MAIN -> {
                PageUtil.setEditField(mainArrivalField, isEdit);
                PageUtil.setEditField(mainTypeField, isEdit);
            }
            case CLIENT -> {
                PageUtil.setEditField(clientNameField, isEdit);
                PageUtil.setEditField(clientSurnameField, isEdit);
                PageUtil.setEditField(clientLastnameField, isEdit);
                PageUtil.setEditField(clientBirthdayField, isEdit);
                PageUtil.setEditField(clientGenderField, isEdit);
                PageUtil.setEditField(clientEmailField, isEdit);
                PageUtil.setEditField(clientPhoneField, isEdit);
            }
            case FROM -> {
                PageUtil.setEditField(companyNameField, isEdit);
                PageUtil.setEditField(companyCountryField, isEdit);
                PageUtil.setEditField(companyCityField, isEdit);
                PageUtil.setEditField(companyEmailField, isEdit);
                PageUtil.setEditField(companyPhoneField, isEdit);
            }
            case DEPARTURE -> {
                PageUtil.setEditField(departureNameField, isEdit);
                PageUtil.setEditField(departureArrivalField, isEdit);
                PageUtil.setEditField(departureCountryField, isEdit);
                PageUtil.setEditField(departureCityField, isEdit);
                PageUtil.setEditField(departureCompanyField, isEdit);
            }
            case PARAMETERS -> {
                PageUtil.setEditField(parameterHeightField, isEdit);
                PageUtil.setEditField(parameterLengthField, isEdit);
                PageUtil.setEditField(parameterWeightField, isEdit);
                PageUtil.setEditField(parameterWidthField, isEdit);
            }
        }
    }
    protected void setEmployeeByFieldValuesBeforeSwitch() {
        switch (cargoScene) {
            case MAIN -> {
                cargo.setArrivalTime(LocalDateTime.parse(mainArrivalField.getText()));
                cargo.setType(mainTypeField.getText());
            }
            case CLIENT -> {
                cargo.getPerson().setName(clientNameField.getText());
                cargo.getPerson().setSurname(clientSurnameField.getText());
                cargo.getPerson().setLastname(clientLastnameField.getText());
                cargo.getPerson().setBirthday(LocalDate.parse(clientBirthdayField.getText()));
                cargo.getPerson().setGender(clientGenderField.getText());
                cargo.getPerson().getPublicData().setEmail(clientEmailField.getText());
                cargo.getPerson().getPublicData().setPhone(clientPhoneField.getText());
            }
            case FROM -> {
                cargo.getCompany().setName(companyNameField.getText());
                cargo.getPerson().getOrigin().setCountry(companyCountryField.getText());
                cargo.getPerson().getOrigin().setCity(companyCityField.getText());
                cargo.getCompany().getPublicData().setEmail(companyEmailField.getText());
                cargo.getCompany().getPublicData().setPhone(companyPhoneField.getText());
            }
            case DEPARTURE -> {
                cargo.getDepartureAirport().setName(departureNameField.getText());
                cargo.getDepartureAirport().getCompany().setName(departureCompanyField.getText());
                cargo.getDepartureAirport().getOrigin().setCountry(departureCountryField.getText());
                cargo.getDepartureAirport().getOrigin().setCity(departureCityField.getText());
                cargo.setArrivalTime(LocalDateTime.parse(departureArrivalField.getText()));
            }
            case PARAMETERS -> {
                cargo.getContent().setHeight(Double.parseDouble(parameterHeightField.getText()));
                cargo.getContent().setLength(Double.parseDouble(parameterLengthField.getText()));
                cargo.getContent().setWeight(Double.parseDouble(parameterWeightField.getText()));
                cargo.getContent().setWidth(Double.parseDouble(parameterWidthField.getText()));
            }
        }
    }
}

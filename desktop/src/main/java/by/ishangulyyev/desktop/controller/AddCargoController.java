package by.ishangulyyev.desktop.controller;

import by.ishangulyyev.desktop.button.AcceptButton;
import by.ishangulyyev.desktop.button.BackButton;
import by.ishangulyyev.desktop.model.Airport;
import by.ishangulyyev.desktop.model.Cargo;
import by.ishangulyyev.desktop.model.CargoContent;
import by.ishangulyyev.desktop.model.Company;
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
import java.time.LocalDateTime;

import static by.ishangulyyev.desktop.controller.CargoController.CARGO_PAGE_URL;

public class AddCargoController implements BackButton, AcceptButton {
    private final RestApi<Cargo> restApi;
    @FXML
    private TextField airportCity;

    @FXML
    private TextField airportCompanyName;

    @FXML
    private TextField airportCompanyOrigin;

    @FXML
    private TextField airportCountry;

    @FXML
    private TextField airportEmail;

    @FXML
    private TextField airportName;

    @FXML
    private TextField airportPhone;

    @FXML
    private TextField clientBirthday;

    @FXML
    private TextField clientCity;

    @FXML
    private TextField clientCountry;

    @FXML
    private TextField clientEmail;

    @FXML
    private TextField clientGender;

    @FXML
    private TextField clientLastname;

    @FXML
    private TextField clientName;

    @FXML
    private TextField clientPhone;

    @FXML
    private TextField clientSurname;

    @FXML
    private TextField companyEmail;

    @FXML
    private TextField companyName;

    @FXML
    private TextField companyOrigin;

    @FXML
    private TextField companyPhone;

    @FXML
    private TextField paramHeight;

    @FXML
    private TextField paramLength;

    @FXML
    private TextField paramWeight;

    @FXML
    private TextField paramWidth;
    @FXML
    private TextField arrivalTime;
    @FXML
    private TextField type;

    public AddCargoController() {
        this.restApi = new RestApi<>();
    }

    @Override
    public void onBackClick(MouseEvent event) {
        SceneUtil.switchScene(event, "cargos.fxml");
    }

    @Override
    public void accept(ActionEvent event) {
        restApi.post(CARGO_PAGE_URL, getCargo(), Cargo.class);
        SceneUtil.switchScene(event, "cargos.fxml");
    }

    private Cargo getCargo() {
        return Cargo.builder()
                .arrivalTime(LocalDateTime.parse(arrivalTime.getText()))
                .type(type.getText())
                .person(
                        Person.builder()
                                .name(clientName.getText())
                                .surname(clientSurname.getText())
                                .lastname(clientLastname.getText())
                                .gender(clientGender.getText())
                                .birthday(LocalDate.parse(clientBirthday.getText()))
                                .publicData(
                                        PublicData.builder()
                                                .phone(clientPhone.getText())
                                                .email(clientEmail.getText())
                                                .build()
                                )
                                .origin(
                                        Origin.builder()
                                                .country(clientCountry.getText())
                                                .city(clientCity.getText())
                                                .build()
                                )
                                .build()
                )
                .company(
                        Company.builder()
                                .name(companyName.getText())
                                .originName(companyOrigin.getText())
                                .publicData(
                                        PublicData.builder()
                                                .email(companyEmail.getText())
                                                .phone(companyPhone.getText())
                                                .build()
                                )
                                .build()
                )
                .departureAirport(
                        Airport.builder()
                                .name(airportName.getText())
                                .origin(
                                        Origin.builder()
                                                .country(airportCountry.getText())
                                                .city(airportCity.getText())
                                                .build()
                                )
                                .company(
                                        Company.builder()
                                                .name(airportCompanyName.getText())
                                                .originName(airportCompanyOrigin.getText())
                                                .publicData(
                                                        PublicData.builder()
                                                                .email(airportEmail.getText())
                                                                .phone(airportPhone.getText())
                                                                .build()
                                                )
                                                .build()
                                )
                                .build()
                )
                .content(
                        CargoContent.builder()
                                .height(Double.parseDouble(paramHeight.getText()))
                                .length(Double.parseDouble(paramLength.getText()))
                                .width(Double.parseDouble(paramWidth.getText()))
                                .weight(Double.parseDouble(paramWeight.getText()))
                                .build()
                )
                .build();
    }
}

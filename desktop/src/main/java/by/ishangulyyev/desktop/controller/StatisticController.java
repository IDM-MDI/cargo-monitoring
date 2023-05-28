package by.ishangulyyev.desktop.controller;

import by.ishangulyyev.desktop.model.CargoStatistic;
import by.ishangulyyev.desktop.service.impl.RestApi;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class StatisticController extends PageHeader implements Initializable {
    private static final String STATISTIC_URL = "/api/v1/statistics/cargo";
    private final RestApi<CargoStatistic> restApi;
    @FXML
    private Text finishedCargo;
    @FXML
    private Text maxWeight;
    @FXML
    private Text smallestWeight;
    @FXML
    private Text popularCountry;
    @FXML
    private Text unpopularCountry;
    @FXML
    private Text shippedItem;

    public StatisticController() {
        this.restApi = new RestApi<>();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        CargoStatistic stat = restApi.getDTO(STATISTIC_URL, CargoStatistic.class);
        finishedCargo.setText(String.valueOf(stat.getFinished()));
        maxWeight.setText(String.valueOf(stat.getMaxWeight()));
        smallestWeight.setText(String.valueOf(stat.getMaxWeight()));
        popularCountry.setText(stat.getPopularCountry());
        unpopularCountry.setText(stat.getUnpopularCountry());
        shippedItem.setText(stat.getType());
    }
}

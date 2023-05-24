package by.ishangulyyev.cargomonitoring.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import by.ishangulyyev.cargomonitoring.R;
import by.ishangulyyev.cargomonitoring.model.Cargo;
import by.ishangulyyev.cargomonitoring.service.WebGet;
import by.ishangulyyev.cargomonitoring.service.WebPatch;
import by.ishangulyyev.cargomonitoring.service.impl.RestApi;

public class CargoByIDActivity extends AppCompatActivity {
    public static final String CARGO_URL = "http://192.168.0.102:8080/api/v1/cargos";
    public static final String METER = " m";
    public static final String KG = " kg";
    private final WebGet<Cargo> webGet;
    private final WebPatch<Cargo> webPatch;
    private String id;
    private String login;
    private String token;
    private Cargo cargo;
    private TextView length;
    private TextView height;
    private TextView width;
    private TextView weight;
    private TextView fromCountry;
    private TextView fromCity;
    private TextView toCountry;
    private TextView toCity;
    private AppCompatButton ok;
    private AppCompatButton report;

    public CargoByIDActivity() {
        webGet = new RestApi<>();
        webPatch = new RestApi<>();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cargo_by_id);
        init();
        loadCargo();
    }
    private void init() {
        Bundle extras = getIntent().getExtras();
        login = extras.getString("login");
        token = extras.getString("token");
        id = extras.getString("id");
        length = findViewById(R.id.lengthValue);
        height = findViewById(R.id.heightValue);
        width = findViewById(R.id.widthValue);
        weight = findViewById(R.id.weightValue);
        fromCountry = findViewById(R.id.fromCountryValue);
        fromCity = findViewById(R.id.fromCityValue);
        toCountry = findViewById(R.id.departureCountryValue);
        toCity = findViewById(R.id.departureCityValue);
        ok = findViewById(R.id.okReportButton);
        report = findViewById(R.id.backButton);
        ok.setOnClickListener(this::okClick);
        report.setOnClickListener(this::reportClick);
    };
    private void loadCargo() {
        ExecutorService service = Executors.newSingleThreadExecutor();
        Handler handler = new Handler();
        service.execute(() -> {
            this.cargo = webGet.getDTO(CARGO_URL, id, token, Cargo.class);
            Runnable runnable = () -> {
                length.setText(cargo.getContent().getLength() + METER);
                height.setText(cargo.getContent().getHeight() + METER);
                width.setText(cargo.getContent().getWidth() + METER);
                weight.setText(cargo.getContent().getWeight() + KG);
                fromCountry.setText(cargo.getPerson().getOrigin().getCountry());
                fromCity.setText(cargo.getPerson().getOrigin().getCity());
                toCountry.setText(cargo.getDepartureAirport().getOrigin().getCountry());
                toCity.setText(cargo.getDepartureAirport().getOrigin().getCity());
            };
            runOnUiThread(runnable);
            handler.post(runnable);
        });
    }
    private void okClick(View view) {
        ExecutorService service = Executors.newSingleThreadExecutor();
        service.execute(() -> {
            webPatch.patch(CARGO_URL + "/" + id + "/accept", token);
            Intent intent = new Intent(this, MenuActivity.class);
            intent.putExtra("login", login);
            intent.putExtra("token", token);
            startActivity(intent);
        });
    }
    private void reportClick(View view) {
        Intent intent = new Intent(this, CargoByIDReportActivity.class);
        intent.putExtra("login", login);
        intent.putExtra("token", token);
        intent.putExtra("id", id);
        startActivity(intent);
    }
}

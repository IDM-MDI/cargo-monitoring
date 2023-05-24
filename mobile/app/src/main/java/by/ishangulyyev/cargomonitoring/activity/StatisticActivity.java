package by.ishangulyyev.cargomonitoring.activity;

import static by.ishangulyyev.cargomonitoring.activity.CargoByIDActivity.KG;

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
import by.ishangulyyev.cargomonitoring.model.CargoStatistic;
import by.ishangulyyev.cargomonitoring.service.WebGet;
import by.ishangulyyev.cargomonitoring.service.impl.RestApi;

public class StatisticActivity extends AppCompatActivity {
    private static final String STATISTIC_URL = "http://192.168.0.102:8080/api/v1/statistics/cargo";
    private final WebGet<CargoStatistic> webGet;
    private String login;
    private String token;
    private CargoStatistic statistic;
    private TextView acceptedValue;
    private TextView shippedValue;
    private TextView popularValue;
    private TextView unpopularValue;
    private TextView maxValue;
    private TextView minValue;
    private AppCompatButton menu;

    public StatisticActivity() {
        this.webGet = new RestApi<>();
    }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistic);
        init();
        loadStatistic();
    }

    private void init() {
        Bundle extras = getIntent().getExtras();
        login = extras.getString("login");
        token = extras.getString("token");
        menu = findViewById(R.id.menuStatisticButton);
        acceptedValue = findViewById(R.id.acceptedValue);
        shippedValue = findViewById(R.id.shippedValue);
        popularValue = findViewById(R.id.popularValue);
        unpopularValue = findViewById(R.id.unpopularValue);
        maxValue = findViewById(R.id.maxValue);
        minValue = findViewById(R.id.minValue);

        menu.setOnClickListener(this::menuClick);
    }

    private void menuClick(View view) {
        Intent intent = new Intent(this, MenuActivity.class);
        intent.putExtra("login", login);
        intent.putExtra("token", token);
        startActivity(intent);
    }

    private void loadStatistic() {
        ExecutorService service = Executors.newSingleThreadExecutor();
        Handler handler = new Handler();
        service.execute(() -> {
            this.statistic = webGet.getDTO(STATISTIC_URL, token, CargoStatistic.class);
            Runnable runnable = () -> {
                acceptedValue.setText(String.valueOf(statistic.getFinished()));
                shippedValue.setText(statistic.getType());
                popularValue.setText(statistic.getPopularCountry());
                unpopularValue.setText(statistic.getUnpopularCountry());
                maxValue.setText(statistic.getMaxWeight() + KG);
                minValue.setText(statistic.getMinWeight() + KG);
            };
            runOnUiThread(runnable);
            handler.post(runnable);
        });
    }
}

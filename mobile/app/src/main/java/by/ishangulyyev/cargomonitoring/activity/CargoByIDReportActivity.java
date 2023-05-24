package by.ishangulyyev.cargomonitoring.activity;

import static by.ishangulyyev.cargomonitoring.activity.CargoByIDActivity.CARGO_URL;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import by.ishangulyyev.cargomonitoring.R;
import by.ishangulyyev.cargomonitoring.model.Cargo;
import by.ishangulyyev.cargomonitoring.service.WebPatch;
import by.ishangulyyev.cargomonitoring.service.impl.RestApi;

public class CargoByIDReportActivity extends AppCompatActivity {
    private final WebPatch<Cargo> webPatch;
    private String login;
    private String token;
    private String id;

    private EditText reason;
    private TextView idValue;
    private AppCompatButton okReportButton;
    private AppCompatButton backButton;

    public CargoByIDReportActivity() {
        this.webPatch = new RestApi<>();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cargo_by_id_report);
        init();
    }

    private void init() {
        Bundle extras = getIntent().getExtras();
        login = extras.getString("login");
        token = extras.getString("token");
        id = extras.getString("id");
        reason = findViewById(R.id.reason);
        idValue = findViewById(R.id.idValue);
        idValue.setText(id);
        okReportButton = findViewById(R.id.okReportButton);
        backButton = findViewById(R.id.backButton);
        okReportButton.setOnClickListener(this::okClick);
        backButton.setOnClickListener(this::backClick);
    }

    private void okClick(View view) {
        ExecutorService service = Executors.newSingleThreadExecutor();
        service.execute(() -> {
            webPatch.patch(CARGO_URL + "/" + id + "/decline?reason=" + reason.getText().toString(), token);
            Intent intent = new Intent(this, MenuActivity.class);
            intent.putExtra("login", login);
            intent.putExtra("token", token);
            startActivity(intent);
        });
    }
    private void backClick(View view) {
        Intent intent = new Intent(this, CargoByIDActivity.class);
        intent.putExtra("login", login);
        intent.putExtra("token", token);
        intent.putExtra("id", id);
        startActivity(intent);
    }
}

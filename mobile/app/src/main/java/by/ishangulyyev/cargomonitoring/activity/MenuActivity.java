package by.ishangulyyev.cargomonitoring.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import by.ishangulyyev.cargomonitoring.R;
import by.ishangulyyev.cargomonitoring.model.Authentication;
import by.ishangulyyev.cargomonitoring.model.Employee;
import by.ishangulyyev.cargomonitoring.service.WebGet;
import by.ishangulyyev.cargomonitoring.service.impl.RestApi;

public class MenuActivity extends AppCompatActivity {
    private static final String EMPLOYEE_LOGIN_URL = "http://192.168.0.102:8080/api/v1/employees/login";
    private final WebGet<Employee> webGet;
    private Employee employee;
    private AppCompatButton personButton;
    private AppCompatButton statisticButton;
    private TextView nameSurname;
    private ImageView scan;
    private String login;
    private String token;

    public MenuActivity() {
        webGet = new RestApi<>();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        init();
        nameSurname = findViewById(R.id.navigatorText);
        personButton = findViewById(R.id.personButton);
        statisticButton = findViewById(R.id.statisticsButton);
        scan = findViewById(R.id.scanImage);
        setName(nameSurname);
        scan.setOnClickListener(this::onClick);
        personButton.setOnClickListener(this::onPersonClick);
        statisticButton.setOnClickListener(this::onStatisticClick);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if (result != null) {
            if (result.getContents() != null) {
                String qrCodeId = result.getContents();
                Intent intent = new Intent(this, CargoByIDActivity.class);
                intent.putExtra("login", login);
                intent.putExtra("token", token);
                intent.putExtra("id", qrCodeId);
                startActivity(intent);
            }
        }
    }

    private void setName(TextView textView) {
        ExecutorService service = Executors.newSingleThreadExecutor();
        Handler handler = new Handler();
        service.execute(() -> {
            this.employee = webGet.getDTO(EMPLOYEE_LOGIN_URL, login, token, Employee.class);
            Runnable runnable = () -> textView.setText(employee.getPerson().getName() + " " + employee.getPerson().getSurname());
            runOnUiThread(runnable);
            handler.post(runnable);
        });
    }
    private void onClick(View view) {
        IntentIntegrator integrator = new IntentIntegrator(MenuActivity.this);
        integrator.setPrompt("Scan a QR code");
        integrator.setOrientationLocked(false);
        integrator.setBeepEnabled(false);
        integrator.initiateScan();
    }

    private void onPersonClick(View view) {
        if(Objects.nonNull(employee)) {
            Intent intent = new Intent(this, PersonActivity.class);
            intent.putExtra("login", login);
            intent.putExtra("token", token);
            intent.putExtra("location", employee.getPerson().getOrigin().getCountry() + ", " + employee.getPerson().getOrigin().getCity());
            intent.putExtra("email", employee.getPerson().getPublicData().getEmail());
            intent.putExtra("phone", employee.getPerson().getPublicData().getPhone());
            intent.putExtra("birthday", employee.getPerson().getBirthday().toString());
            intent.putExtra("name", employee.getPerson().getName() + " " + employee.getPerson().getSurname());
            startActivity(intent);
        }
    }
    private void onStatisticClick(View view) {
        Intent intent = new Intent(this, StatisticActivity.class);
        intent.putExtra("login", login);
        intent.putExtra("token", token);
        startActivity(intent);
    }

    private void init() {
        Bundle extras = getIntent().getExtras();
        login = extras.getString("login");
        token = extras.getString("token");
    }
}

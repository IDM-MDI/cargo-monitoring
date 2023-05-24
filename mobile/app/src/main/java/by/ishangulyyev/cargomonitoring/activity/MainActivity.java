package by.ishangulyyev.cargomonitoring.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import by.ishangulyyev.cargomonitoring.R;
import by.ishangulyyev.cargomonitoring.model.Authentication;
import by.ishangulyyev.cargomonitoring.service.WebPost;
import by.ishangulyyev.cargomonitoring.service.impl.RestApi;

public class MainActivity extends AppCompatActivity {
    private static final String AUTHENTICATION_URL = "http://192.168.0.102:8080/api/v1/user/login";
    private final WebPost<Authentication> webPost;
    private EditText loginField;
    private EditText passwordField;
    private AppCompatButton submitButton;

    public MainActivity() {
        this.webPost = new RestApi<>();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loginField = findViewById(R.id.loginField);
        passwordField = findViewById(R.id.passwordField);
        submitButton = findViewById(R.id.submitButton);
        submitButton.setOnClickListener(this::onClick);
    }

    private void onClick(View view) {
        String login = loginField.getText().toString();
        String password = passwordField.getText().toString();
        ExecutorService service = Executors.newSingleThreadExecutor();
        service.execute(() -> {
            Authentication post = webPost.post(
                    AUTHENTICATION_URL,
                    null,
                    Authentication.builder()
                            .login(login)
                            .password(password)
                            .build(),
                    Authentication.class);
            Intent intent = new Intent(this, MenuActivity.class);
            intent.putExtra("login", login);
            intent.putExtra("token", post.getToken());
            startActivity(intent);
        });
    }
}
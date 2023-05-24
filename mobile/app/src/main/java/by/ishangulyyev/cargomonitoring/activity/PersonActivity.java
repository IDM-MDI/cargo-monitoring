package by.ishangulyyev.cargomonitoring.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import by.ishangulyyev.cargomonitoring.R;

public class PersonActivity extends AppCompatActivity {
    private String login;
    private String token;
    private String email;
    private String phone;
    private String location;
    private String birthday;
    private String name;
    private TextView navigatorText;
    private TextView birthdayPerson;
    private AppCompatButton menuPersonButton;
    private EditText addressPerson;
    private EditText phonePerson;
    private EditText emailPerson;
    private EditText loginPerson;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person);
        init();
    }
    private void init() {
        Bundle extras = getIntent().getExtras();
        login = extras.getString("login");
        token = extras.getString("token");
        email = extras.getString("email");
        phone = extras.getString("phone");
        location = extras.getString("location");
        birthday = extras.getString("birthday");
        name = extras.getString("name");

        navigatorText = findViewById(R.id.navigatorText);
        birthdayPerson = findViewById(R.id.birthdayPerson);
        menuPersonButton = findViewById(R.id.menuPersonButton);
        addressPerson = findViewById(R.id.addressPerson);
        phonePerson = findViewById(R.id.phonePerson);
        emailPerson = findViewById(R.id.emailPerson);
        loginPerson = findViewById(R.id.loginPerson);

        navigatorText.setText(name);
        birthdayPerson.setText(birthday);

        setTextToField(addressPerson, location);
        setTextToField(phonePerson, phone);
        setTextToField(emailPerson, email);
        setTextToField(loginPerson, login);

        menuPersonButton.setOnClickListener(this::menuClick);
    }
    private void menuClick(View view) {
        Intent intent = new Intent(this, MenuActivity.class);
        intent.putExtra("login", login);
        intent.putExtra("token", token);
        startActivity(intent);
    }
    private void setTextToField(EditText field, String text) {
        field.setText(text);
        field.setEnabled(false);
    }
}

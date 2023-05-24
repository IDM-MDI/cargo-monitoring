package by.ishangulyyev.cargomonitoring.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.apache.http.HttpHeaders;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Objects;

import by.ishangulyyev.cargomonitoring.model.Authentication;
import by.ishangulyyev.cargomonitoring.model.Cargo;
import by.ishangulyyev.cargomonitoring.model.CargoContent;
import by.ishangulyyev.cargomonitoring.model.Employee;
import by.ishangulyyev.cargomonitoring.model.Person;
import by.ishangulyyev.cargomonitoring.serializer.AuthenticationSerializer;
import by.ishangulyyev.cargomonitoring.serializer.CargoContentSerializer;
import by.ishangulyyev.cargomonitoring.serializer.CargoSerializer;
import by.ishangulyyev.cargomonitoring.serializer.EmployeeSerializer;
import by.ishangulyyev.cargomonitoring.serializer.PersonSerializer;
import lombok.SneakyThrows;
import lombok.experimental.UtilityClass;

@UtilityClass
public class RequestUtil {
    @SneakyThrows
    public static <T> T sendRequest(String url, String method, String token, T entity, Class<T> tClass) {
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(Cargo.class, new CargoSerializer())
                .registerTypeAdapter(CargoContent.class, new CargoContentSerializer())
                .registerTypeAdapter(Employee.class, new EmployeeSerializer())
                .registerTypeAdapter(Authentication.class, new AuthenticationSerializer())
                .registerTypeAdapter(Person.class, new PersonSerializer())
                .create();
        URL uri = new URL(url);
        String json = gson.toJson(entity);
        HttpURLConnection connection = (HttpURLConnection) uri.openConnection();
        connection.setRequestMethod(method);
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setDoOutput(true);
        setToken(connection, token);
        try(OutputStream outputStream = connection.getOutputStream()) {
            outputStream.write(json.getBytes());
            outputStream.flush();
        }
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
            return gson.fromJson(getResponseString(reader), tClass);
        }
    }
    @SneakyThrows
    public static <T> T sendRequest(String url, String method, String token, Class<T> tClass) {
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(Cargo.class, new CargoSerializer())
                .registerTypeAdapter(CargoContent.class, new CargoContentSerializer())
                .registerTypeAdapter(Employee.class, new EmployeeSerializer())
                .registerTypeAdapter(Authentication.class, new AuthenticationSerializer())
                .registerTypeAdapter(Person.class, new PersonSerializer())
                .create();
        URL uri = new URL(url);
        HttpURLConnection connection = (HttpURLConnection) uri.openConnection();
        connection.setRequestMethod(method);
        setToken(connection, token);
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
            return gson.fromJson(getResponseString(reader), tClass);
        }
    }
    @SneakyThrows
    public static int sendRequest(String url, String method, String token) {
        URL uri = new URL(url);
        HttpURLConnection connection = (HttpURLConnection) uri.openConnection();
        connection.setRequestMethod(method);
        setToken(connection, token);
        int responseCode = connection.getResponseCode();
        connection.disconnect();
        return responseCode;
    }
    @SneakyThrows
    private static String getResponseString(BufferedReader reader) {
        StringBuilder buffer = new StringBuilder();
        int read;
        char[] chars = new char[1024];
        while ((read = reader.read(chars)) != -1)
            buffer.append(chars, 0, read);
        return buffer.toString();
    }
    private static void setToken(HttpURLConnection connection, String token) {
        if(Objects.isNull(token) || token.isBlank()) {
            return;
        }
        System.out.println(token);
        connection.setRequestProperty("Authorization", "Bearer " + token);
    }
}

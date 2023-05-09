package by.ishangulyyev.desktop.util;

import by.ishangulyyev.desktop.model.AuthenticationRequest;
import by.ishangulyyev.desktop.model.Employee;
import by.ishangulyyev.desktop.model.Person;
import by.ishangulyyev.desktop.service.AuthenticationSerializer;
import by.ishangulyyev.desktop.service.EmployeeSerializer;
import by.ishangulyyev.desktop.service.PersonSerializer;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.SneakyThrows;
import lombok.experimental.UtilityClass;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

@UtilityClass
public class UrlUtil {
    @SneakyThrows
    public String readUrl(String urlString) {
        URL url = new URL(urlString);
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()))) {
            return getResponseString(reader);
        }
    }

    @SneakyThrows
    public static <T> T put(String url, T entity, Class<T> tClass) {
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(Employee.class, new EmployeeSerializer())
                .registerTypeAdapter(AuthenticationRequest.class, new AuthenticationSerializer())
                .registerTypeAdapter(Person.class, new PersonSerializer())
                .create();
        String json = gson.toJson(entity);
        URL uri = new URL(url);
        HttpURLConnection connection = (HttpURLConnection) uri.openConnection();
        connection.setRequestMethod("PUT");
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setDoOutput(true);
        try(OutputStream outputStream = connection.getOutputStream()) {
            outputStream.write(json.getBytes());
            outputStream.flush();
        }
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
            return gson.fromJson(getResponseString(reader), tClass);
        }
    }

    @SneakyThrows
    public int delete(String uri) {
        URL url = new URL(uri);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("DELETE");
        int responseCode = connection.getResponseCode();
        connection.disconnect();
        return responseCode;
    }

    private static String getResponseString(BufferedReader reader) throws IOException {
        StringBuilder buffer = new StringBuilder();
        int read;
        char[] chars = new char[1024];
        while ((read = reader.read(chars)) != -1)
            buffer.append(chars, 0, read);
        return buffer.toString();
    }
}

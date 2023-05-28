package by.ishangulyyev.desktop.util;

import by.ishangulyyev.desktop.model.Authentication;
import by.ishangulyyev.desktop.model.Cargo;
import by.ishangulyyev.desktop.model.CargoContent;
import by.ishangulyyev.desktop.model.Employee;
import by.ishangulyyev.desktop.model.Person;
import by.ishangulyyev.desktop.serializer.AuthenticationSerializer;
import by.ishangulyyev.desktop.serializer.CargoContentSerializer;
import by.ishangulyyev.desktop.serializer.CargoSerializer;
import by.ishangulyyev.desktop.serializer.EmployeeSerializer;
import by.ishangulyyev.desktop.serializer.PersonSerializer;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.SneakyThrows;
import lombok.experimental.UtilityClass;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.util.Objects;

@UtilityClass
public class RequestUtil {
    @SneakyThrows
    public static <T> T sendRequest(HttpEntityEnclosingRequestBase method, T entity, Class<T> tClass) {
        try(CloseableHttpClient httpClient = HttpClients.createDefault()) {
            Gson gson = new GsonBuilder()
                    .registerTypeAdapter(Cargo.class, new CargoSerializer())
                    .registerTypeAdapter(CargoContent.class, new CargoContentSerializer())
                    .registerTypeAdapter(Employee.class, new EmployeeSerializer())
                    .registerTypeAdapter(Authentication.class, new AuthenticationSerializer())
                    .registerTypeAdapter(Person.class, new PersonSerializer())
                    .create();
            setToken(method);
            method.setHeader(HttpHeaders.CONTENT_TYPE, ContentType.APPLICATION_JSON.getMimeType());
            method.setEntity(new StringEntity(gson.toJson(entity)));
            CloseableHttpResponse response = httpClient.execute(method);
            HttpEntity httpEntity = response.getEntity();
            return gson.fromJson(EntityUtils.toString(httpEntity), tClass);
        }
    }
    @SneakyThrows
    public static <T> T sendRequest(HttpRequestBase method, Class<T> tClass) {
        try(CloseableHttpClient httpClient = HttpClients.createDefault()) {
            Gson gson = new GsonBuilder()
                    .registerTypeAdapter(Cargo.class, new CargoSerializer())
                    .registerTypeAdapter(CargoContent.class, new CargoContentSerializer())
                    .registerTypeAdapter(Employee.class, new EmployeeSerializer())
                    .registerTypeAdapter(Authentication.class, new AuthenticationSerializer())
                    .registerTypeAdapter(Person.class, new PersonSerializer())
                    .create();
            setToken(method);
            CloseableHttpResponse response = httpClient.execute(method);
            HttpEntity entity = response.getEntity();
            return gson.fromJson(EntityUtils.toString(entity), tClass);
        }
    }
    @SneakyThrows
    public static int sendRequest(HttpRequestBase method) {
        try(CloseableHttpClient httpClient = HttpClients.createDefault()) {
            setToken(method);
            return httpClient.execute(method)
                    .getStatusLine()
                    .getStatusCode();
        }
    }
    private static void setToken(HttpRequestBase method) {
        String token = PropertiesUtil.getPropertyValue("token");
        if(Objects.isNull(token) || token.isBlank()) {
            return;
        }
        method.setHeader(HttpHeaders.AUTHORIZATION, "Bearer " + token);
    }
}

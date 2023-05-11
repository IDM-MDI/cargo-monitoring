package by.ishangulyyev.desktop.util;

import by.ishangulyyev.desktop.model.AuthenticationRequest;
import by.ishangulyyev.desktop.model.Cargo;
import by.ishangulyyev.desktop.model.CargoContent;
import by.ishangulyyev.desktop.model.Employee;
import by.ishangulyyev.desktop.model.Person;
import by.ishangulyyev.desktop.service.AuthenticationSerializer;
import by.ishangulyyev.desktop.service.CargoContentSerializer;
import by.ishangulyyev.desktop.service.CargoSerializer;
import by.ishangulyyev.desktop.service.EmployeeSerializer;
import by.ishangulyyev.desktop.service.PersonSerializer;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.SneakyThrows;
import lombok.experimental.UtilityClass;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPatch;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

@UtilityClass
public class UrlUtil {
    @SneakyThrows
    public <T> T get(String url, Class<T> tClass) {
        return sendRequest(new HttpGet(url), tClass);
    }

    @SneakyThrows
    public static <T> T put(String url, T entity, Class<T> tClass) {
        return sendRequest(
                new HttpPut(url),
                entity,
                tClass
        );
    }
    @SneakyThrows
    public static <T> T post(String url, T entity, Class<T> tClass) {
        return sendRequest(
                new HttpPost(url),
                entity,
                tClass
        );
    }
    public static <T> T patch(String url, Class<T> tClass) {
        return sendRequest(new HttpPatch(url), tClass);
    }
    @SneakyThrows
    public int delete(String uri) {
        return sendRequest(new HttpDelete(uri));
    }

    @SneakyThrows
    private static <T> T sendRequest(HttpEntityEnclosingRequestBase method, T entity, Class<T> tClass) {
        try(CloseableHttpClient httpClient = HttpClients.createDefault()) {
            Gson gson = new GsonBuilder()
                    .registerTypeAdapter(Cargo.class, new CargoSerializer())
                    .registerTypeAdapter(CargoContent.class, new CargoContentSerializer())
                    .registerTypeAdapter(Employee.class, new EmployeeSerializer())
                    .registerTypeAdapter(AuthenticationRequest.class, new AuthenticationSerializer())
                    .registerTypeAdapter(Person.class, new PersonSerializer())
                    .create();
            method.setEntity(new StringEntity(gson.toJson(entity)));
            CloseableHttpResponse response = httpClient.execute(method);
            HttpEntity httpEntity = response.getEntity();
            return gson.fromJson(EntityUtils.toString(httpEntity), tClass);
        }
    }
    @SneakyThrows
    private static <T> T sendRequest(HttpRequestBase method, Class<T> tClass) {
        try(CloseableHttpClient httpClient = HttpClients.createDefault()) {
            Gson gson = new GsonBuilder()
                    .registerTypeAdapter(Cargo.class, new CargoSerializer())
                    .registerTypeAdapter(CargoContent.class, new CargoContentSerializer())
                    .registerTypeAdapter(Employee.class, new EmployeeSerializer())
                    .registerTypeAdapter(AuthenticationRequest.class, new AuthenticationSerializer())
                    .registerTypeAdapter(Person.class, new PersonSerializer())
                    .create();
            CloseableHttpResponse response = httpClient.execute(method);
            HttpEntity entity = response.getEntity();
            return gson.fromJson(EntityUtils.toString(entity), tClass);
        }
    }
    @SneakyThrows
    private static int sendRequest(HttpRequestBase method) {
        try(CloseableHttpClient httpClient = HttpClients.createDefault()) {
            return httpClient.execute(method)
                    .getStatusLine()
                    .getStatusCode();
        }
    }
}

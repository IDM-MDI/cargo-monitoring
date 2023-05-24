package by.ishangulyyev.cargomonitoring.util;

import static by.ishangulyyev.cargomonitoring.util.RequestUtil.sendRequest;

import lombok.SneakyThrows;
import lombok.experimental.UtilityClass;


@UtilityClass
public class UrlUtil {
    private static final String GET = "GET";
    private static final String POST = "POST";
    private static final String DELETE = "DELETE";
    private static final String PATCH = "PATCH";
    private static final String PUT = "PUT";
    @SneakyThrows
    public <T> T get(String url, String token, Class<T> tClass) {
        return sendRequest(url, GET, token, tClass);
    }

    @SneakyThrows
    public static <T> T put(String url, String token, T entity, Class<T> tClass) {
        return sendRequest(
                url,
                PUT,
                token,
                entity,
                tClass
        );
    }
    @SneakyThrows
    public static <T> T post(String url, String token, T entity, Class<T> tClass) {
        return sendRequest(
                url,
                POST,
                token,
                entity,
                tClass
        );
    }
    public static int patch(String url, String token) {
        return sendRequest(url, PATCH, token);
    }
    @SneakyThrows
    public int delete(String uri, String token) {
        return sendRequest(uri, DELETE, token);
    }
}

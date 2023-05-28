package by.ishangulyyev.desktop.util;

import lombok.SneakyThrows;
import lombok.experimental.UtilityClass;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPatch;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;

import static by.ishangulyyev.desktop.util.RequestUtil.sendRequest;

@UtilityClass
public class UrlUtil {
    private static final String URL_PREFIX = "http://";
    private static final String PORT = "8080";
    @SneakyThrows
    public <T> T get(String url, Class<T> tClass) {
        return sendRequest(new HttpGet(fixURL(url)), tClass);
    }

    @SneakyThrows
    public static <T> T put(String url, T entity, Class<T> tClass) {
        return sendRequest(
                new HttpPut(fixURL(url)),
                entity,
                tClass
        );
    }
    @SneakyThrows
    public static <T> T post(String url, T entity, Class<T> tClass) {
        return sendRequest(
                new HttpPost(fixURL(url)),
                entity,
                tClass
        );
    }
    public static <T> T patch(String url, Class<T> tClass) {
        return sendRequest(new HttpPatch(fixURL(url)), tClass);
    }
    @SneakyThrows
    public int delete(String uri) {
        return sendRequest(new HttpDelete(fixURL(uri)));
    }

    private static String fixURL(String url) {
        return URL_PREFIX + PropertiesUtil.getPropertyValue("ip") + ":" + PORT + url;
    }
}

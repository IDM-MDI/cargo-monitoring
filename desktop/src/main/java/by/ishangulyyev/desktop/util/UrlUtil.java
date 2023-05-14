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
}

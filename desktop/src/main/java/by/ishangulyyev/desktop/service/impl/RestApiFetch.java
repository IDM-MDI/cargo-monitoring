package by.ishangulyyev.desktop.service.impl;

import by.ishangulyyev.desktop.model.Page;
import by.ishangulyyev.desktop.service.LocalDateAdapter;
import by.ishangulyyev.desktop.service.WebFetch;
import by.ishangulyyev.desktop.util.UrlUtil;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import lombok.SneakyThrows;

import java.time.LocalDate;

public class RestApiFetch<T> implements WebFetch<T> {
    private static final String URL_PAGE_PARSE = "?page=%d&size=%d&filter=%s&direction=%s";
    @SneakyThrows
    @Override
    public Page getDTO(String url, int page, int size, String filter, String direction) {
        return new Gson()
                .fromJson(
                        UrlUtil.readUrl(url + String.format(URL_PAGE_PARSE,page, size, filter, direction)),
                        new TypeToken<Page>(){}.getType()
                );
    }

    @SneakyThrows
    @Override
    public T getDTO(String url, String id, Class<T> tClass) {
        return getDTO(url + "/" + id, tClass);
    }

    @SneakyThrows
    @Override
    public T getDTO(String url, Class<T> tClass) {
        return new GsonBuilder()
                .registerTypeAdapter(LocalDate.class, new LocalDateAdapter())
                .create()
                .fromJson(
                        UrlUtil.readUrl(url),
                        tClass
                );
    }
}

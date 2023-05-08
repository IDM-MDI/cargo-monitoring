package by.ishangulyyev.desktop.service.impl;

import by.ishangulyyev.desktop.model.Page;
import by.ishangulyyev.desktop.service.WebFetch;
import by.ishangulyyev.desktop.util.UrlUtil;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import lombok.SneakyThrows;

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
    public T getDTO(String url, String id) {
        return new Gson()
                .fromJson(
                        UrlUtil.readUrl(url + "/" + id),
                        new TypeToken<T>(){}.getType()
                );
    }

    @SneakyThrows
    @Override
    public T getDTO(String url) {
        return new Gson()
                .fromJson(
                        UrlUtil.readUrl(url),
                        new TypeToken<T>(){}.getType()
                );
    }
}

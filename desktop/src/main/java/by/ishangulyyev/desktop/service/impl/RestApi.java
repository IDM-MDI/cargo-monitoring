package by.ishangulyyev.desktop.service.impl;

import by.ishangulyyev.desktop.model.Page;
import by.ishangulyyev.desktop.service.WebDelete;
import by.ishangulyyev.desktop.service.WebGet;
import by.ishangulyyev.desktop.service.WebPatch;
import by.ishangulyyev.desktop.service.WebPost;
import by.ishangulyyev.desktop.service.WebPut;
import by.ishangulyyev.desktop.util.UrlUtil;
import lombok.SneakyThrows;

public class RestApi<T> implements WebGet<T>, WebPut<T>, WebDelete, WebPost<T>, WebPatch<T> {
    private static final String URL_PAGE_PARSE = "?page=%d&size=%d&filter=%s&direction=%s";
    @SneakyThrows
    @Override
    public Page getDTO(String url, int page, int size, String filter, String direction) {
        return UrlUtil.get(url + String.format(URL_PAGE_PARSE,page, size, filter, direction), Page.class);
    }

    @SneakyThrows
    @Override
    public T getDTO(String url, String id, Class<T> tClass) {
        return getDTO(url + "/" + id, tClass);
    }

    @SneakyThrows
    @Override
    public T getDTO(String url, Class<T> tClass) {
        return UrlUtil.get(url, tClass);
    }

    @Override
    public int delete(String url, String id) {
        return UrlUtil.delete(url + "/" + id);
    }

    @Override
    public T put(String url, String id, T entity, Class<T> tClass) {
        return UrlUtil.put(url + "/" + id, entity, tClass);
    }

    @Override
    public T post(String url, T entity, Class<T> tClass) {
        return UrlUtil.post(url, entity, tClass);
    }

    @Override
    public T patch(String url, String id, String params, Class<T> tClass) {
        return UrlUtil.patch(url + "/" + id + "?" + params, tClass);
    }

    @Override
    public T patch(String url, Class<T> tClass) {
        return UrlUtil.patch(url, tClass);
    }
}

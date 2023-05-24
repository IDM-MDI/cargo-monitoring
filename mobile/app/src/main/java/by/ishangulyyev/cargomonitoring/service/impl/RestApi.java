package by.ishangulyyev.cargomonitoring.service.impl;

import android.annotation.SuppressLint;

import by.ishangulyyev.cargomonitoring.model.Page;
import by.ishangulyyev.cargomonitoring.service.WebGet;
import by.ishangulyyev.cargomonitoring.service.WebPatch;
import by.ishangulyyev.cargomonitoring.service.WebPost;
import by.ishangulyyev.cargomonitoring.util.UrlUtil;
import lombok.SneakyThrows;

public class RestApi<T> implements WebPost<T>, WebGet<T>, WebPatch<T> {
    private static final String URL_PAGE_PARSE = "?page=%d&size=%d&filter=%s&direction=%s";

    @SuppressLint("DefaultLocale")
    @SneakyThrows
    @Override
    public Page getDTO(String url, int page, int size, String filter, String direction, String token) {
        return UrlUtil.get(url + String.format(URL_PAGE_PARSE,page, size, filter, direction), token, Page.class);
    }
    @SneakyThrows
    @Override
    public T getDTO(String url, String id, String token, Class<T> tClass) {
        return getDTO(url + "/" + id, token , tClass);
    }
    @SneakyThrows
    @Override
    public T getDTO(String url, String token, Class<T> tClass) {
        return UrlUtil.get(url, token, tClass);
    }

    @Override
    public T post(String url, String token, T entity, Class<T> tClass) {
        return UrlUtil.post(url, token, entity, tClass);
    }

    @Override
    public int patch(String url, String id, String params, String token) {
        return UrlUtil.patch(url + "/" + id + "?" + params, token);
    }

    @Override
    public int patch(String url, String token) {
        return UrlUtil.patch(url, token);
    }
}

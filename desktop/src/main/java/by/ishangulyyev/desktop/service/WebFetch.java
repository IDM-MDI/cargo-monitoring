package by.ishangulyyev.desktop.service;

import by.ishangulyyev.desktop.model.Page;

public interface WebFetch<T> {
    Page getDTO(String url, int page, int size, String filter, String direction);
    T getDTO(String url, String id, Class<T> tClass);
    T getDTO(String url, Class<T> tClass);
}

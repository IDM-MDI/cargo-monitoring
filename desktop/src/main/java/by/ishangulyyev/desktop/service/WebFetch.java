package by.ishangulyyev.desktop.service;

import by.ishangulyyev.desktop.model.Page;

public interface WebFetch<T> {
    Page getDTO(String url, int page, int size, String filter, String direction);
    T getDTO(String url, String id);
    T getDTO(String url);
}

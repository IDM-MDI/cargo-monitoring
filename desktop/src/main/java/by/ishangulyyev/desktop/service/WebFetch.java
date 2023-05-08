package by.ishangulyyev.desktop.service;

import java.util.List;

public interface WebFetch<T> {
    List<T> getDTO(String url, int page, int size, String filter, String direction);
    T getDTO(String url, String id);
    T getDTO(String url);
}

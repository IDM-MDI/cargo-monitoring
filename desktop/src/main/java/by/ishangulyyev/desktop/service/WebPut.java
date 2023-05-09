package by.ishangulyyev.desktop.service;

public interface WebPut<T> {
    T put(String url, String id, T entity, Class<T> tClass);
}

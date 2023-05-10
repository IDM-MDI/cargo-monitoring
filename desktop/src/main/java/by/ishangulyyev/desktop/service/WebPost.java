package by.ishangulyyev.desktop.service;

public interface WebPost<T> {
    T post(String url, T entity, Class<T> tClass);
}

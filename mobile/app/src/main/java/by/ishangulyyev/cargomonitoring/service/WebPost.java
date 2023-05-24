package by.ishangulyyev.cargomonitoring.service;

public interface WebPost<T> {
    T post(String url, String token, T entity, Class<T> tClass);
}

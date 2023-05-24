package by.ishangulyyev.cargomonitoring.service;


import by.ishangulyyev.cargomonitoring.model.Page;

public interface WebGet<T> {
    Page getDTO(String url, int page, int size, String filter, String direction, String token);
    T getDTO(String url, String id, String token, Class<T> tClass);
    T getDTO(String url, String token, Class<T> tClass);
}

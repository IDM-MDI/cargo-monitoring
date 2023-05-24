package by.ishangulyyev.cargomonitoring.service;

public interface WebPatch<T> {
    int patch(String url, String id, String params, String token);
    int patch(String url, String token);
}

package by.ishangulyyev.desktop.service;

public interface WebPatch<T> {
    T patch(String url, String id, String params, Class<T> tClass);
    T patch(String url, Class<T> tClass);
}

package by.ishangulyyev.desktop.service;

public interface WebDelete {
    int delete(String url, String id);
    int delete(String url, String id, String token);
}

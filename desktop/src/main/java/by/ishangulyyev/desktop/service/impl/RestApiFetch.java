package by.ishangulyyev.desktop.service.impl;

import by.ishangulyyev.desktop.service.WebFetch;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.mashape.unirest.http.Unirest;
import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.List;

public class RestApiFetch<T> implements WebFetch<T> {
    @SneakyThrows
    @Override
    public List<T> getDTO(String url, int page, int size, String filter, String direction) {
        return new Gson()
                .fromJson(
                        Unirest.get(url)
                                .routeParam("page", String.valueOf(page))
                                .routeParam("size", String.valueOf(size))
                                .routeParam("filter", filter)
                                .routeParam("direction", direction)
                                .asJson()
                                .getBody()
                                .toString(),
                        new TypeToken<ArrayList<T>>(){}.getType()
        );
    }

    @SneakyThrows
    @Override
    public T getDTO(String url, String id) {
        return new Gson()
                .fromJson(
                        Unirest.get(url + "/" + id)
                                .asJson()
                                .getBody()
                                .toString(),
                        new TypeToken<T>(){}.getType()
                );
    }

    @SneakyThrows
    @Override
    public T getDTO(String url) {
        return new Gson()
                .fromJson(
                        Unirest.get(url)
                                .asJson()
                                .getBody()
                                .toString(),
                        new TypeToken<T>(){}.getType()
                );
    }
}

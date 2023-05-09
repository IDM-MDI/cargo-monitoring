package by.ishangulyyev.desktop.service;

import by.ishangulyyev.desktop.model.AuthenticationRequest;
import by.ishangulyyev.desktop.model.Employee;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.lang.reflect.Type;

public class AuthenticationSerializer implements JsonSerializer<AuthenticationRequest> {
    @Override
    public JsonElement serialize(AuthenticationRequest src, Type typeOfSrc, JsonSerializationContext context) {
        JsonObject object = new JsonObject();
        object.addProperty("login", src.getLogin());
        object.addProperty("password", src.getPassword());
        return object;
    }
}

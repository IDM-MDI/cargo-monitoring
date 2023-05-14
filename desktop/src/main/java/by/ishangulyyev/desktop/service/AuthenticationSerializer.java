package by.ishangulyyev.desktop.service;

import by.ishangulyyev.desktop.model.Authentication;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.lang.reflect.Type;

public class AuthenticationSerializer implements JsonSerializer<Authentication> {
    @Override
    public JsonElement serialize(Authentication src, Type typeOfSrc, JsonSerializationContext context) {
        JsonObject object = new JsonObject();
        object.addProperty("login", src.getLogin());
        object.addProperty("password", src.getPassword());
        return object;
    }
}

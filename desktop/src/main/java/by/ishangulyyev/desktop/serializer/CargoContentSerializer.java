package by.ishangulyyev.desktop.serializer;

import by.ishangulyyev.desktop.model.CargoContent;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.lang.reflect.Type;

public class CargoContentSerializer implements JsonSerializer<CargoContent> {
    @Override
    public JsonElement serialize(CargoContent src, Type typeOfSrc, JsonSerializationContext context) {
        JsonObject object = new JsonObject();
        object.addProperty("height", src.getHeight());
        object.addProperty("length", src.getLength());
        object.addProperty("weight", src.getWeight());
        object.addProperty("width", src.getWidth());
        return object;
    }
}

package by.ishangulyyev.cargomonitoring.serializer;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.lang.reflect.Type;

import by.ishangulyyev.cargomonitoring.model.CargoContent;


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

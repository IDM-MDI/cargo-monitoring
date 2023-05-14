package by.ishangulyyev.desktop.serializer;

import by.ishangulyyev.desktop.model.Cargo;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.lang.reflect.Type;

public class CargoSerializer implements JsonSerializer<Cargo> {
    @Override
    public JsonElement serialize(Cargo src, Type typeOfSrc, JsonSerializationContext context) {
        JsonObject object = new JsonObject();
        object.add("person", context.serialize(src.getPerson()));
        object.add("content", context.serialize(src.getContent()));
        object.add("company", context.serialize(src.getCompany()));
        object.add("departureAirport", context.serialize(src.getDepartureAirport()));
        object.add("arrivalTime", context.serialize(src.getArrivalTime().toString()));
        object.addProperty("type", src.getType());
        return object;
    }
}

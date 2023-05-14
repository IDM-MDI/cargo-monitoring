package by.ishangulyyev.desktop.serializer;

import by.ishangulyyev.desktop.model.Person;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.lang.reflect.Type;

public class PersonSerializer implements JsonSerializer<Person> {
    @Override
    public JsonElement serialize(Person src, Type typeOfSrc, JsonSerializationContext context) {
        JsonObject object = new JsonObject();
        object.addProperty("name", src.getName());
        object.addProperty("surname", src.getSurname());
        object.addProperty("lastname", src.getLastname());
        object.addProperty("birthday", src.getBirthday().toString());
        object.addProperty("gender", src.getGender());
        object.add("origin", context.serialize(src.getOrigin()));
        object.add("publicData", context.serialize(src.getPublicData()));
        return object;
    }
}

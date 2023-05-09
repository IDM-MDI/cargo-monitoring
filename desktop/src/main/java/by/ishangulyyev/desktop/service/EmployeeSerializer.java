package by.ishangulyyev.desktop.service;

import by.ishangulyyev.desktop.model.Employee;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.lang.reflect.Type;

public class EmployeeSerializer implements JsonSerializer<Employee> {
    @Override
    public JsonElement serialize(Employee src, Type typeOfSrc, JsonSerializationContext context) {
        JsonObject employeeJson = new JsonObject();
        employeeJson.add("authentication", context.serialize(src.getAuthentication()));
        employeeJson.add("person", context.serialize(src.getPerson()));
        employeeJson.addProperty("salary", src.getSalary());
        employeeJson.addProperty("position", src.getPosition());
        return employeeJson;
    }
}

package ru.job4j.ood.srp.model;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import ru.job4j.ood.srp.formatter.DateTimeParser;
import ru.job4j.ood.srp.formatter.ReportDateTimeParser;

import java.lang.reflect.Type;
import java.util.Calendar;

public class JSONAdapter implements JsonSerializer<Employee> {
    @Override
    public JsonElement serialize(Employee employee, Type type, JsonSerializationContext jsonSerializationContext) {
        JsonObject jsonObject = new JsonObject();
        DateTimeParser<Calendar> dateTimeParser = new ReportDateTimeParser();
        jsonObject.addProperty("name", employee.getName());
        jsonObject.addProperty("hired", dateTimeParser.parse(employee.getHired()));
        jsonObject.addProperty("fired", dateTimeParser.parse(employee.getFired()));
        jsonObject.addProperty("salary", employee.getSalary());
        return jsonObject;
    }
}

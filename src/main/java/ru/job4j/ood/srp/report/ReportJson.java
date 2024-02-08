package ru.job4j.ood.srp.report;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import ru.job4j.ood.srp.formatter.DateTimeParser;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.store.Store;

import java.util.List;

import java.util.Calendar;
import java.util.function.Predicate;

public class ReportJson implements Report {
    private final Store store;
    private final DateTimeParser<Calendar> dateTimeParser;
    private final Gson gson;

    public ReportJson(Store store, DateTimeParser<Calendar> dateTimeParser) {
        this.store = store;
        this.dateTimeParser = dateTimeParser;
        gson = new GsonBuilder().create();
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        List<Employee> employees = store.findBy(filter);
        JsonArray jsonArray = new JsonArray();
        for (Employee employee : employees) {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("name", employee.getName());
            jsonObject.addProperty("hired", dateTimeParser.parse(employee.getHired()));
            jsonObject.addProperty("fired", dateTimeParser.parse(employee.getFired()));
            jsonObject.addProperty("salary", employee.getSalary());
            jsonArray.add(jsonObject);
        }
        return jsonArray.toString();
    }
}

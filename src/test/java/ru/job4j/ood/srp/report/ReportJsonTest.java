package ru.job4j.ood.srp.report;

import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;
import ru.job4j.ood.srp.formatter.DateTimeParser;
import ru.job4j.ood.srp.formatter.ReportDateTimeParser;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.store.MemoryStore;

import java.util.Calendar;

import static org.hamcrest.CoreMatchers.containsString;

class ReportJsonTest {
    @Test
    public void whenConvertedJson() {
        MemoryStore store = new MemoryStore();
        Calendar now = Calendar.getInstance();
        Employee employee = new Employee("Ivan", now, now, 900000);
        DateTimeParser<Calendar> parser = new ReportDateTimeParser();
        store.add(employee);
        Report report = new ReportJson(store, parser);
        String jsonReport = report.generate(e -> true);
        MatcherAssert.assertThat(jsonReport, containsString("Ivan"));
        MatcherAssert.assertThat(jsonReport, containsString("900000"));
    }
}
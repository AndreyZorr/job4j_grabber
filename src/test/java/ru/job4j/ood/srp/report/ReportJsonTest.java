package ru.job4j.ood.srp.report;

import org.junit.jupiter.api.Test;
import ru.job4j.ood.srp.formatter.DateTimeParser;
import ru.job4j.ood.srp.formatter.ReportDateTimeParser;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.store.MemoryStore;

import java.util.Calendar;

import static org.assertj.core.api.Assertions.*;

class ReportJsonTest {
    @Test
    public void whenConvertedJson() {
        MemoryStore store = new MemoryStore();
        Calendar now = Calendar.getInstance();
        Employee worker1 = new Employee("Ivan", now, now, 900000);
        Employee worker2 = new Employee("Iv", now, now, 200);
        DateTimeParser<Calendar> parser = new ReportDateTimeParser();
        store.add(worker1);
        store.add(worker2);
        ReportJson reportJson = new ReportJson(store);
        String expected = "[\n"
                +  "  {\n"
                +  "    \"name\": \"Ivan\",\n"
                +  "    \"hired\": \"" + parser.parse(now) + "\",\n"
                +  "    \"fired\": \"" + parser.parse(now) + "\",\n"
                +  "    \"salary\": 900000.0\n"
                +  "  },\n"
                +  "  {\n"
                +  "    \"name\": \"Iv\",\n"
                +  "    \"hired\": \"" + parser.parse(now) + "\",\n"
                +  "    \"fired\": \"" + parser.parse(now) + "\",\n"
                +  "    \"salary\": 200.0\n"
                +  "  }\n"
                +  "]";
        assertThat(reportJson.generate(e -> true)).isEqualTo(expected);
    }
}
package ru.job4j.ood.srp.report;

import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;
import ru.job4j.ood.srp.formatter.DateTimeParser;
import ru.job4j.ood.srp.formatter.ReportDateTimeParser;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.store.MemoryStore;

import static org.hamcrest.CoreMatchers.*;

import java.util.Calendar;

class ReportXmlTest {

    @Test
    public void whenConvertedXml() {
        MemoryStore store = new MemoryStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 900000);
        DateTimeParser<Calendar> parser = new ReportDateTimeParser();
        store.add(worker);
        Report engine = new ReportJson(store, parser);
        String jsonReport;
        jsonReport = engine.generate(e -> true);
        MatcherAssert.assertThat(jsonReport, containsString("Ivan"));
        MatcherAssert.assertThat(jsonReport, containsString("900000"));
    }
}
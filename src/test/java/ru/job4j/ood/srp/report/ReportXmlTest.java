package ru.job4j.ood.srp.report;

import org.junit.jupiter.api.Test;
import ru.job4j.ood.srp.formatter.DateTimeParser;
import ru.job4j.ood.srp.formatter.ReportDateTimeParser;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.store.MemoryStore;
import ru.job4j.ood.srp.store.Store;

import java.util.Calendar;

import static org.assertj.core.api.Assertions.*;

class ReportXmlTest {

    @Test
    public void whenConvertedXml() {
        Store store = new MemoryStore();
        Calendar now = Calendar.getInstance();
        Employee worker1 = new Employee("Ivan", now, now, 100);
        Employee worker2 = new Employee("Van", now, now, 200);
        DateTimeParser<Calendar> parser = new ReportDateTimeParser();
        store.add(worker1);
        store.add(worker2);
        ReportXml reportXml = new ReportXml(store);
        String expected = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n"
                +  "<employees>\n"
                +  "    <employee>\n"
                +  "        <name>Ivan</name>\n"
                +  "        <hired>" + parser.parse(now) + "</hired>\n"
                +  "        <fired>" + parser.parse(now) + "</fired>\n"
                +  "        <salary>100.0</salary>\n"
                +  "    </employee>\n"
                +  "    <employee>\n"
                +  "        <name>Van</name>\n"
                +  "        <hired>" + parser.parse(now) + "</hired>\n"
                +  "        <fired>" + parser.parse(now) + "</fired>\n"
                +  "        <salary>200.0</salary>\n"
                +  "    </employee>\n"
                +  "</employees>\n";
        assertThat(reportXml.generate(e -> true)).isEqualTo(expected);
    }
}

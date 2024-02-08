package ru.job4j.ood.srp.report;

import ru.job4j.ood.srp.formatter.DateTimeParser;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.model.EmployeeWrapper;
import ru.job4j.ood.srp.model.Employees;
import ru.job4j.ood.srp.store.Store;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.IOException;
import java.io.StringWriter;
import java.util.Calendar;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ReportXml implements Report {
    private Store store;
    private final DateTimeParser<Calendar> dateTimeParser;

    public ReportXml(Store store, DateTimeParser<Calendar> dateTimeParser) {
        this.store = store;
        this.dateTimeParser = dateTimeParser;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        String xml = "";
        try {
            JAXBContext context = JAXBContext.newInstance(Employees.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            List<Employee> filteredEmployees = store.findBy(filter);
            List<EmployeeWrapper> employeeWrappers = filteredEmployees.stream()
                    .map(e -> new EmployeeWrapper(e, dateTimeParser))
                    .collect(Collectors.toList());
            Employees employeesWrap = new Employees(employeeWrappers);
            try (StringWriter writer = new StringWriter()) {
                marshaller.marshal(employeesWrap, writer);
                xml = writer.getBuffer().toString();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
        return xml;
    }
}
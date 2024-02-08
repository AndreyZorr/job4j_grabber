package ru.job4j.ood.srp.model;

import ru.job4j.ood.srp.formatter.DateTimeParser;

import javax.xml.bind.annotation.XmlElement;
import java.util.Calendar;

public class EmployeeWrapper {
    private Employee employee;
    private String hiredFormatted;
    private String firedFormatted;

    public EmployeeWrapper(Employee employee, DateTimeParser<Calendar> dateTimeParser) {
        this.employee = employee;
        this.hiredFormatted = dateTimeParser.parse(employee.getHired());
        this.firedFormatted = dateTimeParser.parse(employee.getFired());
    }

    @XmlElement
    public String getName() {
        return employee.getName();
    }

    @XmlElement
    public double getSalary() {
        return employee.getSalary();
    }

    @XmlElement(name = "hired")
    public String getHiredFormatted() {
        return hiredFormatted;
    }

    @XmlElement(name = "fired")
    public String getFiredFormatted() {
        return firedFormatted;
    }
}

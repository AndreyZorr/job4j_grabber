package ru.job4j.ood.srp.model;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "employees")
public class Employees {
    private List<EmployeeWrapper> employees;

    public Employees() {
    }

    public Employees(List<EmployeeWrapper> employees) {
        this.employees = employees;
    }

    public List<EmployeeWrapper> getEmployees() {
        return employees;
    }

    public void setEmployees(List<EmployeeWrapper> employees) {
        this.employees = employees;
    }
}

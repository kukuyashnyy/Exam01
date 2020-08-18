package org.itstep;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

public class Company {
    private String name;
    private Collection<Employee> employees;

    public Company(String name) {
        this.name = name;
        this.employees = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public void clrEmployee(Employee employee) {
        employees.remove(employee);
    }

    public void printByName(String name) {
        employees.stream()
                .filter(p -> p.getName().matches(name))
                .forEach(p -> System.out.println(p.getName()));
    }

    public void printByPosition(String position) {
        employees.stream()
                .filter(p -> p.getPosition().matches(position))
                .forEach(p -> System.out.println(p.getName()));
    }

    public void printByDepartment(String department) {
        employees.stream()
                .filter(p -> p.getDepartment().matches(department))
                .forEach(p -> System.out.println(p.getName()));
    }

    public void printByMasterName(String masterName) {
        employees.stream()
                .filter(p -> p.getMasterName().matches(masterName))
                .forEach(p -> System.out.println(p.getName()));
    }

    public void printInfo() {

    }

    public Double averagePayInCompany() {
        return employees.stream()
                .mapToInt(p -> p.getPay())
                .average()
                .getAsDouble();
    }

    public Double averagePayByDepartment(String department) {
        return employees.stream()
                .filter(p -> p.getDepartment().matches(department))
                .mapToInt(p -> p.getPay())
                .average()
                .getAsDouble();
    }

    public void topByPay(int num){
        employees.stream()
                .sorted((p1, p2) -> p2.getPay() - p1.getPay())
                .limit(num)
                .forEach(p -> System.out.println(p.getName()));
    }

    //???
    public void topByBeginWork(Date date, int num){
        employees.stream()
                .sorted((p1, p2) -> (int) (p2.getBegDate().getTime() - p1.getBegDate().getTime()))
                .limit(num)
                .forEach(p -> System.out.println(p.getName()));
    }
}
package org.itstep;

import java.util.*;

public class Company {
    private String name;
    private Map<Department, List<Employee>> listMap;

    public Company(String name) {
        this.name = name;
        this.listMap = new TreeMap<>();
    }

    public void addEmployee(Employee employee) {

        if (!this.listMap.containsKey(employee.getDepartment())) {
            this.listMap.put(employee.getDepartment(), new ArrayList<Employee>());
        }
        this.listMap.get(employee.getDepartment()).add(employee);
    }

    public void clrEmployee(Employee employee) {
        this.listMap.remove(employee);
    }

    public void printByName(Employee employee) {
        this.listMap.get(employee.getDepartment()).stream()
                .filter(p -> p.getName().matches(name))
                .forEach(p -> System.out.println(p.getName()));
    }

    public void printByPosition(String position) {
        for (Department department : this.listMap.keySet()) {
            this.listMap.get(department).stream()
                    .filter(p -> p.getPosition().matches(position))
                    .forEach(p -> System.out.println(p.getName()));
        }
    }

    public void printByDepartment(String departmentName) {
        for (Department department : this.listMap.keySet()) {
            this.listMap.get(department).stream()
                    .filter(p -> p.getDepartment().equals(new Department(departmentName)))
                    .forEach(p -> System.out.println(p.getName()));
        }
    }

    public void printByMasterName(String masterName) {
        for (Department department : this.listMap.keySet()) {
            this.listMap.get(department).stream()
                    .filter(p -> p.getMasterName().matches(masterName))
                    .forEach(p -> System.out.println(p.getName()));
        }
    }

    public void printInfo() {
        this.listMap.keySet().stream()
                .forEach(System.out::println);
    }

    public void printAveragePayInCompany() {
        int i = 1;
        double sum = 0;

        for (Department department : this.listMap.keySet()) {
            sum += this.listMap.get(department).stream()
                    .mapToInt(Employee::getPay)
                    .sum();
            i++;
        }
        System.out.printf("Average pay in company : %.2f\n", sum/i);
    }

    public void printAveragePayByDepartments() {
        double sum = 0;
        for (Department department : this.listMap.keySet()) {
            sum = this.listMap.get(department).stream()
                    .mapToInt(Employee::getPay)
                    .average()
                    .getAsDouble();

            System.out.println(department);
            System.out.printf("Average pay in this department : %.2f\n", sum);
        }
    }

    public void topTenByPay(){
        final int num = 10;
        for (Department department : this.listMap.keySet()) {
            this.listMap.get(department).stream()
                    .sorted((p1, p2) -> p2.getPay() - p1.getPay())
                    .limit(num)
                    .forEach(p -> System.out.println(p.getName()));
        }
    }

    public void topTenByBeginWork() {
        final int num = 10;
        for (Department department : this.listMap.keySet()) {
            this.listMap.get(department).stream()
                    .sorted((p1, p2) -> p2.getBeginDate() - p1.getBeginDate())
                    .limit(num)
                    .forEach(p -> System.out.println(p.getName()));
        }
    }
}
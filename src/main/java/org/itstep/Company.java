package org.itstep;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.*;

public class Company implements Serializable {
    private String name;
    private Map<Department, List<Employee>> listMap;

    public Company(String name) {
        this.name = name;
        this.listMap = new TreeMap<>();
    }

    private void addEmployee(Employee employee) {

        if (!this.listMap.containsKey(employee.getDepartment())) {
            this.listMap.put(employee.getDepartment(), new ArrayList<Employee>());
        }
        employee.setBeginDate(LocalDate.now());
        this.listMap.get(employee.getDepartment()).add(employee);
    }

    public void chgEmployee(Employee employee) {

        if (!this.listMap.containsKey(employee.getDepartment())) {
            this.listMap.put(getDepartmentByEmployee(employee), new ArrayList<Employee>());
        }
        this.listMap.get(getDepartmentByEmployee(employee)).add(employee);
    }

    public void addEmployee() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите имя пользователя:");
        Employee employee = new Employee(scanner.next());
        System.out.println("Введите название отдела:");
        Department department = new Department(scanner.next());
        System.out.println("Введите имя начальника отдела:");
        department.setMasterName(scanner.next());
        employee.setDepartment(department);
        System.out.println("Введите размер зарплаты:");
        employee.setPay(scanner.nextInt());
        System.out.println("Введите должность:");
        employee.setPosition(scanner.next());
        this.addEmployee(employee);
    }

    private void changeEmployee(Employee empOrig, Employee empNew) {
        chgEmployee(this.listMap.get(empOrig)
                .remove(this.listMap.get(empOrig).indexOf(empOrig)));
    }

    public void changeEmployee() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите имя пользователя:");
        Employee empOrg = new Employee(scanner.next());

        System.out.println("Введите новое имя пользователя:");
        Employee empNew = new Employee(scanner.next());
        System.out.println("Введите новое название отдела:");
        Department depNew = new Department(scanner.next());
        System.out.println("Введите новое имя начальника отдела:");
        depNew.setMasterName(scanner.next());
        empNew.setDepartment(depNew);
        System.out.println("Введите новый размер зарплаты:");
        empNew.setPay(scanner.nextInt());
        System.out.println("Введите новую должность:");
        empNew.setPosition(scanner.next());
        this.changeEmployee(empOrg, empNew);
    }

    private void clrEmployee(Employee employee) {
        Department department = getDepartmentByEmployee(employee);
        if (department != null) {
            this.listMap.get(department).remove(employee);
        }
    }

    private Department getDepartmentByEmployee(Employee employee) {
        for (Department dep : this.listMap.keySet()) {
            if (this.listMap.get(dep).contains(employee)) {
                return dep;
            } else {
                System.out.println("Сотрудник не найден.");
            }
        }
        return null;
    }

    public void clrEmployee() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите имя пользователя:");
        this.clrEmployee(new Employee(scanner.next()));
    }

    private void printByName(Employee employee) {
        System.out.println(this.listMap.get(getDepartmentByEmployee(employee)).
                get(this.listMap.get(getDepartmentByEmployee(employee)).indexOf(employee)).toString());
    }

    public void printByName(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите имя пользователя:");
        this.printByName(new Employee(scanner.next()));
    }

    private void printByPosition(String position) {
        for (Department department : this.listMap.keySet()) {
            this.listMap.get(department).stream()
                    .filter(p -> p.getPosition().matches(position))
                    .forEach(p -> System.out.println(p.getName()));
        }
    }

    public void printByPosition() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите должность:");
        this.printByPosition(scanner.next());
    }

    private void printByDepartment(String departmentName) {
        for (Department department : this.listMap.keySet()) {
            this.listMap.get(department).stream()
                    .filter(p -> p.getDepartment().equals(new Department(departmentName)))
                    .forEach(p -> System.out.println(p.getName()));
        }
    }

    public void printByDepartment() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите отдел:");
        this.printByDepartment(scanner.next());
    }

    private void printByMasterName(String masterName) {
//        for (Department department : this.listMap.keySet()) {
//            this.listMap.get(department).stream()
//                    .filter(p -> p.getMasterName().matches(masterName))
//                    .forEach(p -> System.out.println(p.getName()));
//        }
        for (Department department : this.listMap.keySet()) {
            if (department.getMasterName().matches(masterName)) {
                for (Employee emp : this.listMap.get(department)) {
                    if (emp != null) System.out.println(emp.getName());
                }
            }
        }
    }

    public void printByMasterName() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите имя руководителя отдела:");
        this.printByMasterName(scanner.next());
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
            int i = 0;
                for (Employee emp : this.listMap.get(department)) {
                    if (emp != null) {
                        sum += emp.getPay();
                        i++;
                    }
                }
            System.out.println(department);
            System.out.printf("Average pay in this department : %.2f\n", sum/i);
        }
//        for (Department department : this.listMap.keySet()) {
//            sum = this.listMap.get(department).stream()
//                    .mapToInt(Employee::getPay)
//                    .average()
//                    .getAsDouble();
//
//            System.out.println(department);
//            System.out.printf("Average pay in this department : %.2f\n", sum);
//        }
    }

    public void printTopTenByPay(){
        final int num = 10;
        for (Department department : this.listMap.keySet()) {
            this.listMap.get(department).stream()
                    .sorted(Comparator.comparingInt(Employee::getPay))
                    .limit(num)
                    .forEach(p -> System.out.println(p.getName()));
        }
    }

    public void printTopTenByBeginWork() {
        final int num = 10;
        for (Department department : this.listMap.keySet()) {
            this.listMap.get(department).stream()
                    .sorted((p1, p2) -> p2.getBeginDate().compareTo(p1.getBeginDate()))
                    .limit(num)
                    .forEach(p -> System.out.println(p.getName()));
        }
    }
}
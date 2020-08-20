package org.itstep;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class Employee implements Comparable<Employee>, Serializable {
    private String name;
    private String birthDayDate;
    private String sex;
    private String phoneNumber;
    private String position;
    private Department department;
    private String masterName;
    private LocalDate beginDate;
    private int pay;

    public Employee(String name, String departmentName, String masterName, LocalDate beginTime, int pay) {
        this(name, departmentName, pay);
        this.department.setMasterName(masterName);
    }

    public Employee(String name, String departmentName, int pay) {
        this(name, departmentName);
        this.pay = pay;
    }

    public Employee(String name, String departmentName, String masterName) {
        this(name, departmentName);
        this.department.setMasterName(masterName);
    }

    public Employee(String name, String departmentName) {
        this(name);
        this.department = new Department(departmentName);
    }

    public Employee(String name) {
        this.name = name;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthDayDate() {
        return birthDayDate;
    }

    public void setBirthDayDate(String birthDayDate) {
        this.birthDayDate = birthDayDate;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public String getMasterName() {
        return masterName;
    }

    public void setMasterName(String masterName) {
        this.masterName = masterName;
    }

    public LocalDate getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(LocalDate time) {
        this.beginDate = time;
    }

    public int getPay() {
        return pay;
    }

    public void setPay(int pay) {
        this.pay = pay;
    }

    @Override
    public int compareTo(Employee o) {
        return this.name.compareTo(o.name);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(name, employee.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", birthDayDate='" + birthDayDate + '\'' +
                ", sex='" + sex + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", position='" + position + '\'' +
                ", department=" + department +
                ", masterName='" + masterName + '\'' +
                ", beginDate=" + beginDate +
                ", pay=" + pay +
                '}';
    }
}

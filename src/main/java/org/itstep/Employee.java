package org.itstep;

import java.util.Date;

public class Employee {
    private String name;
    private String bDate;
    private String sex;
    private String telNumber;
    private String position;
    private String department;
    private String masterName;
    private Date begDate;
    private int pay;

    public Employee(String name, String bDate, String sex, String telNumber, String position, String department, String masterName, Date begDate, int pay) {
        this.name = name;
        this.bDate = bDate;
        this.sex = sex;
        this.telNumber = telNumber;
        this.position = position;
        this.department = department;
        this.masterName = masterName;
        this.begDate = begDate;
        this.pay = pay;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getbDate() {
        return bDate;
    }

    public void setbDate(String bDate) {
        this.bDate = bDate;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getTelNumber() {
        return telNumber;
    }

    public void setTelNumber(String telNumber) {
        this.telNumber = telNumber;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getMasterName() {
        return masterName;
    }

    public void setMasterName(String masterName) {
        this.masterName = masterName;
    }

    public Date getBegDate() {
        return begDate;
    }

    public void setBegDate(Date begDate) {
        this.begDate = begDate;
    }

    public int getPay() {
        return pay;
    }

    public void setPay(int pay) {
        this.pay = pay;
    }

}

package org.itstep;

public class Employee implements Comparable<Employee>{
    private String name;
    private String birthDayDate;
    private String sex;
    private String phoneNumber;
    private String position;
    private Department department;
    private String masterName;
    private int beginDate;
    private int pay;

    public Employee(String name, String departmentName, String masterName, int beginTime, int pay) {
        this(name, departmentName, beginTime, pay);
        this.department.setMasterName(masterName);
    }

    public Employee(String name, String departmentName, int beginTime, int pay) {
        this(name, departmentName);
        this.beginDate = beginTime;
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

    public int getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(int time) {
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
}

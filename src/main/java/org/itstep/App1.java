package org.itstep;


public class App1
{
    public static void main( String[] args )
    {
        Company company = new Company("ItStep");
        company.addEmployee(new Employee("Vasya", "it", "Peatya", 1000, 300));
        company.addEmployee(new Employee("Tanya", "it", 1500, 450));
        company.addEmployee(new Employee("Vika", "HR", "Vasya", 1000, 150));

        company.printByDepartment("it");
        System.out.println();
        company.printByDepartment("HR");

        company.printInfo();

        company.printAveragePayInCompany();

        company.printAveragePayByDepartments();


    }
}

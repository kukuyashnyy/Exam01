package org.itstep;


import java.io.*;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;

public class App1
{
    public static void main( String[] args )
    {
        final String fileName = "dataBase.dat";

        Scanner scanner = new Scanner(System.in);
        Menu menu = new Menu("Главное меню.");

        Company company = null;

        File file = new File(fileName);
        if (file.exists()) {
            company = readObject(fileName);
        } else {
            company = new Company("ItStep");
        }

        System.out.println("Введите имя:");
        String name = new String(scanner.next());
        System.out.println("Введите пароль:");
        String password = new String(scanner.next());

        menu.add(new Menu("Добавить сотрудника.", company::addEmployee));
        menu.add(new Menu("Уволить сотрудника.", company::clrEmployee));
        menu.add(new Menu("Изменить информацию о сотрудника.", company::changeEmployee));
        menu.add(new Menu("Распечатать инормацию о компании.", company::printInfo));
        menu.add(new Menu("Распечатать инормацию по отделам.", company::printByDepartment));
        menu.add(new Menu("Распечатать инормацию по руководителю.", company::printByMasterName));
        menu.add(new Menu("Распечатать инормацию по должностям.", company::printByPosition));
        menu.add(new Menu("Распечатать инормацию о сотруднике.", company::printByName));
        menu.add(new Menu("Распечатать топ-10 по зарплате.", company::printTopTenByPay));
        menu.add(new Menu("Распечатать топ-10 по длительности работы.", company::printTopTenByBeginWork));
        menu.add(new Menu("Распечатать среднюю зарплату по компании.", company::printAveragePayInCompany));
        menu.add(new Menu("Распечатать среднюю зарплату по отделам.", company::printAveragePayByDepartments));
        menu.add(new Menu("Выход."));

        if (name.matches("admin") & password.matches("admin")) {
            menu.show();
            saveObject(company, fileName);
        } else {
        System.out.println("Введены не верные данные!");
    }
    }

    private static void saveObject(Company company, String filename) {
        try (ObjectOutput output = new ObjectOutputStream(new FileOutputStream(filename))) {
            output.writeObject(company);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Company readObject(String filename) {
        Company company = null;
        try (ObjectInput input = new ObjectInputStream(new FileInputStream(filename))) {
            company = (Company) input.readObject();
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
        return company;
    }
}

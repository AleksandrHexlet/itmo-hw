package ru.itmo.lesson14.task.task03;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Employee {
    private String name;
    private String company;
    private int salary;
    private int age;

    public Employee(String name, String company, int salary, int age) {
        this.name = name;
        this.company = company;
        this.salary = salary;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getCompany() {
        return company;
    }

    public int getSalary() {
        return salary;
    }

    public int getAge() {
        return age;
    }
// TODO: добавить необходимые конструкторы, геттеры, сеттеры и другие методы


    // TODO: дописать реализацию метода для создания списка объектов класса Employee.
    //  Объекты Employee создавать со случайными значениями:
    //  возраст от 21 до 60;
    //  диапазон ЗП на Ваш выбор.
    //  name - случайное значения из массива names
    //  company - случайное значения из массива companies
    public static List<Employee> employeeGenerator(int num) { //  num - количество объектов в списке
        String[] names = {"Mike", "Tom", "Alex", "John", "Peter", "Jack", "Charlie", "Max", "Jenifer", "Linda", "Elizabeth"}; // массив с именами
        String[] companies = {"Microsoft", "IBM", "Google", "General Electric", "Siemens", "Samsung", "Apple"}; // массив с названиями компаний
        int age=0;
        int salary =0;
        String name = "";
        String company ="";

        ArrayList<Employee> employees = new ArrayList<>();

        for (int i = 0; i <= num ; i++) {
            age = (int )(Math.random() * 41) +20;
            salary = (int )(Math.random() * 99) + 2_100_000_000;
            name = names[(int)(Math.random() * names.length)];
            company = companies[(int)(Math.random() * companies.length)];
            Employee employee = new Employee(name,company,salary,age);
            employees.add(employee);
        } // создание объектов, наполнение списка


        System.out.println("employees = " + employees);

        return employees;
    }



    public static class nameComparator implements Comparator<Employee> {

        @Override
        public int compare(Employee o1, Employee o2) {
            return o2.getName().compareTo(o1.getName());
        }
    }

    public static class salaryComparator implements Comparator<Employee>{

        @Override
        public int compare(Employee o1, Employee o2) {
            return (int) (o2.getSalary() - o1.getSalary());
        }
    }

    public static class ageComparator implements Comparator<Employee>{

        @Override
        public int compare(Employee o1, Employee o2) {
            return (int) (o2.getAge() - o1.getAge());
        }
    }

    public static class companyComparator implements Comparator<Employee>{

        @Override
        public int compare(Employee o1, Employee o2) {
            return o2.getCompany().compareTo(o1.getCompany());
        }
    }






    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", company='" + company + '\'' +
                ", salary=" + salary +
                ", age=" + age +
                '}';
    }
}
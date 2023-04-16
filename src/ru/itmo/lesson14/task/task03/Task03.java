package ru.itmo.lesson14.task.task03;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Task03 {
    public static void main(String[] args) {
        // 1. Дописать класс Employee
        List<Employee> employeeList = Employee.employeeGenerator(20);

        // 2. Отсортировать employeeList:
        // 2.1. по имени
        // 2.2. по имени и зп
        // 2.3. по имени, зп, возрасту, компании

        // Для сортировки используйте тип Comparator



        // Для сортировки используйте тип Comparator
        Comparator<Employee> comparatorName = new Employee.nameComparator();
        Comparator<Employee> comparatorNameAndSalary = new Employee.nameComparator().thenComparing(new Employee.salaryComparator());
        Comparator<Employee> comparatorNameSalaryAge = comparatorNameAndSalary.thenComparing(new Employee.ageComparator());
        Comparator<Employee> comparatorNameSalaryAgeCompany = comparatorNameSalaryAge.thenComparing(new Employee.companyComparator());

        ArrayList<Employee> arrayName = new ArrayList<>();
        ArrayList<Employee> arrayNameSalary = new ArrayList<>();
        ArrayList<Employee> arrayNameSalaryAgeCompany = new ArrayList<>();

//        employeeList.sort(comparatorName);
////        testList.sort(Comparator.comparing(ClassName::getFieldName));
        for (Employee item: employeeList){
            arrayName.add(item);
            arrayNameSalary.add(item);
            arrayNameSalaryAgeCompany.add(item);
        }
//        arrayName.sort(comparatorName);
//        arrayNameSalary.sort(comparatorNameAndSalary);
//        arrayNameSalaryAgeCompany.sort(comparatorNameSalaryAgeCompany);

        arrayName.sort(Comparator.comparing(Employee::getName));
        arrayNameSalary.sort(Comparator.comparing(Employee::getSalary));
        arrayNameSalaryAgeCompany.sort(Comparator.comparing(Employee::getAge));

        System.out.println("arrayName =  " + arrayName);
        System.out.println(" arrayNameSalary = " +  arrayNameSalary);
        System.out.println("arrayNameSalaryAgeCompany =  " + arrayNameSalaryAgeCompany );
    }
}

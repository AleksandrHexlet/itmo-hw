package ru.itmo.lesson19.task01;

import java.time.LocalDate;
import java.time.Period;
import java.util.*;
import java.util.stream.Collectors;

public class Task01 {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>(Arrays.asList(
                new Student(1, "Женя", Student.Gender.MALE, LocalDate.now().minusYears(10)),
                new Student(2, "Олег", Student.Gender.MALE, LocalDate.now().minusYears(7)),
                new Student(3, "Алена", Student.Gender.FEMALE, LocalDate.now().minusYears(6)),
                new Student(4, "Иван", Student.Gender.MALE, LocalDate.now().minusYears(12)),
                new Student(5, "Алексей", Student.Gender.MALE, LocalDate.now().minusYears(9)),
                new Student(6, "Петр", Student.Gender.MALE, LocalDate.now().minusYears(9)),
                new Student(7, "Иван", Student.Gender.MALE, LocalDate.now().minusYears(17)),
                new Student(8, "Петр", Student.Gender.MALE, LocalDate.now().minusYears(5)),
                new Student(9, "Алена", Student.Gender.FEMALE, LocalDate.now().minusYears(8)),
                new Student(10, "Алена", Student.Gender.FEMALE, LocalDate.now().minusYears(10)),
                new Student(11, "Григорий", Student.Gender.MALE, LocalDate.now().minusYears(7)),
                new Student(12, "Ирина", Student.Gender.FEMALE, LocalDate.now().minusYears(6))
        ));

        // TODO: Используя методы Stream API:
        //  1. Разделить учеников на две группы: мальчиков и девочек. Результат: Map<Student.Gender, ArrayList<Student>>
        //  2. Найти средний возраст учеников
        //  3. Найти самого младшего ученика
        //  4. Найти самого старшего ученика
        //  5. Собрать учеников в группы по году рождения
        //  6. Отсортировать по полу, потом по дате рождения, потом по имени (в обратном порядке), собрать в список (ArrayList)
        //  7. Вывести в консоль всех учеников в возрасте от N до M лет
        //  8. Собрать в список всех учеников с именем=someName
        //  9. Собрать Map<Student.Gender, Integer>, где Student.Gender - пол, Integer - суммарный возраст учеников данного пола
        //     см. метод Collectors.summingInt
// 1.
        Map<Student.Gender, List<Student>> studentMap = students.stream().collect(Collectors.groupingBy(student -> student.getGender(),
                Collectors.toCollection(ArrayList::new)));
        System.out.println(studentMap);
//2.
        Double averagingInt = students.stream().collect(Collectors.averagingInt(student -> {
            Period diff = Period.between(student.getBirth(), LocalDate.now());
            System.out.println("diff.getYears()  =  " + diff.getYears());
            return diff.getYears();
        }));
        System.out.println("averagingInt = " + averagingInt);

//3.
        Student studentMin = students.stream().min((student01, student02) -> student02.getBirth().compareTo(student01.getBirth())).get();
        System.out.println("min student = " + studentMin);
//4.
        Student studentMax = students.stream().max((student01, student02) -> student02.getBirth().compareTo(student01.getBirth())).get();
        System.out.println("studentMax = " + studentMax);
//5.
        Map<Number, List<Student>> mapGroupAge = students.stream().collect(Collectors.groupingBy(student -> student.getBirth().getYear(),
                Collectors.toCollection(ArrayList::new)));
        System.out.println("mapGroupAge = " + mapGroupAge);

//6.
        List<Student> studentSortedArr = students.stream().sorted((st01, st02) -> st02.getGender().compareTo(st01.getGender()))
                .sorted((student01, student02) -> student02.getBirth().compareTo(student01.getBirth()))
                .sorted((student1, student2) -> student2.getName().compareTo(student1.getName())).collect(Collectors.toCollection(ArrayList::new));

        System.out.println("studentSortedArr = " + studentSortedArr);
        List<Student> studentSortedGender = students.stream().sorted(Comparator.comparing(Student::getName).reversed()).collect(Collectors.toList());
        System.out.println("studentSortedGender = " + studentSortedGender);

//7.

        students.stream().forEach(student -> {
            Period difference = Period.between(student.getBirth(), LocalDate.now());
            if (difference.getYears() > 5 && difference.getYears() < 15) {
                System.out.println("Student> 5 && Student < 15 = " + student);
            }
        });

//8.

        List<Student> StudentNameArray = students.stream().filter(student -> student.getName() == "Алена").collect(Collectors.toList());
        System.out.println("StudentNameArray = " + StudentNameArray);
//9.

        Map<Student.Gender, Integer> SummaryAgeArr = students.stream().collect(Collectors.groupingBy(student -> student.getGender(), Collectors.summingInt(student -> {
            Period diff = Period.between(student.getBirth(), LocalDate.now());
            return diff.getYears();
        })));

        System.out.println("SummaryAgeArr = " + SummaryAgeArr);

    }

}








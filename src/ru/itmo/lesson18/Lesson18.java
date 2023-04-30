package ru.itmo.lesson18;

import jdk.dynalink.Operation;
import ru.itmo.lesson14.task.task01.Fruit;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Lesson18 {
    public static void main(String[] args) {
        // /* public */ double action(double a, double b);
        Operation plus01 = new Operation() {

            public double action(double a, double b) {
                return a + b;
            }
        };

        //
//        Operation plus = (first, second) -> /* return */ first + second;
        // создается анонимный класс, имплементирующий Operation,
        // реализация абстрактного метода - лямбда выражение
        // создается экземпляр анонимного класса
//        System.out.println(plus.action(34.9, 78.7));

        // написать реализации для вычитания и умножения
//        Operation minus = (first, second) -> first - second;
//        System.out.println(minus.action(34.9, 90.2));

//        printResult(plus);
//        printResult(minus);
//        printResult((a, b) -> a * b);
//
//        Operation div = (a, b) -> {
//            if (b == 0) return 0;
//            return a / b;
//        };
//        System.out.println(div.action(3.8, 9.9));

        // () ->
        // x ->
        // (x) ->
        // (x, y) ->

        // (x, y) -> x + y; // неявный return
        // (x, y) -> { return x + y;}
        // (x, y) -> { несколько инструкций; }

        // import java.util.function.*;
        // Predicate
        // Function
        // Consumer
        ArrayList<Integer> integers =
                new ArrayList<>(Arrays.asList(34, -78, 12, 56, 34, -89, 0, 344));

        // boolean test(T t);
        Predicate<Integer> negative = integer -> integer < 0;
        System.out.println(negative.test(12));

        integers.removeIf(negative);
        ArrayList<Integer> integers1 = new ArrayList<>(Arrays.asList(34, 45, -12, -67, 57, 78, -34, 89));
        Predicate<Integer> filter = integer -> integer < 0;

        System.out.println("integer before = " + integers);
        System.out.println(filter.test(12));
        integers.removeIf(filter);

        System.out.println("integer after = " + integers);


        // Consumer void accept(T t)
        Consumer<Integer> sout = integer -> System.out.println(integer);
        integers.forEach(sout);
        // если удаляем через forEach или removeIf, тогда мы не можем прервать цикл, если надо прерывать цикл
        // тогда надо перебрать через прямой перебор
        // Например for(Integer int: integers)
        // { System.out.println("integer  = " + integers);}

        ArrayList<String> strings = new ArrayList<>(
                Arrays.asList("01.txt", "02.json", "03.txt", "04.txt", "05.properties"));

        Predicate<String> jsonOrProperties = str -> str.endsWith(".json") || str.endsWith(".properties");
        strings.removeIf(jsonOrProperties);

        Iterator<String> stringIterator = strings.iterator();
        while (stringIterator.hasNext()) {
            String str = stringIterator.next();
            if (str.endsWith(".json") || str.endsWith(".properties")) stringIterator.remove();
        }


        ArrayList<Fruit> fruits = new ArrayList<>();
        fruits.add(new Fruit(Fruit.FruitType.APPLE, 120, 5));
        fruits.add(new Fruit(Fruit.FruitType.BANANA, 80, 12));
        fruits.add(new Fruit(Fruit.FruitType.APRICOT, 300, 2));
        fruits.add(new Fruit(Fruit.FruitType.APPLE, 120, 10));
        fruits.add(new Fruit(Fruit.FruitType.PEAR, 180, 2));
        fruits.add(new Fruit(Fruit.FruitType.PEAR, 180, 8));
        fruits.add(new Fruit(Fruit.FruitType.BANANA, 130, 8));

        Predicate<Fruit> filterFruits = fruit -> fruit.getType() == Fruit.FruitType.BANANA && fruit.getPrice() < 100;
        fruits.removeIf(filterFruits);
        System.out.println("fruits == " + fruits);

        // увеличить стоимость фруктов в два раза

        for (Fruit fruit : fruits) {
            fruit.setPrice(fruit.getPrice() * 2);
        }
        System.out.println("fruit.getPrice() * 2 = " + fruits);


        Consumer<Fruit> changePrice = fruit -> fruit.setPrice(fruit.getPrice() * 2);
        fruits.forEach(changePrice);


        ArrayList<Fruit> byPrice = getByFilter(fruits, fruit -> fruit.getPrice() >150);
        ArrayList<Fruit> byPrice1 = getByFilter(fruits, fruit -> fruit.getType() == Fruit.FruitType.BANANA);

        Comparator<Fruit> compareByPrice = (fruit1,fruit2) -> (int)(fruit2.getPrice() - fruit1.getPrice());
        fruits.sort(compareByPrice);
        //Collection.sort(fruits,compareByPrice);


    }

    public static ArrayList<Fruit> getByFilter(ArrayList<Fruit> fruits, Predicate<Fruit> condition) {
        ArrayList<Fruit> fruitArr = new ArrayList<>();
        for (Fruit fruit : fruits) {

            if (condition.test(fruit)) fruitArr.add(fruit);

        }
        return fruitArr;
    }

    public static void printResult(Operation operation) {
//        System.out.println(operation.action(34, 89));
    }

}
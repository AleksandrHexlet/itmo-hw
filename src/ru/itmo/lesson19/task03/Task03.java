package ru.itmo.lesson19.task03;

import ru.itmo.lesson14.task.task01.Fruit;

import java.util.Optional;

public class Task03 {
    public static void main(String[] args) {


        OptionalMethods optionalMethods = new OptionalMethods();
        Fruit fruit1 = new Fruit(Fruit.FruitType.APPLE,10,20);
        Fruit fruit2 = new Fruit(Fruit.FruitType.BANANA,90,920);


        System.out.println("optionalContainer02 = " + optionalMethods.optionalContainer02(fruit1));
        System.out.println("optionalContainer01 = " + optionalMethods.optionalContainer01(fruit1.getType(),123,456));
        System.out.println("optionalContainer03 = " + optionalMethods.optionalContainer03(fruit2));


    }


}



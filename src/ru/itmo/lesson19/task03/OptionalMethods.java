package ru.itmo.lesson19.task03;

import ru.itmo.lesson14.task.task01.Fruit;

import java.util.Optional;

public class OptionalMethods {
    // «адани€ на методы Optional:
    // 1. написать метод, который принимает на вход тип фрукта, стоимость и количество
    // и возвращает Optional контейнер с экземпл€ром типа Fruit
    // или Optional контейнер с null ссылкой, если тип фрукта == null, а стоимость или количество меньше 1

    // 2. написать метод, который принимает на вход экземпл€р типа Fruit
    // и возвращает true, если его передан не null, количество фруктов больше 5, а стоимость не больше 100
    // ¬место обычных проверок использовать тип Optional и подход€щие методы

    // 3. написать метод, который принимает на вход экземпл€р типа Fruit
    // и возвращает
    // название фрукта (FruitType.getName()) в Optional контейнере, если тип фрукта определен,
    // и Optional контейнер с null ссылкой, если тип фрукта == null
    // ¬место обычных проверок использовать тип Optional и подход€щие методы


    public Optional<Fruit> optionalContainer01(Fruit.FruitType fruitType, int price, int count) {
        Fruit fruit = new Fruit(fruitType, price, count);
        Optional<Fruit> optionalContainer = Optional.ofNullable(fruit);
        
        if (optionalContainer.isPresent()) {
            if (fruit.getPrice() >= 1 && fruit.getCount() >= 1) {
                return optionalContainer;
            } else {
                return Optional.empty();
            }
        } else {
            return Optional.empty();
        }

    }

    public Boolean optionalContainer02(Fruit fruit) {
        
        Optional<Fruit> optionalContainer= Optional.ofNullable(fruit);

       Optional<Fruit> optional = optionalContainer.filter(value-> value.getCount() > 5 && value.getPrice() <= 100
   );
       return optional.isPresent();
    }


    public Optional optionalContainer03(Fruit fruit) {

        Optional<String> optionalContainer= Optional.ofNullable(fruit.getType().getName());

        return optionalContainer;
    }


    }



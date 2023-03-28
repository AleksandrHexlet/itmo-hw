package ru.itmo.lesson06.task02;

public class Main {
    public static void main(String[] args) {

        Product product01 = new Product("Картошка", 12, 15, 25, 30);
        Product product02 = new Product("Bread", 3,4,5,6);
        Product product03 = new Product("Carrot",7,8,9,12);
        Product product04 = new Product("Chicken", 1, 5, 7, 9);


        AllowedProducts allowedProducts = new AllowedProducts();
        allowedProducts.addProduct(product02, 0);
        allowedProducts.addProduct(product03, 1);
        allowedProducts.addProduct(product04, 2);
        System.out.println("Разрешенные продукты : " + allowedProducts.toString());
        allowedProducts.addProduct(product01,3);


//        allowedProducts.addProduct(product01, 1);
    }
}


//
//Задача 2. Список разрешенных продуктов
//        Класс Продукт:
//        Свойства: название продукта / белки / жиры / углеводы / калории
//        Минимум 4 конструктора
//        Реализовать необходимые проверки входящих данных
//        Создать не менее 4 экземпляров данного класса
//        Класс МоиРазрешенныеПродукты:
//        Свойства: максимальное количество белков / максимальное количество жиров / максимальное количество углеводов / максимальное количество калорий / список продуктов (массив)
//        Реализовать метод, который принимает на Продукт и добавляет его в список (массив), если характеристики продукта полностью соответствуют заявленным разрешениям, в противном случае сообщить, по какой причине продукт не может быть добавлен в список (например, слишком большое содержание калорий)
//        Реализовать метод, который выводит названия всех продуктов из списка
//        При выполнении задания необходимо обращать внимание на модификаторы доступа и выполнять все необходимые проверки.
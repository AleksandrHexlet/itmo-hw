package ru.itmo.lesson13;

public class Main {
    public static void main(String[] args) {



    User<Number> user02= new User<>();
    User<String> user03= new User<>();
    PairContainer <Number, String> pairContainer01= new PairContainer<>(12, "Moscow and Saint-Petersburg");
    PairContainer <String,User<Number>> pairContainer02= new PairContainer<>("Ivan",user02);

    PairContainer <Number,User<String>> pairContainer03= new PairContainer<>(19,user03);
    PairContainer <String, PairContainer<Number,User<String>>> pairContainer04= new PairContainer<>("Igor",pairContainer03);


        System.out.println("result = " +  pairContainer01.getKey() );

        System.out.println("pairContainer01.getKey() = " + pairContainer01.getKey() + "; getValue() = " + pairContainer01.getValue());



    //    Объявить класс PairContainer со свойствами key и value. key и value - generic свойства без
//    ограничений, но могут быть разных типов.
//    Создать экземпляр PairContainer, где key - любые числа, value - строка
//    Создать экземпляр PairContainer, где key - строка, value - тип User, у которого id - любые числа
//    Создать экземпляр PairContainer, где key - строка, value - тип PairContainer, у которого key -
//    любые числа, value - тип User, у которого id - строка

}
}



//jjj
// interface Eatable extends Serializable{}
//  interface Runnable {}
//
//  class Animal implements Runnable{}
//
//  class Cat extends Animal implements Eatable{}
//  class Kitten extends Cat{}
//
//  class Dog extends Animal implements Serializable{}
//
//
//  class Task {
//     public static  <T extends Cat & Eatable> void void01(T object){
//         // ВОПРОС: методы каких типов можно вызвать у object ???
//          Ответ : только  Kitten
//     }
//
//     public static  <T extends Animal & Serializable> void void02(T object){
//        // ВОПРОС: методы каких типов можно вызвать у object ???
//          Ответ : только  методы Dog
//     }
//
//     public static  <T extends Serializable & Runnable> void void03(T object){
//        // ВОПРОС: методы каких типов можно вызвать у object ???
//             Ответ :  методы CAT  Kitten Dog
//     }
//
//     public static void main(String[] args) {
//        Task.</* ВОПРОС: какие типы можно указать ??? */>void01(/* ВОПРОС: какие типы можно передать ??? */);
//        Ответ : только  Kitten
//
//
//
//        Task.</* ВОПРОС: какие типы можно указать ??? */>void02(/* ВОПРОС: какие типы можно передать ??? */);
//         Ответ : только  методы Dog
//
//        Task.<Dog>void03(/* ВОПРОС: какие типы можно передать ??? */);
//         Ответ :  методы CAT  Kitten Dog
//
//        }

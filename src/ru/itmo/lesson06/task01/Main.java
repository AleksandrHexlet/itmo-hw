package ru.itmo.lesson06.task01;

public class Main {
    public static void main(String[] args) {
        Groups groups01 = new Groups();
        Groups groups02 = new Groups();
        Groups groups03 = new Groups();

        Mountain mountain01 = new Mountain("Эльбрус","Россия",4567);
        Mountain mountain02 = new Mountain("Фудзияма", "Япония", 3456 );
        Mountain mountain03 = new Mountain("Эверест", "Бутан",2345);

        Climber climber01 = new Climber("Иван","Россия, Новосибирск");
        Climber climber02 = new Climber("Степан","Россия, Калиниград");
        Climber climber03 = new Climber("Павел","Россия,Владивосток");
        Climber climber04 = new Climber("Даниил","Россия, Москва");
        Climber climber05 = new Climber("Захар","Россия, Санкт-Петербург");



        groups01.setMountain(mountain01);
        groups02.setMountain(mountain02);
        groups03.setMountain(mountain03);


        groups01.addClimber(climber04);
        groups01.addClimber(climber02);
        groups01.addClimber(climber03);
        groups01.setOpen(false);

        groups02.addClimber(climber05);
        groups02.addClimber(climber03);
        groups02.setOpen(true);

        groups03.addClimber(climber01);
        groups03.addClimber(climber05);
        groups03.setOpen(true);

        System.out.println("groups03 : " + groups03.toString());
        System.out.println("groups02 : " +  groups02.toString());
        System.out.println("groups01 : " + groups01.toString());
    }
}


/*
//Задача 1. Описать объектную модель Альпинист, Гора, Группа для восхождения на гору.
//        Альпинист создаётся с именем (не менее 3 символов) и адресом проживания (не менее 5 символов).
//        Гора создаётся с названием (не менее 4 символов), страной (не менее 4 символов) и высотой (не менее 100 метров)
//        Группа для восхождения на гору создаётся со следующими характеристиками и возможностями:
//        идёт набор в группу или нет;
//        массив альпинистов;
//        гора;
//        должна быть возможность добавить альпиниста в группу (в массив), если набор ещё идёт
//        В методе main (отдельного класса) создать:
//        3 группы для восхождений на 3 различных горы.
//        В первой группе 3 альпиниста (набор закрыт)
//        Во второй и третьей группах по 2 альпиниста (набор в эти группы открыт)
//        При выполнении задания необходимо обращать внимание на модификаторы доступа и выполнять все необходимые проверки.
 */
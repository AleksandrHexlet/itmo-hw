package ru.itmo.lesson06.task01;

public class Main {
    public static void main(String[] args) {
        Groups groups01 = new Groups();
        Groups groups02 = new Groups();
        Groups groups03 = new Groups();

        Mountain mountain01 = new Mountain();
        Mountain mountain02 = new Mountain();
        Mountain mountain03 = new Mountain();

        Climber climber01 = new Climber();
        Climber climber02 = new Climber();
        Climber climber03 = new Climber();

        climber01.setAddress("Moscow, Neglinnaya");
        climber02.setAddress("Moscow, Arbat");
        climber03.setAddress("Moscow, Tverskaya");

        climber01.setName("Igor");
        climber02.setName("Ivan");
        climber03.setName("Petr");

        mountain01.setCountry("Russia");
        mountain02.setCountry("Nepal");
        mountain03.setCountry("Espana");

        mountain01.setName("Elbrus");
        mountain02.setName("Nepal_mount");
        mountain03.setName("Espana_mount");

        groups01.setMountain(mountain01);
        groups02.setMountain(mountain02);
        groups03.setMountain(mountain03);


        groups01.addClimber(climber01,1);
        groups01.addClimber(climber02,2);
        groups01.addClimber(climber03,3);
        groups01.setOpen(false);

        groups02.addClimber(climber01,1);
        groups02.addClimber(climber02,2);
        groups02.setOpen(true);

        groups03.addClimber(climber01,1);
        groups03.addClimber(climber02,2);
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
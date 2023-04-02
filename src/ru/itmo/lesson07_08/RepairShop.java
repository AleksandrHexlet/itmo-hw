package ru.itmo.lesson07_08;


import ru.itmo.lesson07_08.interfaces.ITransport;
import ru.itmo.lesson07_08.transport.Car;


import java.util.Arrays;

public class RepairShop {
    private ITransport[] vehiclesArr = new ITransport[10];
    private String[] colorArr = {"Red","Blu","Green","Orange","Black","White","Gold"};
    private int count = 0;

    public void addVehicles(ITransport transport){

        if(count < vehiclesArr.length) {
            vehiclesArr[count] = transport;
            count++;
        } else {
            System.out.println("Мастерская заполненна. Свободных мест нет");
        }
        System.out.println("Транспорт добавлен. Парк состоит из: " +Arrays.toString(vehiclesArr));

    }


    public void transportRepair() {
        for (int i = 0; i < vehiclesArr.length; i++) {
            int repair = (int) (Math.random() * 99);
            if (vehiclesArr[i]  != null) vehiclesArr[i].transportRepair(repair);
            if (vehiclesArr[i]  instanceof Car) {
                ((Car) vehiclesArr[i] ).setColor(colorArr[(int) (Math.random() * 7)]);
            }
            vehiclesArr[i] = null;
        }
        System.out.println("Все машины прошли ремонт. Парк состоит из: " +Arrays.toString(vehiclesArr));

    }

    @Override
    public String toString() {
        return "RepairShop{" +
                "vehiclesArr=" + Arrays.toString(vehiclesArr) +
                ", colorArr=" + Arrays.toString(colorArr) +
                ", count=" + count +
                '}';
    }
}


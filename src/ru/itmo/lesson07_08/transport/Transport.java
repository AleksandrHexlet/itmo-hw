package ru.itmo.lesson07_08.transport;

public class Transport {

    protected int iznosLevel;
    protected final int transportNumber;



    public Transport(int iznosLevel, int transportNumber) {
        this.iznosLevel = iznosLevel;
        this.transportNumber = transportNumber;

    }
}


//
//
//1. Нужен родительский класс для транспорта, в него нужно выносить общие свойства и методы
//        2. в методе transportRepair можно было не определять каждый тип данных,
//        а вычислить восстановление износа через рандом или прописать уровень восстановления в самих классах.
//        3. классу Car нужно добавить интерфейс ColorChangeAble и вызывать метод
//        setColor, если объект относится к данному типу. Отдельно у машины не нужно вызывать setColor
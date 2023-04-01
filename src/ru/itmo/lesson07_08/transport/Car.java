package ru.itmo.lesson07_08.transport;

import ru.itmo.lesson07_08.interfaces.ITransport;

public class Car implements ITransport {

    private int iznosLevel;
    private final int transportNumber;
    private String color;

    public Car(int iznosLevel, int transportNumber, String color) {
        this.iznosLevel = iznosLevel;
        this.transportNumber = transportNumber;
        this.color = color;
    }

    @Override
    public void transportRepair(int repearLevel) {
        if (repearLevel >= 0 && this.iznosLevel>=repearLevel )
        {
            this.iznosLevel = this.iznosLevel - repearLevel;
        } else {
            this.iznosLevel = 0;
        }
    }

    public void setColor(String color) {

       if(color.length() > 0) this.color = color;
    }

    @Override
    public String toString() {
        return "Car{" +
                "iznosLevel=" + iznosLevel +
                ", transportNumber=" + transportNumber +
                ", color='" + color + '\'' +
                '}';
    }
}




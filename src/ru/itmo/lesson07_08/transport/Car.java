package ru.itmo.lesson07_08.transport;

import ru.itmo.lesson07_08.interfaces.ColorChangeAble;
import ru.itmo.lesson07_08.interfaces.ITransport;

public class Car  extends  Transport implements ITransport, ColorChangeAble {

//    3. классу Car нужно добавить интерфейс ColorChangeAble
//    и вызывать метод setColor, если объект относится к данному типу. Отдельно у машины не нужно вызывать setColor
    private String color;

    public Car(int iznosLevel, int transportNumber, String color) {
        super(iznosLevel, transportNumber);
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

    @Override
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




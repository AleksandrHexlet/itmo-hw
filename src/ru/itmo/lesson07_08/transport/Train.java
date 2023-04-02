package ru.itmo.lesson07_08.transport;

import ru.itmo.lesson07_08.interfaces.ITransport;

public class Train extends  Transport implements ITransport {
//    private int iznosLevel;
//    private final int transportNumber;
    private String color = "Green";
    private int countWagons;


    public void setNumberWagons(int countWagons) {
        if (countWagons >= 0) this.countWagons = countWagons;
    }

    public Train(int iznosLevel, int transportNumber, int countWagons) {
        super(iznosLevel, transportNumber);
        this.iznosLevel = iznosLevel;

        this.countWagons = countWagons;
    }


    @Override
    public void transportRepair(int repearLevel) {
        if (repearLevel >= 0 && this.iznosLevel >= repearLevel) {
            this.iznosLevel = this.iznosLevel - repearLevel;
        } else {
            this.iznosLevel = 0;
        }

    }

    @Override
    public String toString() {
        return "Train{" +
                "iznosLevel=" + iznosLevel +
                ", transportNumber=" + transportNumber +
                ", color='" + color + '\'' +
                ", countWagons=" + countWagons +
                '}';
    }
}


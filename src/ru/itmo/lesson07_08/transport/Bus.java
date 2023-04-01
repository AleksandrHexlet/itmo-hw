package ru.itmo.lesson07_08.transport;

import ru.itmo.lesson07_08.interfaces.ITransport;

public class Bus implements ITransport {

    private int iznosLevel;
    private final int transportNumber;
    private final String color;

    private boolean isWiFi;

    public Bus(int iznosLevel, int transportNumber, String color,  boolean isWiFi) {
        this.iznosLevel = iznosLevel;
        this.transportNumber = transportNumber;
        this.color = color;
        this.isWiFi = isWiFi;
    }


    @Override
    public void transportRepair(int repearLevel) {
        if (repearLevel >= 0 && this.iznosLevel >= repearLevel) {
            this.iznosLevel = this.iznosLevel - repearLevel;
            isWiFi = true;
        } else {
            this.iznosLevel = 0;
        }

    }

    @Override
    public String toString() {
        return "Bus{" +
                "iznosLevel=" + iznosLevel +
                ", transportNumber=" + transportNumber +
                ", color='" + color + '\'' +
                ", isWiFi=" + isWiFi +
                '}';
    }
}


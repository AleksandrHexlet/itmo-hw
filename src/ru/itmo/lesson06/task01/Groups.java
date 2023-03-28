package ru.itmo.lesson06.task01;

import java.util.Arrays;

public class Groups {
    private boolean isOpen = true;
    private Climber[] climberArr = new Climber[5];
    private Mountain mountain;


    public void setOpen(boolean open) {
        isOpen = open;
    }


    public void setMountain(Mountain mountain) {
        this.mountain = mountain;
    }

    public void addClimber(Climber climber, int number){
                if (isOpen && climberArr[number] == null) {
                    climberArr[number] = climber;
                }else {
                    isOpen = false;
                    throw new ArrayIndexOutOfBoundsException("Превышен размер массива");


            }
        }

    @Override
    public String toString() {
        return "Groups{" +
                "isOpen=" + isOpen +
                ", climberArr=" + Arrays.toString(climberArr) +
                ", mountain=" + mountain +
                '}';
    }
}






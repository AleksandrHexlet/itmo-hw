package ru.itmo.lesson15.task.task02.Utils;

import java.util.Comparator;
import java.util.Map;

public class ValuesComparator implements Comparator<Map.Entry<String,Integer>> {

    @Override
    public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
        if(o1.getValue().equals(o2.getValue())) return 0;
        if(o1.getValue() > (o2.getValue())){
            return -1;
        } else return 1;

    }
}


package ru.itmo.lesson09.utils;

import ru.itmo.lesson09.interfaces.СommonInterface;

abstract public class ParentUtils implements СommonInterface{
    public ParentUtils(СommonInterface сommonInterface) {
        this.сommonInterface = сommonInterface;
    }

    String str;
    СommonInterface сommonInterface;
}

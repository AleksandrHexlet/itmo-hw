package ru.itmo.lesson09.utils;

import ru.itmo.lesson09.interfaces.CommonInterface;

abstract public class ParentUtils implements CommonInterface{
    public ParentUtils(CommonInterface сommonInterface) {
        this.сommonInterface = сommonInterface;
    }

    String str;
    CommonInterface сommonInterface;
}

package ru.itmo.lesson09.utils;

import ru.itmo.lesson09.AppFileWriter;
import ru.itmo.lesson09.interfaces.CommonInterface;

public class Upper extends ParentUtils implements CommonInterface {




    public Upper(CommonInterface сommonInterfaceOUT) {
        super(сommonInterfaceOUT);
    }

    @Override
    public void log(String strOUT) {
        str = strOUT.toUpperCase();

        сommonInterface.log(str);

    };
}

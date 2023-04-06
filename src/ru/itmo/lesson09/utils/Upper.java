package ru.itmo.lesson09.utils;

import ru.itmo.lesson09.AppFileWriter;
import ru.itmo.lesson09.interfaces.СommonInterface;

public class Upper extends ParentUtils implements СommonInterface {




    public Upper(СommonInterface сommonInterfaceOUT) {
        super(сommonInterfaceOUT);
    }

    @Override
    public void log(String strOUT) {
        str = strOUT.toUpperCase();

        сommonInterface.log(str);

    };
}

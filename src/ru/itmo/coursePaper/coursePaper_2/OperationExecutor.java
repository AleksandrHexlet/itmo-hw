package ru.itmo.coursePaper.coursePaper_2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OperationExecutor {
    private Map<String, Command> commandMap = new HashMap<>();

    public void executeOperation(Command command) {
        commandMap.put("userLogin", command);
        command.execute();
    }
}

package ru.itmo.coursePaper.coursePaper_2;

public class ClientLogic {

    public void start(){
        OperationExecutor operationExecutor = new OperationExecutor();
        GameApp clientCommand = new GameApp();
        operationExecutor.executeOperation(clientCommand::startGame);

    }
}

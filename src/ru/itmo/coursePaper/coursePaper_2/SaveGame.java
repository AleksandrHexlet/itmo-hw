package ru.itmo.coursePaper.coursePaper_2;

import ru.itmo.coursePaper.coursePaper_2.utils.UtilsMethod;

public class SaveGame implements Command{

    Paragraph paragraph;
    GameApp gameApp;
//    private String paragraphName = "";
//    String gameState = "";
//    StartGame startGame;
//public SaveGame( StartGame startGame, String gameState, ){
//
//}
public  SaveGame (Paragraph paragraph, GameApp gameApp){
    this.paragraph = paragraph;
    this.gameApp= gameApp;
};
    OperationExecutor operationExecutor = new OperationExecutor();
    UtilsMethod utilsMethod = new UtilsMethod();
    @Override
    public void execute() {
        gameApp.gameState = paragraph;
        gameApp.start();
//        utilsMethod.setGameState(utilsMethod.getParagraphName());
        System.out.println("�� ��������� ����. ������ �� ������ ���������� ����.");

//        operationExecutor.executeOperation(new StartGame());
    }
}

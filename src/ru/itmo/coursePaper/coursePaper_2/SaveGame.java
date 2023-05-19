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
    @Override
    public void execute() {
        gameApp.gameState = paragraph;
        gameApp.start();

        System.out.println("Вы сохранили игру. Теперь вы можете продолжить игру.");

    }
}

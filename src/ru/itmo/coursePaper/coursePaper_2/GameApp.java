package ru.itmo.coursePaper.coursePaper_2;

import ru.itmo.coursePaper.coursePaper_2.utils.UtilsMethod;

import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class GameApp {
    StartGame startGame = new StartGame();
    GameApp linkGameApp;
    Paragraph gameState = new Data().getFox();


    private boolean isStartingGame = false;
    int userAnswer;
    //    Scanner scanner = new Scanner(System.in);
    UtilsMethod utilsMethod = new UtilsMethod();
    private String paragraphName = "";


    public void getLink(GameApp gameApp) {
        linkGameApp = gameApp;
    }

    public void start() {

        OperationExecutor operationExecutor = new OperationExecutor();
        operationExecutor.executeOperation(startGame);

        userAnswer = utilsMethod.scanner();

        if (userAnswer == 1) {
           if(gameState != null) System.out.println("������ ���� gameState = " + gameState.getName());
            isStartingGame = true;
           utilsMethod.drowParagraph(gameState, linkGameApp);
        } else if (userAnswer == 2) {
            if(gameState != null) System.out.println("load ���� gameState = " + gameState.getName());
            isStartingGame = true;
            utilsMethod.drowParagraph(gameState, linkGameApp);
        } else if (userAnswer == 3) {
            if(isStartingGame){
                System.out.println("���� ���������");
            } else{
                System.out.println("�� ����� �� ����");
                return;
            }

            if(gameState != null) System.out.println("��������� ���� gameState = " + this.gameState.getName());

            linkGameApp.start();
        } else if (userAnswer == 4 && isStartingGame == true) {
            System.out.println("�� ����� �� ����");
            return;
        } else if (userAnswer == 4 && isStartingGame == false) {
            System.out.println("�� ������ �������. ������� ���� �����");
            isStartingGame = true;
            linkGameApp.start();
        }


    }


    //        "1. ������ ����\n" +
//                "2. ��������� ����\n" +
//                "3. �����\n" +
//                "4. ��������� ����");
//    } else {
//        System.out.println("����:\n" +
//
//                "1. ������ ����\n" +
//                "2. ��������� ����\n" +
//                "3. ����� ");


}

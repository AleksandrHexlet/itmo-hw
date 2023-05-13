package ru.itmo.coursePaper.coursePaper_2;

import ru.itmo.coursePaper.coursePaper_2.utils.UtilsMethod;

import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class GameApp {

    Map<String, Command> commandMap = new HashMap<>();
    String gameState = "";
    private boolean isStartingGame = false;
    int userAnswer;
//    Scanner scanner = new Scanner(System.in);
    UtilsMethod utilsMethod = new UtilsMethod();
    private String paragraphName = "";


    public void downloadGame() {
        if (gameState != ""){
            userChoiseParagraf(gameState);
        } else{
            System.out.println("�� ������� ��������� ����, ������ ����� ������ ����");
            isStartingGame = false;
            startGame();
        }
    }

    public void saveGame() {
        gameState = paragraphName;
        System.out.println("�� ��������� ����. ������ �� ������ ���������� ����.");
        startGame();


    }


    public void startGame() {

        System.out.println("��� ������ ������� ����� ���������� ������ ����.");
        if (isStartingGame) {
            System.out.println("����:\n" +

                    "1. ������ ����\n" +
                    "2. ��������� ����\n" +
                    "3. �����\n" +
                    "4. ��������� ����");
        } else {
            System.out.println("����:\n" +

                    "1. ������ ����\n" +
                    "2. ��������� ����\n" +
                    "3. ����� ");

        }
        userAnswer =  utilsMethod.scanner();
        isStartingGame = utilsMethod.isCorrectAnswer(userAnswer,"menu");
        if (isStartingGame == true) {
            executeCommand(userAnswer);
        } else {
            startGame();
        }
    }

    public void executeCommand(int userChoise) {
        if (userChoise == 1) {
            userChoiseParagraf("fox");
        } else {
            if (userChoise == 2) {
                downloadGame();
            } else {
                if (userChoise == 3) {
                    System.out.println("�� ����� �� ����.");
                } else {
                    saveGame();
                }
            }
        }
    }
    public void userChoiseParagraf(String first_drawing) {
        paragraphName = first_drawing;
        String paragraphText = "";
        String first_menu_item = "";
        String second_menu_item = "";
        String  program_partition_name = "paragraph";

        Paragraph paragraph = new Paragraph();

        while(isStartingGame && first_menu_item !="end_game" && second_menu_item != "end_game"){

         if(first_menu_item != "") {
             userAnswer = utilsMethod.scanner();

             isStartingGame = utilsMethod.isCorrectAnswer(userAnswer, program_partition_name);

             if (isStartingGame == false) return;
             if (userAnswer == 3) {
                 startGame();
                 return;
             }
         }
            if(first_menu_item !="" && second_menu_item !=""){
                paragraphName = userAnswer == 1 ? first_menu_item : second_menu_item;
                gameState = paragraphName;
            }

            ArrayList<String> paragraphList = paragraph.getParagraph(paragraphName);

            paragraphText = paragraphList.get(0);
            first_menu_item= paragraphList.get(1);
            second_menu_item = paragraphList.get(2);
            System.out.println(paragraphText);

        }


    }


}

/*
������������ ������������ ����� ��������� � 2 �������� ������� (�������� ������ ����������). � ����������� �� ������ ������������, ��� ������������ ����� ���������� ��������� � ���������� �� ��������� ����, ���� �������� ��� �������������.

���� ������ ���� ����������� � ������� �������� �������, ��� ������ ����� ���� - ��������� �������.

����:

������ ���� (������ ��������� ����������)
��������� ����
�����
����� ������ ���� ������ ���� ����������� ����� � ���� ��� ���� � ���� ���������� ����� ����� '��������� ����'.

����� ������������ �������� ����� '��������� ����', ��������� ���� ���������� ��������� � ���� � ��������������� ��� ������ ������ '��������� ����'.

���������-���� � ����� '����-�-��������.png' ��������, ����� ����������-����� � �������� ������� � ����� '�����-����������.md'
 */
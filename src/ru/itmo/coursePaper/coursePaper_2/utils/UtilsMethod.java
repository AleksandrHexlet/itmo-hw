package ru.itmo.coursePaper.coursePaper_2.utils;

import ru.itmo.coursePaper.coursePaper_2.GameApp;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UtilsMethod {

    private boolean isStartingGame = false;


    String paragraph = "paragraph";
    public boolean isCorrectAnswer(int userAnswer,String program_partition_name){
        if (isStartingGame == false && program_partition_name == "menu" && userAnswer > 3 || userAnswer < 1){
            isStartingGame = false;
            System.out.println("������ ������ ���� �� ����������. �������� ����� ��� ���");


            //��� �� ������ ������ ������ �� ���� ������ ��� �������� ����, �����
            // ������ ��� ����� ��������� � ������������ ������ ��������
            return isStartingGame;
        }
        if (isStartingGame == true && program_partition_name == "menu" && userAnswer > 4 || userAnswer < 1){
            isStartingGame = false;
            System.out.println("������ ������ ���� �� ����������. �������� ����� ��� ���");


            return isStartingGame;
        }
        if (isStartingGame == true && program_partition_name == "paragraph" && userAnswer > 4 || userAnswer < 1){
            isStartingGame = false;
            System.out.println("������ ������ ���� �� ����������. �������� ����� ��� ���");


            return isStartingGame;
        }
        isStartingGame = true;
        return isStartingGame;
    }

    public int scanner(){
        int userAnswer = -1;
        Scanner scanner = new Scanner(System.in);
        System.out.println("��� ������ ������� ����� ���������� ������ ����.");
        try {
            userAnswer = scanner.nextInt();
        } catch (InputMismatchException exception) {
            System.out.println(exception.fillInStackTrace());

        }
        return userAnswer;
    }

}

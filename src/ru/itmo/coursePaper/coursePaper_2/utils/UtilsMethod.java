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
            System.out.println("Такого пункта меню не существует. Сделайте выбор ещё раз");


            //при не верном выборе пункта не надо каждый раз печатать меню, лучше
            // каждый раз брать состояние и отрисовывать нужный параграф
            return isStartingGame;
        }
        if (isStartingGame == true && program_partition_name == "menu" && userAnswer > 4 || userAnswer < 1){
            isStartingGame = false;
            System.out.println("Такого пункта меню не существует. Сделайте выбор ещё раз");


            return isStartingGame;
        }
        if (isStartingGame == true && program_partition_name == "paragraph" && userAnswer > 4 || userAnswer < 1){
            isStartingGame = false;
            System.out.println("Такого пункта меню не существует. Сделайте выбор ещё раз");


            return isStartingGame;
        }
        isStartingGame = true;
        return isStartingGame;
    }

    public int scanner(){
        int userAnswer = -1;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Для выбора введите цифру выбранного пункта меню.");
        try {
            userAnswer = scanner.nextInt();
        } catch (InputMismatchException exception) {
            System.out.println(exception.fillInStackTrace());

        }
        return userAnswer;
    }

}

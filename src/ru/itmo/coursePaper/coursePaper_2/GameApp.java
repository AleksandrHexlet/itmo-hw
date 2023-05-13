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
            System.out.println("Вы сможите сохранить игру, только после начала игры");
            isStartingGame = false;
            startGame();
        }
    }

    public void saveGame() {
        gameState = paragraphName;
        System.out.println("Вы сохранили игру. Теперь вы можете продолжить игру.");
        startGame();


    }


    public void startGame() {

        System.out.println("Для выбора введите цифру выбранного пункта меню.");
        if (isStartingGame) {
            System.out.println("Меню:\n" +

                    "1. Начать игру\n" +
                    "2. Загрузить игру\n" +
                    "3. Выйти\n" +
                    "4. Сохранить игру");
        } else {
            System.out.println("Меню:\n" +

                    "1. Начать игру\n" +
                    "2. Загрузить игру\n" +
                    "3. Выйти ");

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
                    System.out.println("Вы вышли из игры.");
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
Пользователю отображается текст параграфа и 2 варианта ответов (названия других параграфов). В зависимости от выбора пользователя, ему отображается текст выбранного параграфа и информация об окончании игры, если параграф это подразумевает.

Меню должно быть реализовано с помощью паттерна Команда, где каждый пункт меню - отдельная команда.

Меню:

Начать игру (начало отрисовки параграфов)
Загрузить игру
Выйти
После начала игры должна быть возможность выйти в меню при этом в меню появляется новый пункт 'Сохранить игру'.

Когда пользователь выбирает пункт 'Сохранить игру', состояние игры необходимо сохранять в файл и восстанавливать при выборе пункта 'Загрузить игру'.

Параграфы-узлы в файле 'узлы-и-переходы.png' Названия, текст параграфов-узлов и варианты ответов в файле 'текст-параграфов.md'
 */
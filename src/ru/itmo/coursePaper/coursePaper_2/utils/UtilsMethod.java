package ru.itmo.coursePaper.coursePaper_2.utils;

import ru.itmo.coursePaper.coursePaper_2.*;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UtilsMethod {

    OperationExecutor operationExecutor = new OperationExecutor();
//    private boolean isStartingGame = false;

    Paragraph currentParagraph;
    Data data = new Data();

    String gameState = "";

    int userAnswer;
    //    Scanner scanner = new Scanner(System.in);

    private String paragraphName = "";
//
//    public boolean isStartingGame() {
//        return isStartingGame;
//    }
//
//    public void setStartingGame(boolean startingGame) {
//        isStartingGame = startingGame;
//    }


    public String getGameState() {
        return gameState;
    }

    public void setGameState(String gameState) {
        this.gameState = gameState;
    }

    public int getUserAnswer() {
        return userAnswer;
    }

    public void setUserAnswer(int userAnswer) {
        this.userAnswer = userAnswer;
    }


    public String getParagraphName() {
        return paragraphName;
    }

    public void setParagraphName(String paragraphName) {
        this.paragraphName = paragraphName;
    }

//    public void executeCommand(int userChoise) {
//        if (userChoise == 1) {
//            userChoiseParagraf("fox");
//        } else {
//            if (userChoise == 2) {
//                operationExecutor.executeOperation(new DownloadGame());
//            } else {
//                if (userChoise == 3) {
//                    System.out.println("Вы вышли из игры.");
//                } else {
//                    operationExecutor.executeOperation(new SaveGame());
//                    ;
//                }
//            }
//        }
//    }


    public void drowParagraph(Paragraph paragraph, GameApp gameApp) {

        currentParagraph = paragraph;
        System.out.println("currentParagraph = " + currentParagraph.getName());
        while (true) {
            System.out.println(currentParagraph.getText());
            if (currentParagraph.getName() == "end_game" || currentParagraph.answer_1.getName() == "end_game"
                    || currentParagraph.answer_2.getName() == "end_game") {
                System.out.println("Игра закончилась");
                return;
            }
            int answer = scanner();
            if (answer == 1) {

                currentParagraph = currentParagraph.answer_1;

            } else if (answer == 2) {

                currentParagraph = currentParagraph.answer_2;
            } else if (answer == 3) {
                operationExecutor.executeOperation(new SaveGame(currentParagraph, gameApp));


            }
            System.out.println("currentParagraph in while = " + currentParagraph.getName());
        }
    }


    public int scanner() {
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


//
//    // Продолжи с userChoiseParagraf. Параграфы содержат ссылки на ответы.
//    public void userChoiseParagraf(Paragraph paragraph) {
//        paragraphName = paragraph.getName();
//        String paragraphText = paragraph.getText();
//        Paragraph first_menu_item = paragraph.getAnswer_1();
//        Paragraph second_menu_item = paragraph.getAnswer_2();
//        String program_partition_name = "paragraph";
//
//
//        while (isStartingGame && paragraphName != "end_game") {
//
//            if (first_menu_item != "") {
//                userAnswer = utilsMethod.scanner();
//
//                isStartingGame = utilsMethod.isCorrectAnswer(userAnswer, program_partition_name);
//
//                if (isStartingGame == false) return;
//                if (userAnswer == 3) {
//                    operationExecutor.executeOperation(new StartGame());
//                    return;
//                }
//            }
//            if (first_menu_item != "" && second_menu_item != "") {
//                paragraphName = userAnswer == 1 ? first_menu_item : second_menu_item;
//                gameState = paragraphName;
//            }
//
//            ArrayList<String> paragraphList = paragraph.getParagraph(paragraphName);
//
//            paragraphText = paragraphList.get(0);
//            first_menu_item = paragraphList.get(1);
//            second_menu_item = paragraphList.get(2);
//            System.out.println(paragraphText);
//
//        }
//
//
//    }
//
//    public boolean isCorrectAnswer(int userAnswer, String program_partition_name) {
//        if (isStartingGame == false && program_partition_name == "menu" && userAnswer > 3 || userAnswer < 1) {
//            isStartingGame = false;
//            System.out.println("Такого пункта меню не существует. Сделайте выбор ещё раз");
//
//
//            //при не верном выборе пункта не надо каждый раз печатать меню, лучше
//            // каждый раз брать состояние и отрисовывать нужный параграф
//            return isStartingGame;
//        }
//        if (isStartingGame == true && program_partition_name == "menu" && userAnswer > 4 || userAnswer < 1) {
//            isStartingGame = false;
//            System.out.println("Такого пункта меню не существует. Сделайте выбор ещё раз");
//
//
//            return isStartingGame;
//        }
//        if (isStartingGame == true && program_partition_name == "paragraph" && userAnswer > 4 || userAnswer < 1) {
//            isStartingGame = false;
//            System.out.println("Такого пункта меню не существует. Сделайте выбор ещё раз");
//
//
//            return isStartingGame;
//        }
//        isStartingGame = true;
//        return isStartingGame;
//    }
//


}

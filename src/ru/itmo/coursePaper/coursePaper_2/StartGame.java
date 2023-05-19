package ru.itmo.coursePaper.coursePaper_2;

import ru.itmo.coursePaper.coursePaper_2.utils.UtilsMethod;

public class StartGame implements Command {
    OperationExecutor operationExecutor = new OperationExecutor();
    UtilsMethod utilsMethod = new UtilsMethod();
    private boolean isStartingGame = false;

    public void setStartingGame(boolean startingGame) {
        isStartingGame = startingGame;
    }

    public boolean isStartingGame() {
        return isStartingGame;
    }

    @Override
    public void execute() {

        System.out.println("Для выбора введите цифру выбранного пункта меню.");
        System.out.println("isStartingGame = " + isStartingGame);
        if (isStartingGame) {
            System.out.println("Меню:\n" +

                    "1. Начать игру\n" +
                    "2. Загрузить игру\n" +
                    "3. Сохранить игру \n" +
                    "4. Выйти\n"
            );
        } else {

            System.out.println("Меню:\n" +

                    "1. Начать игру\n" +
                    "2. Загрузить игру\n" +
                    "3. Выйти ");

        }
        isStartingGame = true;
    }
}

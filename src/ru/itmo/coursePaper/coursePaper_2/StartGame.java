package src.ru.itmo.coursePaper.coursePaper_2;



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

        System.out.println("��� ������ ������� ����� ���������� ������ ����.");
        System.out.println("isStartingGame = " + isStartingGame);
        if (isStartingGame) {
            System.out.println("����:\n" +

                    "1. ������ ����\n" +
                    "2. ��������� ����\n" +
                    "3. ��������� ���� \n" +
                    "4. �����\n"
            );
        } else {

            System.out.println("����:\n" +

                    "1. ������ ����\n" +
                    "2. ��������� ����\n" +
                    "3. ����� ");

        }
        isStartingGame = true;
    }
}

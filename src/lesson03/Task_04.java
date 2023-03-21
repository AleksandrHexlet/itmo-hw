package lesson03;

import java.util.Scanner;

public class Task_04 {
    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите целое положительное число от 2 до 100");
        int userNumber = scanner.nextInt();

        int maxNumber = 100;
        int minNumber = 0;
        int middleNum = maxNumber / 2;


        if (userNumber < 2 || userNumber > 99) {
            System.out.println("Вы ввели число меньше 2 или больше 99");
            return;
        }


        while (true) {
            System.out.println("Ваше число равно: " + middleNum + " ?");
            int answer = scanner.nextInt();

            if (answer == 1) {
                System.out.println("Я умная. Я угадала :)");
                break;
            }

            System.out.println("Ваше число  больше ? ");
            int isBigger = scanner.nextInt();

            if (isBigger == 1) {
                minNumber = middleNum;

                middleNum = minNumber + (maxNumber - middleNum) / 2;
                System.out.println("Больше; minNumber" + minNumber + "; middleNum " + middleNum + "; maxNumber" + maxNumber);
            }
            if (isBigger == 0) {
                maxNumber = middleNum;
                minNumber = middleNum / 2 > 0 ? middleNum / 2 : 0;
                middleNum = minNumber + (maxNumber - minNumber) / 2;
                System.out.println("Меньше; minNumber" + minNumber + "; middleNum " + middleNum + "; maxNumber" + maxNumber);
//                  middleNum = middleNum - middleNum /4;

                if (middleNum == 1 || maxNumber == 100) {
                    System.out.println("Что-то пошло не так. Попробуйте ещё раз !!!");
                    break;
                }
            }
        }

    }


}


//Задача  № 4  на использование любого цикла (выберите сами) ***
//        Пользователь загадывает число в диапазоне от [2 до 100]
//        Программа пытается его угадать (используйте метод бинарного поиска, т.е деление отрезка на 2).
//        Программа может задавать пользователю вопросы: Число равно ...?, Число больше ...? и в зависимоти от ответа пользователя принимать решения.
//        Вместо текстовых ответов ДА/НЕТ, используйте числа 0 - НЕТ и 1 - ДА
//        */
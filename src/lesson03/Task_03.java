package lesson03;

import java.util.Scanner;

public class Task_03 {
    public static void main(String[] args) {
        int min = 1;
        int max = 9;

        max -= min;
        int randomNumber = (int) (Math.random() * ++max) + min;
        System.out.println("randomNumber = " + randomNumber);
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Введите ваше число: ");
            int userNum = scanner.nextInt();
            if (randomNumber == userNum || userNum == 0) {
                System.out.println("Вы угадали. Супер !!!");
                break;
            }

            String answer = randomNumber > userNum ? "загаданное число больше" : "загаданное число меньше";
            System.out.println(answer);
        }


    }


}


//Задача № 3 на использование любого цикла (выберите сами)
//        Программа загадывает число в диапазоне [1;9]
//        Пользователь вводит число с клавиатуры
//        Программа в зависимости от введенного числа выводит в консоль следующее:
//        "загаданное число больше"
//        "загаданное число меньше"
//        "Вы угадали" (программа завершает работу)
//        Если введен 0, выввести "выход из программы" (программа завершает работу)

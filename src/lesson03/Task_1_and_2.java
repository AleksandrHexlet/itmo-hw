package lesson03;

import java.util.ArrayList;
import java.util.Scanner;

public class Task_1_and_2 {
    public static void main(String[] args) {
//        Задача  № 1

        for (int i = 2; i < 22; i = i + 2) {
            System.out.println("Число равно = " + i);
        }

        //        Задача  № 2
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите целое положительное число от 10 до 1000");
        int userNumber = scanner.nextInt();
        int result = 0;
        if (userNumber < 10 || userNumber > 999 ) {
            System.out.println("Вы ввели число меньше 10 или больше 1000");
        } else if (userNumber < 100) {
            result = userNumber / 10 + userNumber % 10;
            System.out.println("Сумма цифр введенного вами числа равна:  " + result);
        } else if (userNumber < 1000) {
            int firstNum = userNumber / 100;
            int secondNum = (userNumber / 10) % 10;
            int thirdNum = userNumber % 10;
            result = firstNum + secondNum + thirdNum;
            System.out.println("firstNum = " + firstNum + ";  secondNum = " + secondNum + "; thirdNum = " + thirdNum);
            System.out.println("Сумма цифр введенного вами числа равна:  " + result);
        }


    }
}


/*
Задачи  № 1 на FOR
Вывести на экран первые 10 элементов последовательности 2 4 6 8 10 и тд
Задача № 2 на WHILE
Для введённого пользователем с клавиатуры целого положительного числа посчитайте сумму всех его цифр

Задача № 3 на использование любого цикла (выберите сами)
Программа загадывает число в диапазоне [1;9]
Пользователь вводит число с клавиатуры
Программа в зависимости от введенного числа выводит в консоль следующее:
"загаданное число больше"
"загаданное число меньше"
"Вы угадали" (программа завершает работу)
Если введен 0, выввести "выход из программы" (программа завершает работу)


Задача  № 4  на использование любого цикла (выберите сами) ***
Пользователь загадывает число в диапазоне от [2 до 100]
Программа пытается его угадать (используйте метод бинарного поиска, т.е деление отрезка на 2).
Программа может задавать пользователю вопросы: Число равно ...?, Число больше ...? и в зависимоти от ответа пользователя принимать решения.
Вместо текстовых ответов ДА/НЕТ, используйте числа 0 - НЕТ и 1 - ДА
 */
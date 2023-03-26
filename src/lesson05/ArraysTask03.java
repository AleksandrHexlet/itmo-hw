package lesson05;

import java.util.Arrays;
import java.util.Scanner;

public class ArraysTask03 {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String[] array = new String[8];
        String[] temp;
        int count = 0;

        for (int i = 0; i < array.length - 1; i++) {
            array[i] = "null";
        }
        while (true) {
            System.out.println("Введите ваши слова");
            String inputStr = scan.nextLine();
            temp = inputStr.split(" ");

            if (temp.length < 1) {
                System.out.println("Вы не ввели слова.Введите ваши слова");
                continue;
            }

            if (count < 1) {
                for (int i = 0; i <= temp.length - 1; i++) {
                    array[i] = temp[i];
                    if (array.length -1 <= i ) {
                        System.out.println("Превышен размер массива");
                        System.out.println("Итоговый массив равен :  " + Arrays.toString(array));
                        return;
                    }
                }
                count = temp.length - 1;
                continue;
            }
            for (int i = 0; i < array.length; i++) {


                for (int j = 0; j <= temp.length - 1; j++) {
                    if (temp[j].equals("exit")) {
                        System.out.println("Массив содержит следующие слова: " + Arrays.toString(array));
                        return;
                    }
                    if (temp[j].equals(array[i])) {
                        temp[j] = "null";

                    }
                }

            }
            for (int i = 0; i <= temp.length - 1; i++) {

                if (count < array.length - 1 && !(temp[i].equals("null"))) {
                    count++;
                    System.out.println("array[count] = " + array[count] + "; temp[i] = " + temp[i]);
                    array[count] = temp[i];
                } else {
                    System.out.println("Превышен размер массива");
                    System.out.println("Итоговый массив равен :  " + Arrays.toString(array));
                    return;
                }
            }

            System.out.println("Итоговый массив равен :  " + Arrays.toString(array));

        }
    }
}

/*

Задача 3
Задать массив на N слов. В цикле считывать с консоли слова (scanner.nextLine()), и
добавлять их в массив (добавлять новое слово в массив можно только, если в нем его еще нет).
В итоге в массиве будут только уникальные слова. Выход из программы по слову exit
(слово 'exit' в массив не добавлять) или если массив заполнен.
Перед завершением программы, вывести получившийся массив в консоль

 */
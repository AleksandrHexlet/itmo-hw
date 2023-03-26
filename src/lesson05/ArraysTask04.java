package lesson05;



public class ArraysTask04 {
    public static void main(String[] args) {
        String str = "в предложении все слова разной длины";
        String[] arrStr = str.split(" ");
        int sizeStr = 0;
        int numStr =0;

        for (int i = 0; i < arrStr.length ; i++) {
            System.out.println(i + " = " + arrStr[i].length());
            if(arrStr[i].length() > sizeStr) numStr = i;
            sizeStr = sizeStr > arrStr[i].length() ? sizeStr : arrStr.length;
        }
        System.out.println("Самое длинное слово это : " + arrStr[numStr]);
    }
}


/*

Задача 4
Найдите самое длинное слово в предложении, при условии, что в предложении все слова разной длины.

Предложение для поска длинного слова: "в предложении все слова разной длины" (самостоятельно найти метод преобразования строки в массив строк).

 */
package lesson01;

public class Main {
    public static void main(String[] args) {

        int length = 5;
        int weight = 4;

        System.out.println("������� �����: " + (length * weight));

        int num = 3;
        System.out.println("����� � ���� �����: " + (num * num * num));


        double time = 3;
        double distance = 15;

        System.out.println("�������� �����: " + ((distance*1000)/(time * 60 * 60)) + " ������ � �������");


        int number = 79;
        int sumNumber = (int)((number/10) + (number%10));
        System.out.println(" ������ ����� �� 79 �����: " + (number/10));
        System.out.println(" ������ ����� �� 79 �����: " + (number%10));
        System.out.println(" ����� ����� 7 � 9 �����: " + sumNumber);

    }
}




/*
������ �� �������������� ���������
���� �����, ������ ��������������. ����� � ������� � ������� ��� �������.

���� ����� �����. ����� � ������� � ������� ������ ����� � ����.

���� ��� ���������� ���� double: ����� (� �����) � ���������� (� ����������). ����� � ������� � ������� ��������, ���������� � ������ � �������.

������ �� ��������������! ���������
���� �������������� ����������� � ���������� % (������ ������� �� �������). ���� �� �����������, �� �������, ������� �� �������

����� ����� ���� 2� �������� �����

��������,

��� ����� 45 ����� ���� ����� 9
��� ����� 11 ����� ���� ����� 2
 */
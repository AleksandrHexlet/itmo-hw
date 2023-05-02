package ru.itmo.lesson19.task03;

import ru.itmo.lesson14.task.task01.Fruit;

import java.util.Optional;

public class OptionalMethods {
    // ������� �� ������ Optional:
    // 1. �������� �����, ������� ��������� �� ���� ��� ������, ��������� � ����������
    // � ���������� Optional ��������� � ����������� ���� Fruit
    // ��� Optional ��������� � null �������, ���� ��� ������ == null, � ��������� ��� ���������� ������ 1

    // 2. �������� �����, ������� ��������� �� ���� ��������� ���� Fruit
    // � ���������� true, ���� ��� ������� �� null, ���������� ������� ������ 5, � ��������� �� ������ 100
    // ������ ������� �������� ������������ ��� Optional � ���������� ������

    // 3. �������� �����, ������� ��������� �� ���� ��������� ���� Fruit
    // � ����������
    // �������� ������ (FruitType.getName()) � Optional ����������, ���� ��� ������ ���������,
    // � Optional ��������� � null �������, ���� ��� ������ == null
    // ������ ������� �������� ������������ ��� Optional � ���������� ������


    public Optional<Fruit> optionalContainer01(Fruit.FruitType fruitType, int price, int count) {
        Fruit fruit = new Fruit(fruitType, price, count);
        Optional<Fruit> optionalContainer = Optional.ofNullable(fruit);
        
        if (optionalContainer.isPresent()) {
            if (fruit.getPrice() >= 1 && fruit.getCount() >= 1) {
                return optionalContainer;
            } else {
                return Optional.empty();
            }
        } else {
            return Optional.empty();
        }

    }

    public Boolean optionalContainer02(Fruit fruit) {
        
        Optional<Fruit> optionalContainer= Optional.ofNullable(fruit);

       Optional<Fruit> optional = optionalContainer.filter(value-> value.getCount() > 5 && value.getPrice() <= 100
   );
       return optional.isPresent();
    }


    // 3. �������� �����, ������� ��������� �� ���� ��������� ���� Fruit
    // � ����������
    // �������� ������ (FruitType.getName()) � Optional ����������, ���� ��� ������ ���������,
    // � Optional ��������� � null �������, ���� ��� ������ == null
    // ������ ������� �������� ������������ ��� Optional � ���������� ������


    public Optional optionalContainer03(Fruit fruit) {

        Optional<String> optionalContainer= Optional.ofNullable(fruit.getType().getName());

        return optionalContainer;
    }


    }



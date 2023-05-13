package ru.itmo.coursePaper.coursePaper_2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Paragraph {

    private Map<String, ArrayList<String>> paragraphMap = new HashMap<>();

    public Paragraph() {

        ArrayList<String> main_menu = new ArrayList<>();
        main_menu.add(0, "��������� � ������� ����");


        ArrayList<String> fox = new ArrayList<>();
        fox.add(0, "�������\n" +
                "������ ���� ������ ����������, ��������� � ��� ��������� � ����������. ��� ���� �� ���� �����������. \n ������ ������ �� �� ������� ����� �������, �� ��������� ��� �� ����. ������ ����, ����, �� ��� � �� ���� ��������� ������ �����. \n \"��������� �� ��������� ��� �� ����� �������, ����� �� ����� � ����.\" - ������� ������. ��� ��������� �������?\n"
                + "1. ��������� ����� \n"
                + "2. ����������� �� ������\n"
                + "3. ��������� � ������� ����\n"
        );

        fox.add(1, "go_home");
        fox.add(2, "go_on_search");
        fox.add(3, "main_menu");

        ArrayList<String> go_home = new ArrayList<>();
        go_home.add(0, "��������� �����\n" +
                "���������� �����, ������ ����� ��� ���������. ���������, ��� ��������� ������ �� ����� ������� ������ \n � ������ ��� ��� ������� ����. �� �������� ������������ �� ���� ������, �� ��� �����������. \n �������-�� ������ ����� ���� �����! ���� ����������� �������\n"
        );
        go_home.add(1, "end_game");
        go_home.add(2, "end_game");
        go_home.add(3, "main_menu");

        ArrayList<String> go_on_search = new ArrayList<>();
        go_on_search.add(0, " ����������� �� ������\n" +
                "��� ������ ������ ���� ������ ������ ������ � �� �������� �������� �� ������ � " +
                "��� ��������.\n �� ����� ��� ������ ����� ���������... ������ �� ����, ��� ��� " +
                "������. �������� ���.\n"
                + "1. ���������� ��������� � ��������� � ������ ������� \n"
                + "2. ������ ��������� � ��������\n"
                + "3. ��������� � ������� ����\n"
        );
        go_on_search.add(1, "ask_about_fox_all_forest_animal");
        go_on_search.add(2, "search_fox_alone");
        go_on_search.add(3, "main_menu");

        ArrayList<String> search_fox_alone = new ArrayList<>();
        search_fox_alone.add(0, "������ ��������� � ��������\n" +
                "������ ������� ����� ������ �� ���� � ������� ����� � ��� �� �������, ��� " +
                "����������. \n ������ ��� ������ ����� ������. ���� ����������� ��������"
        );
        search_fox_alone.add(1, "end_game");
        search_fox_alone.add(2, "end_game");
        search_fox_alone.add(3, "main_menu");

        ArrayList<String> ask_about_fox_all_forest_animal = new ArrayList<>();
        ask_about_fox_all_forest_animal.add(0, "���� ������ �������� �������, ������ " +
                "������ ��������� ��� ����. \n �������� ������ ���� � ����. �� � ���� ������ �������� � " +
                "�������, � ���� ����� ������ ����������� ��-�� ����������. ���� �������? \n"
                + "1. ����������� ���� \n"
                + "2. ����������� ����� \n"
                + "3. ��������� � ������� ����\n"
        );

        ask_about_fox_all_forest_animal.add(1, "ask_owl");
        ask_about_fox_all_forest_animal.add(2, "ask_wolf");
        ask_about_fox_all_forest_animal.add(3, "main_menu");

        ArrayList<String> ask_owl = new ArrayList<>();
        ask_owl.add(0, "����������� ����\n" +
                "���� ����� �� ������ ��������, �� � ����� �������, ��� ������ ����������� ���������,\n ��������� " +
                "������ ����. ��� ������ ������ �����, ��� � ������� ���� ������, ���� ��������� ���, ��� " +
                "������ ����� ������.\n"
                + "1. �������� ���� � ����������� ������ ���� \n"
                + "2. ���� �� ����� ������ -> ������ ��������� � ��������\n"
                + "3. ��������� � ������� ����\n"
        );
        ask_owl.add(1, "believe_owl_go_deep_forest");
        ask_owl.add(2, "search_fox_alone");
        ask_owl.add(3, "main_menu");


        ArrayList<String> ask_wolf = new ArrayList<>();
        ask_wolf.add(0, "����������� �����\n" +
                "���� �������� ������ �����������, �� ������ �� ����. \n ���� ������, ��� " +
                "���������� ������� �� ����� ������� �� ���� ������. � ��� ������ ���������?\n"
                + "1. ���� ���� -> ��������� �����\n"
                + "2. -> ������ ��������� � ��������\n"
                + "3. ��������� � ������� ����\n"
        );


        ask_wolf.add(1, "go_home");
        ask_wolf.add(2, "search_fox_alone");
        ask_wolf.add(3, "main_menu");

        ArrayList<String> believe_owl_go_deep_forest = new ArrayList<>();
        believe_owl_go_deep_forest.add(0, "�������� ���� � ����������� ������ ����\n" +
                "� ������� ���� ������ �������� ����������. \n ������� ���������� ��� ����� " +
                "���������� ���, ��� �����, ���� ������ ������� ��� ���.\n"
                + "1. ���, ��������� ������� ����� �������, ����� ���� ������ -> ������ ��������� � ��������\n"
                + "2. ����� ��������������� ������ � ��������� ��\n"
                + "3. ��������� � ������� ����\n"
        );


        believe_owl_go_deep_forest.add(1, "search_fox_alone");
        believe_owl_go_deep_forest.add(2, "take_chance_and_find_honey");
        believe_owl_go_deep_forest.add(3, "main_menu");

        ArrayList<String> take_chance_and_find_honey = new ArrayList<>();
        take_chance_and_find_honey.add(0, "����� ��������������� ������ � ��������� ��\n" +
                "������ ������ ����� ��, �� ������ ����� ��� ������� ����. \n ������ ������ ������ " +
                "����, �� � �� ����� ����� �� ���� ������.\n"
                + "1. ���������, ����� ����� ������\n"
                + "2. ����� ���������� �������� �� ����������\n"
                + "3. ��������� � ������� ����\n"
        );

        take_chance_and_find_honey.add(1, "wait_bees_fly_away");
        take_chance_and_find_honey.add(2, "try_steal_honey_immediately");
        take_chance_and_find_honey.add(3, "main_menu");

        ArrayList<String> wait_bees_fly_away = new ArrayList<>();
        wait_bees_fly_away.add(0, "���������, ����� ����� ������\n" +
                "������ �������� �������, � ����� �����������. \n ������ ��� ������� ������ " +
                "���. ����� �� �����, ��� ����� �������. ��� �� ������?\n"
                + "1. ������ ������� � �����������\n"
                + "2. ������ ������� �� ����������\n"
                + "3. ��������� � ������� ����\n"
        );


        wait_bees_fly_away.add(1, "Eat_little_and_take_break");
        wait_bees_fly_away.add(2, "go_honey_theBear");
        wait_bees_fly_away.add(3, "main_menu");

        ArrayList<String> try_steal_honey_immediately = new ArrayList<>();
        try_steal_honey_immediately.add(0, "����� ���������� �������� �� ����������\n" +
                "��� ���� �� ������ ����. ����� �������� ������, \n ������ ��� ������ ����� ������. ���� ����������� ��������\n");
        try_steal_honey_immediately.add(1, "end_game");
        try_steal_honey_immediately.add(2, "end_game");
        try_steal_honey_immediately.add(3, "main_menu");

        ArrayList<String> Eat_little_and_take_break = new ArrayList<>();
        Eat_little_and_take_break.add(0, "������ ������� � �����������\n" +
                "���� ������ ��, ������� ����� ��������� � �������� ���. \n ������ ����� ������, �� �� ������ ���������� ������. ���� ����������� ��������\n");
        Eat_little_and_take_break.add(1, "end_game");
        Eat_little_and_take_break.add(2, "end_game");
        Eat_little_and_take_break.add(3, "main_menu");

        ArrayList<String> go_honey_theBear = new ArrayList<>();
        go_honey_theBear.add(0, "\n" +
                "������ ������� �� ����������\n" +
                "��������� ���������� ��������� ������, ��� ����� ������ ����� ����� ����� \n � ������, ��� " +
                "��������� ������� �� ����� �� � ����� ����. �� ������� ������, ��� ����� �� �������� � " +
                "������������, � ��� ����� ������ ������, �� ����� ���������� ������ ��������� �����.\n"

                + "1. ���������� ������ �� �����, ����� ���������� ������ -> ������ ��������� � ��������\n"
                + "2. ����� ���� �� ���� � ������ ������ �������� -> ��������� �����\n"
        );
        go_honey_theBear.add(1, "search_fox_alone");
        go_honey_theBear.add(2, "go_home");
        go_honey_theBear.add(3, "main_menu");


        paragraphMap.put("fox", fox);
        paragraphMap.put("go_home", go_home);
        paragraphMap.put("go_on_search", go_on_search);
        paragraphMap.put("ask_owl", ask_owl);
        paragraphMap.put("search_fox_alone", search_fox_alone);
        paragraphMap.put("ask_about_fox_all_forest_animal", ask_about_fox_all_forest_animal);
        paragraphMap.put("fox", fox);
        paragraphMap.put("Eat_little_and_take_break", Eat_little_and_take_break);
        paragraphMap.put("try_steal_honey_immediately", try_steal_honey_immediately);

        paragraphMap.put("wait_bees_fly_away", wait_bees_fly_away);
        paragraphMap.put("take_chance_and_find_honey", take_chance_and_find_honey);
        paragraphMap.put("believe_owl_go_deep_forest", believe_owl_go_deep_forest);

        paragraphMap.put("ask_wolf", ask_wolf);
        paragraphMap.put("ask_owl", ask_owl);
        paragraphMap.put("go_honey_theBear", go_honey_theBear);


    }

    public ArrayList<String> getParagraph(String paragraphName) {
        ArrayList<String> paragraphList = new ArrayList<>();
        paragraphList = paragraphMap.get(paragraphName);

        return paragraphList;

    }

}




/*



����������� ����
����������� �����
������ ��������� � ��������
������ ������� ����� ������ �� ���� � ������� ����� � ��� �� �������, ��� ����������. ������ ��� ������ ����� ������. ���� ����������� ��������

����������� ����
���� ����� �� ������ ��������, �� � ����� �������, ��� ������ ����������� ���������, ��������� ������ ����. ��� ������ ������ �����, ��� � ������� ���� ������, ���� ��������� ���, ��� ������ ����� ������.

�������� ���� � ����������� ������ ����
���� �� ����� ������ -> ������ ��������� � ��������
����������� �����
���� �������� ������ �����������, �� ������ �� ����. ���� ������, ��� ���������� ������� �� ����� ������� �� ���� ������. � ��� ������ ���������?

���� ���� -> ��������� �����
-> ������ ��������� � ��������
�������� ���� � ����������� ������ ����
� ������� ���� ������ �������� ����������. ������� ���������� ��� ����� ���������� ���, ��� �����, ���� ������ ������� ��� ���.

���, ��������� ������� ����� �������, ����� ���� ������ -> ������ ��������� � ��������
����� ��������������� ������ � ��������� ��
����� ��������������� ������ � ��������� ��
������ ������ ����� ��, �� ������ ����� ��� ������� ����. ������ ������ ������ ����, �� � �� ����� ����� �� ���� ������.

���������, ����� ����� ������
����� ���������� �������� �� ����������
���������, ����� ����� ������
������ �������� �������, � ����� �����������. ������ ��� ������� ������ ���. ����� �� �����, ��� ����� �������. ��� �� ������?

������ ������� � �����������
������ ������� �� ����������
����� ���������� �������� �� ����������
��� ���� �� ������ ����. ����� �������� ������, ������ ��� ������ ����� ������. ���� ����������� ��������

������ ������� � �����������
���� ������ ��, ������� ����� ��������� � �������� ���. ������ ����� ������, �� �� ������ ���������� ������. ���� ����������� ��������

������ ������� �� ����������
��������� ���������� ��������� ������, ��� ����� ������ ����� ����� ����� � ������, ��� ��������� ������� �� ����� �� � ����� ����. �� ������� ������, ��� ����� �� �������� � ������������, � ��� ����� ������ ������, �� ����� ���������� ������ ��������� �����.

���������� ������ �� �����, ����� ���������� ������ -> ������ ��������� � ��������
����� ���� �� ���� � ������ ������ �������� -> ��������� �����
 */
package ru.itmo.coursePaper.coursePaper_2;

public class Data {

    Paragraph end_game = new Paragraph("end_game", "end_game",
            null, null);
    Paragraph try_steal_honey_immediately = new Paragraph("try_steal_honey_immediately",
            "����� ���������� �������� �� ����������\n" +
                    "��� ���� �� ������ ����. ����� �������� ������," +
                    "\n ������ ��� ������ ����� ������. ���� ����������� ��������\n",
            end_game, end_game);


    Paragraph Eat_little_and_take_break = new Paragraph("Eat_little_and_take_break",
            "������ ������� � �����������\n" +
                    "���� ������ ��, ������� ����� ��������� � �������� ���. \n ������ ����� ������, �� �� ������ ���������� ������. ���� ����������� ��������\n",
            end_game, end_game);


    Paragraph go_home = new Paragraph("go_home", "��������� �����\n" +
            "���������� �����, ������ ����� ��� ���������. ���������, ��� ��������� " +
            "������ �� ����� ������� ������ \n � ������ ��� ��� ������� ����. �� �������� ������������ " +
            "�� ���� ������, �� ��� �����������. \n �������-�� ������ ����� ���� �����! " +
            "���� ����������� �������\n",
            end_game, end_game);
    Paragraph search_fox_alone = new Paragraph("search_fox_alone", "������ ��������� � ��������\n" +
            "������ ������� ����� ������ �� ���� � ������� ����� � ��� �� �������, ��� " +
            "����������. \n ������ ��� ������ ����� ������. ���� ����������� ��������",
            end_game, end_game);

    Paragraph go_honey_theBear = new Paragraph("go_honey_theBear",
            "������ ������� �� ����������\n" +
                    "��������� ���������� ��������� ������, ��� ����� ������ ����� ����� ����� \n � ������, ��� " +
                    "��������� ������� �� ����� �� � ����� ����. �� ������� ������, ��� ����� �� �������� � " +
                    "������������, � ��� ����� ������ ������, �� ����� ���������� ������ ��������� �����.\n"

                    + "1. ���������� ������ �� �����, ����� ���������� ������ -> ������ ��������� � ��������\n"
                    + "2. ����� ���� �� ���� � ������ ������ �������� -> ��������� �����\n",
            search_fox_alone, go_home);
    Paragraph wait_bees_fly_away = new Paragraph("wait_bees_fly_away",
            "���������, ����� ����� ������\n" +
                    "������ �������� �������, � ����� �����������. \n ������ ��� ������� ������ " +
                    "���. ����� �� �����, ��� ����� �������. ��� �� ������?\n"
                    + "1. ������ ������� � �����������\n"
                    + "2. ������ ������� �� ����������\n"
                    + "3. ��������� � ������� ����\n",
            Eat_little_and_take_break, go_honey_theBear);
    Paragraph take_chance_and_find_honey = new Paragraph("take_chance_and_find_honey",
            "�������� ���� � ����������� ������ ����\n" +
                    "����� ��������������� ������ � ��������� ��\n" +
                    "������ ������ ����� ��, �� ������ ����� ��� ������� ����. \n ������ ������ ������ " +
                    "����, �� � �� ����� ����� �� ���� ������.\n"
                    + "1. ���������, ����� ����� ������\n"
                    + "2. ����� ���������� �������� �� ����������\n"
                    + "3. ��������� � ������� ����\n",
            wait_bees_fly_away, try_steal_honey_immediately);
    Paragraph believe_owl_go_deep_forest = new Paragraph("believe_owl_go_deep_forest",
            "�������� ���� � ����������� ������ ����\n" +
                    "� ������� ���� ������ �������� ����������. \n ������� ���������� ��� ����� " +
                    "���������� ���, ��� �����, ���� ������ ������� ��� ���.\n"
                    + "1. ���, ��������� ������� ����� �������, ����� ���� ������ -> ������ ��������� � ��������\n"
                    + "2. ����� ��������������� ������ � ��������� ��\n"
                    + "3. ��������� � ������� ����\n",
            search_fox_alone, take_chance_and_find_honey);


    Paragraph ask_owl = new Paragraph("ask_owl",
            "����������� ����\n" +
                    "���� ����� �� ������ ��������, �� � ����� �������, ��� ������ ����������� ���������,\n ��������� " +
                    "������ ����. ��� ������ ������ �����, ��� � ������� ���� ������, ���� ��������� ���, ��� " +
                    "������ ����� ������.\n"
                    + "1. �������� ���� � ����������� ������ ���� \n"
                    + "2. ���� �� ����� ������ -> ������ ��������� � ��������\n"
                    + "3. ��������� � ������� ����\n",
            believe_owl_go_deep_forest, search_fox_alone);

    Paragraph ask_wolf = new Paragraph("ask_wolf",
            "����������� �����\n" +
                    "���� �������� ������ �����������, �� ������ �� ����. \n ���� ������, ��� " +
                    "���������� ������� �� ����� ������� �� ���� ������. � ��� ������ ���������?\n"
                    + "1. ���� ���� -> ��������� �����\n"
                    + "2. -> ������ ��������� � ��������\n"
                    + "3. ��������� � ������� ����\n",
            go_home, search_fox_alone);


    Paragraph ask_about_fox_all_forest_animal = new Paragraph("ask_about_fox_all_forest_animal", "���� ������ �������� �������, ������ " +
            "������ ��������� ��� ����. \n �������� ������ ���� � ����. �� � ���� ������ �������� � " +
            "�������, � ���� ����� ������ ����������� ��-�� ����������. ���� �������? \n"
            + "1. ����������� ���� \n"
            + "2. ����������� ����� \n"
            + "3. ��������� � ������� ����\n",
            ask_owl, ask_wolf);
    Paragraph go_on_search = new Paragraph("go_on_search", "����������� �� ������\n" +
            "��� ������ ������ ���� ������ ������ ������ � �� �������� �������� �� ������ � " +
            "��� ��������.\n �� ����� ��� ������ ����� ���������... ������ �� ����, ��� ��� " +
            "������. �������� ���.\n"
            + "1. ���������� ��������� � ��������� � ������ ������� \n"
            + "2. ������ ��������� � ��������\n"
            + "3. ��������� � ������� ����\n",
            ask_about_fox_all_forest_animal, search_fox_alone);

    Paragraph fox = new Paragraph("fox", "�������\n" +
            "������ ���� ������ ����������, ��������� � ��� ��������� � ����������. ��� ���� �� ���� �����������. \n ������ ������ �� �� ������� ����� �������, �� ��������� ��� �� ����. ������ ����, ����, �� ��� � �� ���� ��������� ������ �����. \n \"��������� �� ��������� ��� �� ����� �������, ����� �� ����� � ����.\" - ������� ������. ��� ��������� �������?\n"
            + "1. ��������� ����� \n"
            + "2. ����������� �� ������\n"
            + "3. ��������� � ������� ����\n", go_home, go_on_search);

    public Paragraph getEnd_game() {
        return end_game;
    }

    public Paragraph getTry_steal_honey_immediately() {
        return try_steal_honey_immediately;
    }

    public Paragraph getEat_little_and_take_break() {
        return Eat_little_and_take_break;
    }

    public Paragraph getGo_home() {
        return go_home;
    }

    public Paragraph getSearch_fox_alone() {
        return search_fox_alone;
    }

    public Paragraph getGo_honey_theBear() {
        return go_honey_theBear;
    }

    public Paragraph getWait_bees_fly_away() {
        return wait_bees_fly_away;
    }

    public Paragraph getTake_chance_and_find_honey() {
        return take_chance_and_find_honey;
    }

    public Paragraph getBelieve_owl_go_deep_forest() {
        return believe_owl_go_deep_forest;
    }

    public Paragraph getAsk_owl() {
        return ask_owl;
    }

    public Paragraph getAsk_wolf() {
        return ask_wolf;
    }

    public Paragraph getAsk_about_fox_all_forest_animal() {
        return ask_about_fox_all_forest_animal;
    }

    public Paragraph getGo_on_search() {
        return go_on_search;
    }

    public Paragraph getFox() {
        return fox;
    }
}

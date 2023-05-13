package ru.itmo.coursePaper.coursePaper_2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Paragraph {

    private Map<String, ArrayList<String>> paragraphMap = new HashMap<>();

    public Paragraph() {

        ArrayList<String> main_menu = new ArrayList<>();
        main_menu.add(0, "Вернуться в главное меню");


        ArrayList<String> fox = new ArrayList<>();
        fox.add(0, "Лисенок\n" +
                "Каждое утро Лисёнок просыпался, завтракал и шёл увидеться с Бельчонком. Это утро не было исключением. \n Лисёнок пришёл на их обычное место встречи, но Бельчонка там не было. Лисёнок ждал, ждал, но так и не смог дождаться своего друга. \n \"Бельчонок не пропустил еще ни одной встречи, вдруг он попал в беду.\" - подумал Лисёнок. Как поступить Лисенку?\n"
                + "1. Вернуться домой \n"
                + "2. Отправиться на поиски\n"
                + "3. Вернуться в главное меню\n"
        );

        fox.add(1, "go_home");
        fox.add(2, "go_on_search");
        fox.add(3, "main_menu");

        ArrayList<String> go_home = new ArrayList<>();
        go_home.add(0, "Вернуться домой\n" +
                "Вернувшись домой, Лисёнок нашёл там Бельчонка. Оказалось, что Бельчонок пришёл на место встречи раньше \n и увидел там рой злобных пчел. Он поспешил предупредить об этом Лисёнка, но они разминулись. \n Наконец-то друзья нашли друг друга! Игра завершилась успехом\n"
        );
        go_home.add(1, "end_game");
        go_home.add(2, "end_game");
        go_home.add(3, "main_menu");

        ArrayList<String> go_on_search = new ArrayList<>();
        go_on_search.add(0, " Отправиться на поиски\n" +
                "Все лесные жители были заняты своими делами и не обращали внимания на Лисёнка и " +
                "его проблему.\n Но вдруг кто нибудь видел Бельчонка... Лисёнок не знал, что ему " +
                "делать. Помогите ему.\n"
                + "1. Попытаться разузнать о Бельчонке у лесных жителей \n"
                + "2. Искать Бельчонка в одиночку\n"
                + "3. Вернуться в главное меню\n"
        );
        go_on_search.add(1, "ask_about_fox_all_forest_animal");
        go_on_search.add(2, "search_fox_alone");
        go_on_search.add(3, "main_menu");

        ArrayList<String> search_fox_alone = new ArrayList<>();
        search_fox_alone.add(0, "Искать Бельчонка в одиночку\n" +
                "Лисёнок слишком долго плутал по лесу в поисках друга и сам не заметил, как " +
                "заблудился. \n Теперь его самого нужно искать. Игра завершилась неудачей"
        );
        search_fox_alone.add(1, "end_game");
        search_fox_alone.add(2, "end_game");
        search_fox_alone.add(3, "main_menu");

        ArrayList<String> ask_about_fox_all_forest_animal = new ArrayList<>();
        ask_about_fox_all_forest_animal.add(0, "Пока Лисёнок принимал решение, лесные " +
                "жители разошлись кто куда. \n Остались только Сова и Волк. Но у Совы бывают проблемы с " +
                "памятью, а Волк может сильно разозлиться из-за расспросов. Кого выбрать? \n"
                + "1. Расспросить Сову \n"
                + "2. Расспросить Волка \n"
                + "3. Вернуться в главное меню\n"
        );

        ask_about_fox_all_forest_animal.add(1, "ask_owl");
        ask_about_fox_all_forest_animal.add(2, "ask_wolf");
        ask_about_fox_all_forest_animal.add(3, "main_menu");

        ArrayList<String> ask_owl = new ArrayList<>();
        ask_owl.add(0, "Расспросить Сову\n" +
                "Сова долго не хотела говорить, но в итоге сказала, что видела испуганного Бельчонка,\n бежавшего " +
                "вглубь леса. Все лесные жители знают, что в глубине леса опасно, если Бельчонок там, ему " +
                "срочно нужна помощь.\n"
                + "1. Поверить Сове и отправиться вглубь леса \n"
                + "2. Сове не стоит верить -> Искать Бельчонка в одиночку\n"
                + "3. Вернуться в главное меню\n"
        );
        ask_owl.add(1, "believe_owl_go_deep_forest");
        ask_owl.add(2, "search_fox_alone");
        ask_owl.add(3, "main_menu");


        ArrayList<String> ask_wolf = new ArrayList<>();
        ask_wolf.add(0, "Расспросить Волка\n" +
                "Волк оказался вполне дружелюбным, но помочь не смог. \n Лишь сказал, что " +
                "маленькому лисенку не стоит бродить по лесу одному. И как теперь поступить?\n"
                + "1. Волк прав -> Вернуться домой\n"
                + "2. -> Искать Бельчонка в одиночку\n"
                + "3. Вернуться в главное меню\n"
        );


        ask_wolf.add(1, "go_home");
        ask_wolf.add(2, "search_fox_alone");
        ask_wolf.add(3, "main_menu");

        ArrayList<String> believe_owl_go_deep_forest = new ArrayList<>();
        believe_owl_go_deep_forest.add(0, "Поверить Сове и отправиться вглубь леса\n" +
                "В глубине леса Лисёнок встретил Медвежонка. \n Ленивый Медвежонок был готов " +
                "рассказать все, что знает, если Лисёнок принесёт ему мёда.\n"
                + "1. Нет, потрачено слишком много времени, нужно идти дальше -> Искать Бельчонка в одиночку\n"
                + "2. Нужно воспользоваться шансом и раздобыть мёд\n"
                + "3. Вернуться в главное меню\n"
        );


        believe_owl_go_deep_forest.add(1, "search_fox_alone");
        believe_owl_go_deep_forest.add(2, "take_chance_and_find_honey");
        believe_owl_go_deep_forest.add(3, "main_menu");

        ArrayList<String> take_chance_and_find_honey = new ArrayList<>();
        take_chance_and_find_honey.add(0, "Нужно воспользоваться шансом и раздобыть мёд\n" +
                "Лисёнок быстро нашёл мёд, но вокруг летал рой злобных пчел. \n Лисёнок всегда боялся " +
                "пчёл, но и не найти друга он тоже боялся.\n"
                + "1. Подождать, вдруг пчёлы улетят\n"
                + "2. Нужно попытаться выкрасть мёд немедленно\n"
                + "3. Вернуться в главное меню\n"
        );

        take_chance_and_find_honey.add(1, "wait_bees_fly_away");
        take_chance_and_find_honey.add(2, "try_steal_honey_immediately");
        take_chance_and_find_honey.add(3, "main_menu");

        ArrayList<String> wait_bees_fly_away = new ArrayList<>();
        wait_bees_fly_away.add(0, "Подождать, вдруг пчёлы улетят\n" +
                "Лисёнок подождал немного, и пчёлы разлетелись. \n Лисёнок без проблем набрал " +
                "мёда. Вдруг он понял, что очень голоден. Что же делать?\n"
                + "1. Поесть немного и передохнуть\n"
                + "2. Скорее отнести мёд Медвежонку\n"
                + "3. Вернуться в главное меню\n"
        );


        wait_bees_fly_away.add(1, "Eat_little_and_take_break");
        wait_bees_fly_away.add(2, "go_honey_theBear");
        wait_bees_fly_away.add(3, "main_menu");

        ArrayList<String> try_steal_honey_immediately = new ArrayList<>();
        try_steal_honey_immediately.add(0, "Нужно попытаться выкрасть мёд немедленно\n" +
                "Это была не лучшая идея. Пчёлы покусали Лисёнка, \n теперь ему самому нужна помощь. Игра завершилась неудачей\n");
        try_steal_honey_immediately.add(1, "end_game");
        try_steal_honey_immediately.add(2, "end_game");
        try_steal_honey_immediately.add(3, "main_menu");

        ArrayList<String> Eat_little_and_take_break = new ArrayList<>();
        Eat_little_and_take_break.add(0, "Поесть немного и передохнуть\n" +
                "Пока Лисёнок ел, злобные пчёлы вернулись и покусали его. \n Лисёнку нужна помощь, он не сможет продолжить поиски. Игра завершилась неудачей\n");
        Eat_little_and_take_break.add(1, "end_game");
        Eat_little_and_take_break.add(2, "end_game");
        Eat_little_and_take_break.add(3, "main_menu");

        ArrayList<String> go_honey_theBear = new ArrayList<>();
        go_honey_theBear.add(0, "\n" +
                "Скорее отнести мёд Медвежонку\n" +
                "Довольный Медвежонок рассказал Лисёнку, что очень хорошо знает семью Белок \n и уверен, что " +
                "Бельчонок никогда не пошёл бы в глубь леса. Он заверял Лисёнка, что Белки не попадают в " +
                "неприятности, и что Совам нельзя верить, он также уговаривал Лисёнка вернуться домой.\n"

                + "1. Медвежонок ничего не знает, нужно продолжить поиски -> Искать Бельчонка в одиночку\n"
                + "2. Может быть он прав и Лисёнок просто паникует -> Вернуться домой\n"
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



Расспросить Сову
Расспросить Волка
Искать Бельчонка в одиночку
Лисёнок слишком долго плутал по лесу в поисках друга и сам не заметил, как заблудился. Теперь его самого нужно искать. Игра завершилась неудачей

Расспросить Сову
Сова долго не хотела говорить, но в итоге сказала, что видела испуганного Бельчонка, бежавшего вглубь леса. Все лесные жители знают, что в глубине леса опасно, если Бельчонок там, ему срочно нужна помощь.

Поверить Сове и отправиться вглубь леса
Сове не стоит верить -> Искать Бельчонка в одиночку
Расспросить Волка
Волк оказался вполне дружелюбным, но помочь не смог. Лишь сказал, что маленькому лисенку не стоит бродить по лесу одному. И как теперь поступить?

Волк прав -> Вернуться домой
-> Искать Бельчонка в одиночку
Поверить Сове и отправиться вглубь леса
В глубине леса Лисёнок встретил Медвежонка. Ленивый Медвежонок был готов рассказать все, что знает, если Лисёнок принесёт ему мёда.

Нет, потрачено слишком много времени, нужно идти дальше -> Искать Бельчонка в одиночку
Нужно воспользоваться шансом и раздобыть мёд
Нужно воспользоваться шансом и раздобыть мёд
Лисёнок быстро нашёл мёд, но вокруг летал рой злобных пчел. Лисёнок всегда боялся пчёл, но и не найти друга он тоже боялся.

Подождать, вдруг пчёлы улетят
Нужно попытаться выкрасть мёд немедленно
Подождать, вдруг пчёлы улетят
Лисёнок подождал немного, и пчёлы разлетелись. Лисёнок без проблем набрал мёда. Вдруг он понял, что очень голоден. Что же делать?

Поесть немного и передохнуть
Скорее отнести мёд Медвежонку
Нужно попытаться выкрасть мёд немедленно
Это была не лучшая идея. Пчёлы покусали Лисёнка, теперь ему самому нужна помощь. Игра завершилась неудачей

Поесть немного и передохнуть
Пока Лисёнок ел, злобные пчёлы вернулись и покусали его. Лисёнку нужна помощь, он не сможет продолжить поиски. Игра завершилась неудачей

Скорее отнести мёд Медвежонку
Довольный Медвежонок рассказал Лисёнку, что очень хорошо знает семью Белок и уверен, что Бельчонок никогда не пошёл бы в глубь леса. Он заверял Лисёнка, что Белки не попадают в неприятности, и что Совам нельзя верить, он также уговаривал Лисёнка вернуться домой.

Медвежонок ничего не знает, нужно продолжить поиски -> Искать Бельчонка в одиночку
Может быть он прав и Лисёнок просто паникует -> Вернуться домой
 */
package ru.itmo.coursePaper.coursePaper_2;

public class Data {

    Paragraph end_game = new Paragraph("end_game", "end_game",
            null, null);
    Paragraph try_steal_honey_immediately = new Paragraph("try_steal_honey_immediately",
            "Нужно попытаться выкрасть мёд немедленно\n" +
                    "Это была не лучшая идея. Пчёлы покусали Лисёнка," +
                    "\n теперь ему самому нужна помощь. Игра завершилась неудачей\n",
            end_game, end_game);


    Paragraph Eat_little_and_take_break = new Paragraph("Eat_little_and_take_break",
            "Поесть немного и передохнуть\n" +
                    "Пока Лисёнок ел, злобные пчёлы вернулись и покусали его. \n Лисёнку нужна помощь, он не сможет продолжить поиски. Игра завершилась неудачей\n",
            end_game, end_game);


    Paragraph go_home = new Paragraph("go_home", "Вернуться домой\n" +
            "Вернувшись домой, Лисёнок нашёл там Бельчонка. Оказалось, что Бельчонок " +
            "пришёл на место встречи раньше \n и увидел там рой злобных пчел. Он поспешил предупредить " +
            "об этом Лисёнка, но они разминулись. \n Наконец-то друзья нашли друг друга! " +
            "Игра завершилась успехом\n",
            end_game, end_game);
    Paragraph search_fox_alone = new Paragraph("search_fox_alone", "Искать Бельчонка в одиночку\n" +
            "Лисёнок слишком долго плутал по лесу в поисках друга и сам не заметил, как " +
            "заблудился. \n Теперь его самого нужно искать. Игра завершилась неудачей",
            end_game, end_game);

    Paragraph go_honey_theBear = new Paragraph("go_honey_theBear",
            "Скорее отнести мёд Медвежонку\n" +
                    "Довольный Медвежонок рассказал Лисёнку, что очень хорошо знает семью Белок \n и уверен, что " +
                    "Бельчонок никогда не пошёл бы в глубь леса. Он заверял Лисёнка, что Белки не попадают в " +
                    "неприятности, и что Совам нельзя верить, он также уговаривал Лисёнка вернуться домой.\n"

                    + "1. Медвежонок ничего не знает, нужно продолжить поиски -> Искать Бельчонка в одиночку\n"
                    + "2. Может быть он прав и Лисёнок просто паникует -> Вернуться домой\n",
            search_fox_alone, go_home);
    Paragraph wait_bees_fly_away = new Paragraph("wait_bees_fly_away",
            "Подождать, вдруг пчёлы улетят\n" +
                    "Лисёнок подождал немного, и пчёлы разлетелись. \n Лисёнок без проблем набрал " +
                    "мёда. Вдруг он понял, что очень голоден. Что же делать?\n"
                    + "1. Поесть немного и передохнуть\n"
                    + "2. Скорее отнести мёд Медвежонку\n"
                    + "3. Вернуться в главное меню\n",
            Eat_little_and_take_break, go_honey_theBear);
    Paragraph take_chance_and_find_honey = new Paragraph("take_chance_and_find_honey",
            "Поверить Сове и отправиться вглубь леса\n" +
                    "Нужно воспользоваться шансом и раздобыть мёд\n" +
                    "Лисёнок быстро нашёл мёд, но вокруг летал рой злобных пчел. \n Лисёнок всегда боялся " +
                    "пчёл, но и не найти друга он тоже боялся.\n"
                    + "1. Подождать, вдруг пчёлы улетят\n"
                    + "2. Нужно попытаться выкрасть мёд немедленно\n"
                    + "3. Вернуться в главное меню\n",
            wait_bees_fly_away, try_steal_honey_immediately);
    Paragraph believe_owl_go_deep_forest = new Paragraph("believe_owl_go_deep_forest",
            "Поверить Сове и отправиться вглубь леса\n" +
                    "В глубине леса Лисёнок встретил Медвежонка. \n Ленивый Медвежонок был готов " +
                    "рассказать все, что знает, если Лисёнок принесёт ему мёда.\n"
                    + "1. Нет, потрачено слишком много времени, нужно идти дальше -> Искать Бельчонка в одиночку\n"
                    + "2. Нужно воспользоваться шансом и раздобыть мёд\n"
                    + "3. Вернуться в главное меню\n",
            search_fox_alone, take_chance_and_find_honey);


    Paragraph ask_owl = new Paragraph("ask_owl",
            "Расспросить Сову\n" +
                    "Сова долго не хотела говорить, но в итоге сказала, что видела испуганного Бельчонка,\n бежавшего " +
                    "вглубь леса. Все лесные жители знают, что в глубине леса опасно, если Бельчонок там, ему " +
                    "срочно нужна помощь.\n"
                    + "1. Поверить Сове и отправиться вглубь леса \n"
                    + "2. Сове не стоит верить -> Искать Бельчонка в одиночку\n"
                    + "3. Вернуться в главное меню\n",
            believe_owl_go_deep_forest, search_fox_alone);

    Paragraph ask_wolf = new Paragraph("ask_wolf",
            "Расспросить Волка\n" +
                    "Волк оказался вполне дружелюбным, но помочь не смог. \n Лишь сказал, что " +
                    "маленькому лисенку не стоит бродить по лесу одному. И как теперь поступить?\n"
                    + "1. Волк прав -> Вернуться домой\n"
                    + "2. -> Искать Бельчонка в одиночку\n"
                    + "3. Вернуться в главное меню\n",
            go_home, search_fox_alone);


    Paragraph ask_about_fox_all_forest_animal = new Paragraph("ask_about_fox_all_forest_animal", "Пока Лисёнок принимал решение, лесные " +
            "жители разошлись кто куда. \n Остались только Сова и Волк. Но у Совы бывают проблемы с " +
            "памятью, а Волк может сильно разозлиться из-за расспросов. Кого выбрать? \n"
            + "1. Расспросить Сову \n"
            + "2. Расспросить Волка \n"
            + "3. Вернуться в главное меню\n",
            ask_owl, ask_wolf);
    Paragraph go_on_search = new Paragraph("go_on_search", "Отправиться на поиски\n" +
            "Все лесные жители были заняты своими делами и не обращали внимания на Лисёнка и " +
            "его проблему.\n Но вдруг кто нибудь видел Бельчонка... Лисёнок не знал, что ему " +
            "делать. Помогите ему.\n"
            + "1. Попытаться разузнать о Бельчонке у лесных жителей \n"
            + "2. Искать Бельчонка в одиночку\n"
            + "3. Вернуться в главное меню\n",
            ask_about_fox_all_forest_animal, search_fox_alone);

    Paragraph fox = new Paragraph("fox", "Лисенок\n" +
            "Каждое утро Лисёнок просыпался, завтракал и шёл увидеться с Бельчонком. Это утро не было исключением. \n Лисёнок пришёл на их обычное место встречи, но Бельчонка там не было. Лисёнок ждал, ждал, но так и не смог дождаться своего друга. \n \"Бельчонок не пропустил еще ни одной встречи, вдруг он попал в беду.\" - подумал Лисёнок. Как поступить Лисенку?\n"
            + "1. Вернуться домой \n"
            + "2. Отправиться на поиски\n"
            + "3. Вернуться в главное меню\n", go_home, go_on_search);

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

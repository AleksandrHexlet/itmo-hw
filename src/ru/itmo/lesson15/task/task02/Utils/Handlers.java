package ru.itmo.lesson15.task.task02.Utils;

import java.util.*;

public class Handlers {
    // FIXME:: В решениях не использовать lambda выражения и stream API

    // TODO (2.1) написать статический метод, который принимает на вход map (например, firstTaskMap) и город (например, city),
    //  формирует и возвращает список (List) логинов, которые соответствуют переданному городу
    // перебирай пары и сравнивай значение с переданным городом, при совпадении добавляй в arrayList


    String city = "Тверь";

    public static List getCityLogin(Map<String, String> cities, String city) {
        List<String> cityLogin = new ArrayList<>();

        for (Map.Entry<String, String> item : cities.entrySet()) {
            if (item.getValue().equals(city)) {
                cityLogin.add(item.getKey());
            }
            System.out.println("cityLogin = " + cityLogin);
        }
        return cityLogin;
    }


    // TODO (2.2) дан список слов (например, words).
    //  Написать статический метод, который будет возвращать количество одинаковых слов в списке
    //  в map вида Map<String, Integer>, где String - слово и Integer - количество повторений
//        перед добавлением выясняй есть  это слово в аррейлисте или нет через контейнс и добавляй или нет

    public static Map<String, Integer> getCountRepeatWords(List<String> listWords) {
        Map<String, Integer> repeatWords = new HashMap<>();
        for (String word : listWords) {
            repeatWords.put(word, repeatWords.getOrDefault(word, 0) + 1);
        }
        System.out.println(" words = " + repeatWords);
        return repeatWords;
    }

    ;


    // TODO (2.3) Задания по тексту (например, text). На каждый пункт - минимум один метод (можно статический):
    //  1. написать метод, принимающий на вход слово и возвращающий частоту встречаемости данного слова в тексте
    //  (Map<String, Long>, где - ключи (String) - слово, значения (Long) - частота встречаемости)
    //  2. написать метод, который собирает все слова в группы по количеству букв:
    //создавай мапу с  arrayList - ами в качестве ключа бери слово.length и если ключ( количество букв ) в мапе есть тогда добавляй в этот ареейлист или создавай в цикле новый аррейлист
    //  например, в одну группу попадут слова: 3 - [the, war, jar, get, met...], в другую 2 - [on, up, no, of...]
    //  (Map<Integer, ArrayList<String>>, где - ключи (Integer) - количество букв, значения (ArrayList<String>) - слова)
    //  3. написать метод, который выводит в консоль топ 10 самых часто встречаемых в тексте слов (артикли и предлоги тоже считаем за слова)
    // через сплит в массив и по массиву переберай
    // в тексте содержатся только буквы и пробельные символы
    String text = "It is a uncover long established fact that a reader will be distracted uncover by the readable content of a page " +
            "when looking at its layout The point of using uncover Lorem Ipsum is that sites it has a more-or-less normal distribution of letters" +
            "as uncover opposed to still using Content here humour uncover content here making it look like readable English Many desktop publishing " +
            "packages and web page editors now use Lorem Ipsum as their default model text and a search for lorem ipsum will " +
            "uncover many web sites still uncover in their infancy Various versions uncover have evolved over the years uncover sometimes by accident" +
            " sometimes on purpose injected humour and the like";


    public static Map<String, Long> countWordInText(String text) {
        Map<String, Long> strMap = new HashMap<>();
        String[] strArr = text.split(" ");
        for (String word : strArr) {
            strMap.put(word, strMap.getOrDefault(word, 0L) + 1);
        }
        System.out.println("strMap = " + strMap);
        return strMap;
    }

    ;

    public static Map<Integer, List<String>> listWords(String text) {
        Map<Integer, List<String>> wordMap = new HashMap<>();
        String[] strArr = text.split(" ");
        for (String word : strArr) {
            if (wordMap.containsKey(word.length())) {
                wordMap.get(word.length()).add(word);
            } else {
                List<String> arrStr = new ArrayList<>();
                arrStr.add(word);
                wordMap.put(word.length(), arrStr);
            }
        }
        System.out.println("wordMap = " + wordMap);
        return wordMap;
    }

    ;

    public static Map<String, Integer> topTenWords(String text) {
        Map<String, Integer> topWordMap = new TreeMap<String, Integer>();
//                new Comparator<String>() {
//
//                        @Override
//                        public int compare(String o1, String  o2) {
//                            return o2.compareTo(o1);
//                        }
//                });;
        String[] strArr = text.split(" ");
        List<String> topTen = new ArrayList<>();
        for (int i = 0; i < strArr.length; i++) {
            for (int j = 0; j < strArr.length; j++) {
                if (strArr[i].equals(strArr[j])) {
                    topWordMap.put(strArr[j], topWordMap.getOrDefault(strArr[j], 0) + 1);

                }
            }
        }
        System.out.println("topWordMap = " + topWordMap);
        return topWordMap;
    };
}
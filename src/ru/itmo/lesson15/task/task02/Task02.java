package ru.itmo.lesson15.task.task02;


import ru.itmo.lesson15.task.task02.Utils.Handlers;

import java.util.*;

public class Task02 {
    public static void main(String[] args) {
        // FIXME:: В решениях не использовать lambda выражения и stream API

        // TODO (2.1) написать статический метод, который принимает на вход map (например, firstTaskMap) и город (например, city),
        //  формирует и возвращает список (List) логинов, которые соответствуют переданному городу
        // перебирай пары и сравнивай значение с переданным городом, при совпадении добавляй в arrayList
        HashMap<String, String> firstTaskMap = new HashMap<>();
        firstTaskMap.put("qwe", "Тверь");
        firstTaskMap.put("asd", "Тверь");
        firstTaskMap.put("zxc", "Москва");
        firstTaskMap.put("rty", "Тверь");
        firstTaskMap.put("fgh", "Магадан");

        String city = "Тверь";







        // TODO (2.2) дан список слов (например, words).
        //  Написать статический метод, который будет возвращать количество одинаковых слов в списке
        //  в map вида Map<String, Integer>, где String - слово и Integer - количество повторений
//        перед добавлением выясняй есть  это слово в аррейлисте или нет через контейнс и добавляй или нет
        List<String> words = new ArrayList<>();
        words.add("may");
        words.add("august");
        words.add("june");
        words.add("may");
        words.add("may");
        words.add("july");
        words.add("may");
        words.add("august");
        words.add("august");


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
        Handlers.getCityLogin(firstTaskMap,city);
        Handlers.getCountRepeatWords(words);
        Handlers.countWordInText(text);
        Handlers.listWords(text);
        Handlers.topTenWords(text);

    }
}



/*
package ru.itmo.lessons.lesson15.task.task02;

import java.util.*;

public class Task02 {

    private static List<String> task01(Map<String, String> map, String someString) {
        // FIXME:
        //  1. Создать пустой список, для хранения строк (ArrayList<String>)
        //  2. Перебрать пары (ключ + значение) объекта map
        //  (для получения коллекции пар использовать метод map.entrySet(), пример перебора пар в файле Lesson15.java) и
        //   на каждой итерации цикла:
        //      2.1. получать значение пары (метод getValue())
        //      2.2. полученное значение сравнивать со значением someString, если они равны, ключ пары (метод getKey())
        //      добавлять в список, объявленный в п.1
        //   3. Список, объявленный в п.1, вернуть из метода
        return null;
    }

    private static Map<String, Integer> task02(List<String> strings) {
        // FIXME: похожую реализацию разбирали на занятии (класс UserStorage, метод getNumberOfUsersByRole)
        //  1. Создать пустую map, для хранения строк и количества повторений (HashMap<String, Integer>)
        //  2. Перебрать список strings и на каждой итерации цикла:
        //      2.1. проверять, содержится ли ключ (элемент перебираемой коллекции) в мапе, объявленной в п.1
        //      2.2. если ключ содержится (значит информация о строке из списка уже есть в мапе), получать значение по данному ключу,
        //      увеличивать его на 1, записывать в мапу ключ и новое значение (обновляем количество повторений данной строки)
        //      2.3. если ключ не содержится, записывать в мапу ключ и 1 (строка из списка встретилась первый раз)
        //   3. Мапу, объявленную в п.1, вернуть из метода
        return null;
    }

    private static Map<String, Long> task0301(String text) {
        // FIXME: реализация похожа на метод task02
        //  1. Создать пустую map, для хранения строк и количества повторений (HashMap<String, Long>)
        //  2. Создать массив строк из строки text (нужный метод найти самостоятельно)
        //  3. Перебрать массив строк, полученный в п.2 и на каждой итерации цикла:
        //      3.1. проверять, содержится ли ключ (элемент перебираемой коллекции) в мапе, объявленной в п.1
        //      3.2. если ключ содержится (значит информация о строке из списка уже есть в мапе), получать значение по данному ключу,
        //      увеличивать его на 1, записывать в мапу ключ и новое значение (обновляем количество повторений данной строки)
        //      3.3. если ключ не содержится, записывать в мапу ключ и 1 (строка из списка встретилась первый раз)
        //   4. Мапу, объявленную в п.1, вернуть из метода
        return null;
    }

    private static Map<Integer, ArrayList<String>> task0302(String text) {
        // FIXME: реализация похожа на метод getUsersByAge класса UserStorage
        //  1. Создать пустую map, для хранения строк и количества повторений (HashMap<Integer, ArrayList<String>>)
        //  2. Создать массив строк из строки text (нужный метод найти самостоятельно)
        //  3. Перебрать массив строк, полученный в п.2 и на каждой итерации цикла:
        //      3.1. получить размер строки (элемента массива)
        //      3.2. проверять, содержится ли ключ (значение полученное в п.3.1) в мапе, объявленной в п.1
        //      3.3. если ключ содержится (значит информация о строке из массива уже есть в мапе),
        //      получать значение (список) по данному ключу, добавлять строку (элемент массива) в полученный список,
        //      записывать в мапу ключ и список, с добавленной в него строкой
        //      3.4. если ключ не содержится, создавать пустой список (ArrayList<String>),
        //      добавлять в него строку (элемент массива), записывать в мапу ключ и созданный список
        //   4. Мапу, объявленную в п.1, вернуть из метода
        return null;
    }

    public static void main(String[] args) {
        // FIXME:: В решениях не использовать lambda выражения и stream API

        // TODO (2.1) написать статический метод, который принимает на вход map (например, firstTaskMap) и город (например, city),
        //  формирует и возвращает список (List) логинов, которые соответствуют переданному городу

        HashMap<String, String> firstTaskMap = new HashMap<>();
        firstTaskMap.put("qwe", "Тверь");
        firstTaskMap.put("asd", "Тверь");
        firstTaskMap.put("zxc", "Москва");
        firstTaskMap.put("rty", "Тверь");
        firstTaskMap.put("fgh", "Магадан");

        String city = "Тверь";

        System.out.println(task01(firstTaskMap, city));

        // TODO (2.2) дан список слов (например, words).
        //  Написать статический метод, который будет возвращать количество одинаковых слов в списке
        //  в map вида Map<String, Integer>, где String - слово и Integer - количество повторений

        List<String> words = new ArrayList<>();
        words.add("may");
        words.add("august");
        words.add("june");
        words.add("may");
        words.add("may");
        words.add("july");
        words.add("may");
        words.add("august");
        words.add("august");

        System.out.println(task02(words));


        // TODO (2.3) Задания по тексту (например, text). На каждый пункт - минимум один метод (можно статический):
        //  1. написать метод, принимающий на вход слово и возвращающий частоту встречаемости данного слова в тексте
        //  (Map<String, Long>, где - ключи (String) - слово, значения (Long) - частота встречаемости)
        //  2. написать метод, который собирает все слова в группы по количеству букв:
        //  например, в одну группу попадут слова: 3 - [the, war, jar, get, met...], в другую 2 - [on, up, no, of...]
        //  (Map<Integer, ArrayList<String>>, где - ключи (Integer) - количество букв, значения (ArrayList<String>) - слова)
        //  3. написать метод, который выводит в консоль топ 10 самых часто встречаемых в тексте слов (артикли и предлоги тоже считаем за слова)

        // в тексте содержатся только буквы и пробельные символы
        String text = "It is a uncover long established fact that a reader will be distracted uncover by the readable content of a page " +
                "when looking at its layout The point of using uncover Lorem Ipsum is that sites it has a more-or-less normal distribution of letters" +
                "as uncover opposed to still using Content here humour uncover content here making it look like readable English Many desktop publishing " +
                "packages and web page editors now use Lorem Ipsum as their default model text and a search for lorem ipsum will " +
                "uncover many web sites still uncover in their infancy Various versions uncover have evolved over the years uncover sometimes by accident" +
                " sometimes on purpose injected humour and the like";

        System.out.println(task0301(text));
        System.out.println(task0302(text));
        task0303(text);

    }

    private static void task0303(String text) {
        // FIXME: реализация похожа на метод getUsersByAge класса UserStorage
        //  1. Создать массив строк из строки text (нужный метод найти самостоятельно = split)
        //  2. Создать список из элементов массива, полученного в п.2 (способ создания списка из массива см в файле map.md)
        //  3. Объявить переменную типа Map<String, Integer>, где - ключи (String) - слово, значения (Integer) - частота встречаемости,
        //  вызвать метод task02, передать в него список из п.2, значение которое вернет метод присвоить объявленной переменой
        //  (так мы получим слова и частоту повторений)
        //  4. Создать список (ArrayList<Map.Entry<String, Integer>>) из пар мапы, объявленной в п.3
        //  (для получения коллекции пар использовать метод map.entrySet())
        //  5. Объявить класс ValuesComparator implements Comparator<Map.Entry<String, Integer>>,
        //  он позволит отсортировать список из п.4 по значениям (частоте встречаемости слов)
        //  6. Интерфейс обяжет Вас написать реализацию метода public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2):
        //     2.1. у объектов o1 и o2 получить значения свойства value (метод getValue) и сравнить числа
        //     2.3. вернуть из метода 0, если числа равны,
        //     вернуть из метода отрицательное число, если значение value объекта o1 больше значения value объекта o2,
        //     вернуть из метода положительное число, если значение value объекта o1 меньше значения value объекта o2
        //   7. Объявить объект класса ValuesComparator
        //   8. Вызвать метод sort() списка из п.4, передать в него компаратор из п.7
        //   9. Написать цикл на 10 итераций (или по количеству элементов списка (если их меньше 10)).
        //   Цикл должен перебирать список п.4, на каждой итерации выводить в консоль значение свойства key (метод getKey) элемента списка
    }
}


MAP.MD

Map используются для хранения данных в парах: ключ-значение
При выборе конкретного типа map следует учитывать:

безопасность использования в многопоточных средах;
необходимость в хранении элементов в определенном порядке: в порядке добавления, в отсортированном по ключам виде и т.д.;
скорость добавления, удаления, извлечения элементов.
Все классы, описывающие map, реализуют интерфейс Map и имеют общие особенности.
ключи должны быть уникальны
каждый ключ может отображать только одно значение
каждое значение можно найти по его ключу
Map не расширяет интерфейс Collection
порядок хранения элементов зависит от конкретной реализации
Некоторые методы интерфейса Map<K,V>:

void clear() - удаляет все пары (ключ-значение)
boolean containsKey(Object key) - возвращает true, если ключ содержится в map
boolean containsValue(Object value) - возвращает true, если ключ содержится в map
V get(Object key) - возвращает значение по ключу или null, если ключ в map отсутствует
V getOrDefault(Object key, V defaultValue) - возвращает значение по ключу или defaultValue, если ключ в map отсутствует
V put(K key, V value) - добавляет пару (ключ-значение). Если ключ уже есть в map, значение будет перезаписано
void putAll(Map<? extends K,? extends V> map)
V remove(Object key) - удаляет пару (ключ-значение) по
boolean remove(Object key, Object value)
V replace(K key, V value) - заменяет значение по ключу. Возвращает null, если ключ отсутствует
boolean replace(K key, V oldValue, V newValue) - заменяет значение oldValue на newValue, если oldValue ассоциировано с ключом key
int size() - возвращает количество пар (ключ-значение)
Collection<V> values() - возвращает коллекцию значений
Set<K> keySet() - возвращает множество ключей
Set<Map.Entry<K,V>> entrySet() - возвращает пары (ключ-значение)
Есть возможность создавать неизменяемые map: методы Map.of, Map.ofEntries, and Map.copyOf

При изучении методов необходимо учитывать версию java и особенности их реализации в конкретных классах. Например, методы, принимающие на вход ключ могут выбрасывать NullPointerException, если map не позволяет хранить null в качестве ключа.

Создание экземпляров map
Наиболее популярные непотокобезопасные реализации: HashMap, EnumMap, WeakHashMap, TreeMap, LinkedHashMap

Все map можно создать
пустыми (использовать конструктор без параметров)
на основе пар другой map (использовать конструктор, который принимает на вход другую map)
некоторые классы обладают дополнительными конструкторами (например, позволяющие задавать порядок сортировки ключей у TreeMap).
Все map типизированы (generic), при создании экземпляра необходимо указывать, какой тип данных будет храниться в map.
В map нельзя хранить примитивные типы данных.
HashMap
хранит ключи в hash-таблице (использует hashCode() ключей для размещения элементов)
имеет хорошую производительность
порядок хранения элементов может отличаться от порядка их добавления
в классах, экземпляры которые используются в качестве ключей обязательно должны быть переопределены методы equals и hashCode
null можно использовать в качестве ключа
Конструкторы:

HashMap() - создает пустую map, емкость - 16, фактор загрузки - 0.75
HashMap(int initialCapacity) - создает пустую map, емкость - initialCapacity, фактор загрузки - 0.75
HashMap(int initialCapacity, float loadFactor) - создает пустую map, емкость - initialCapacity, фактор загрузки - loadFactor
HashMap(Map<? extends K,? extends V> map) - создание map с элементами другой map, фактор загрузки - 0.75
Фактор загрузки - показатель того, на сколько заполненным может быть HashMap до того момента, когда ее емкость автоматически увеличится.
Начальная емкость - изначальное количество ячеек (корзин) в хэш-таблице.
LinkedHashMap
хранит ключи в hash-таблице (использует hashCode() ключей для размещения элементов)
имеет меньшую производительность по сравнению с HashMap
при переборе порядок доступ к элементам будет соответствовать порядку добавления
в классах, экземпляры которые используются в качестве ключей обязательно должны быть переопределены методы equals и hashCode
null можно использовать в качестве ключа
Конструкторы:

LinkedHashMap() - создает пустую map, емкость - 16, фактор загрузки - 0.75
LinkedHashMap(int initialCapacity) - создает пустую map, емкость - initialCapacity, фактор загрузки - 0.75
LinkedHashMap(int initialCapacity, float loadFactor) - создает пустую map, емкость - initialCapacity, фактор загрузки - loadFactor
LinkedHashMap(Map<? extends K,? extends V> map) - создание map с элементами другой map, фактор загрузки - 0.75
LinkedHashMap(int initialCapacity, float loadFactor, boolean accessOrder) - создает пустую map, емкость - initialCapacity, фактор загрузки - loadFactor, если accessOrder имеет значение true обращение к элементу методом get помещает его в конец
EnumMap
enum используется в качестве ключей, все ключи должны быть одного enum типа
null нельзя использовать в качестве ключа
содержит все значения в массиве (длина массива - количество элементов в enum)
порядок хранения элементов соответствует порядку элементов enum
для извлечения элемента из массива использует порядковый номер ключа (метод ordinal()) - values[key.ordinal()]
дает дополнительную оптимизацию производительности
Конструкторы:

EnumMap(Class<K> keyType) - создает пустую map, в конструктор необходимо передать ссылку на перечисление, которое будет использоваться в качестве ключей
EnumMap(EnumMap<K,? extends V> map) - создание map с элементами другой map, тип перечисления, которое будет использоваться в качестве ключей сохраняется
EnumMap(Map<K,? extends V> map) - аналогичен конструктору EnumMap(EnumMap<K,? extends V> map) или map должна содержать хотя бы одну пару для определения типа ключей
TreeMap
хранит элементы в отсортированном по ключам виде (красно-черное бинарное дерево)
null не может быть использован
в качестве ключа класс, объекты которого являются ключами должен реализовывать Comparable интерфейс, либо объект Comparator должен передаваться в конструктор TreeMap
Конструкторы:

TreeMap() - создает пустую map, с натуральным порядком сортировки по ключам. Сортировка осуществляется благодаря реализации метода compare интерфейса Comparable у ключей
TreeMap(Map<? extends K,? extends V> map) - создание map с элементами другой map, с натуральным порядком сортировки по ключам. Сортировка осуществляется благодаря реализации метода compare интерфейса Comparable у ключей
TreeMap(Comparator<? super K> comparator) - создает пустую map. Сортировка осуществляется благодаря экземпляру типа Comparator, который передается в конструктор
TreeMap(SortedMap<K,? extends V> map) - создает map из элементов другой отсортированной по ключам map. Порядок сортировки в новой map соответствует порядку сортировки исходной.
WeakHashMap
хранит ключи в hash-таблице (использует hashCode ключей для размещения элементов)
null можно использовать в качестве ключа
в классах, экземпляры которые используются в качестве ключей обязательно должны быть переопределены методы equals и hashCode
используется для кеширования
поведение зависит от сборщика мусора (метод size может возвращать меньшие значения с течением времени, метод isEmpty возвращать false, а затем true и т.п)
ключи удаляются сборщиком мусора после того, как на ключи не останется сильных ссылок. После этого из map удаляется и связанное с ключом значение
Конструкторы:

WeakHashMap() - создает пустую map, емкость - 16, фактор загрузки - 0.75
WeakHashMap(int initialCapacity) - создает пустую map, емкость - initialCapacity, фактор загрузки - 0.75
WeakHashMap(int initialCapacity, float loadFactor) - создает пустую map, емкость - initialCapacity, фактор загрузки - loadFactor
WeakHashMap(Map<? extends K,? extends V> map) - создание map с элементами другой map, фактор загрузки - 0.75
 */

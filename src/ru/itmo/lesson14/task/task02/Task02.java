package ru.itmo.lesson14.task.task02;

import java.util.*;

public class Task02 {
    public static void countEachPriority(List<Message> messageList) {
        int priorityLOW = 0;
        int priorityMEDIUM = 0;
        int priorityHIGH = 0;
        int priorityURGENT = 0;
        for (Message message : messageList) {
            switch (message.getPriority()) {
                case LOW:
                    priorityLOW++;
                    break;
                case MEDIUM:
                    priorityMEDIUM++;
                    break;
                case HIGH:
                    priorityHIGH++;
                    break;
                case URGENT:
                    priorityURGENT++;
                    break;
            }

        }

        System.out.println("Количество сообщение по приоритету priorityLOW равно: " + priorityLOW);
        System.out.println("Количество сообщение по приоритету priorityMEDIUM равно: " + priorityMEDIUM);
        System.out.println("Количество сообщение по приоритету priorityHIGH равно: " + priorityHIGH);
        System.out.println("Количество сообщение по приоритету priorityURGENT равно: " + priorityURGENT);
        // TODO:  Подсчитать количество сообщений для каждого приоритета
        //  Ответ в консоль
    }

    public static void countEachCode(List<Message> messageList) {
        // TODO: Подсчитать количество сообщений для каждого кода сообщения
        //  Ответ в консоль

        int arrayCount = 0;

        Map<Integer, Integer> messagesWithSpecificCode = new HashMap<>(); // это map, где key это код сообщения и value это количество сообщений с данным ключом
        for (Message message : messageList) {
            if (messagesWithSpecificCode.get(message.getCode()) == null) {
                messagesWithSpecificCode.put(message.getCode(), 1);

            } else {
                int newValue = messagesWithSpecificCode.get(message.getCode()) + 1;
                messagesWithSpecificCode.put(message.getCode(), newValue);
                System.out.println("map[message.getCode()] +  1  = " + messagesWithSpecificCode.get(message.getCode()));
            }

            for (Integer key : messagesWithSpecificCode.keySet()) {
                System.out.println("Количество сообщений с кодом " + key + " равно " + messagesWithSpecificCode.get(key));
            }

        }
    }

    public static void uniqueMessageCount(List<Message> messageList) {
        Set<Message> uniqueMessage = new HashSet<>();
        int countUniqueMessage = 0;
        for (Message message : messageList) {
            uniqueMessage.add(message);
        }
        System.out.println("количество уникальных сообщений = " + uniqueMessage.size());
        // TODO: Подсчитать количество уникальных сообщений
        //  Ответ в консоль
    }

    public static List<Message> uniqueMessagesInOriginalOrder(List<Message> messageList) {
        // TODO: вернуть только неповторяющиеся сообщения и в том порядке,
        //  в котором они встретились в первоначальном списке
        //  Например, было: [{URGENT, 4}, {HIGH, 9}, {LOW, 3}, {HIGH, 9}]
        //  на выходе: [{URGENT, 4}, {HIGH, 9}, {LOW, 3}]

        Set<Message> uniqueMessageWithOriginalOrder = new LinkedHashSet<>();
        List listUniqueMessageWithOrder = new ArrayList();
        int countUniqueMessage = 0;
        for (Message message : messageList) {
            if (uniqueMessageWithOriginalOrder.add(message)) {
                listUniqueMessageWithOrder.add(message);
//                System.out.println("уникальныe сообщения  по порядку = " +countUniqueMessage + " : " + message);
//                countUniqueMessage++;
            }
            ;
        }
        return listUniqueMessageWithOrder;
    }

    public static void removeEach(List<Message> messageList, Message.MessagePriority priority) {
        // TODO: удалить из коллекции каждое сообщение с заданным приоритетом
        //  вывод в консоль до удаления и после удаления
        System.out.println("коллекция до удаления = " + messageList);
        List<Message> messagesforDelete = new ArrayList<>();
        for (Message message : messageList) {
            if (message.getPriority() == priority){
                messagesforDelete.add(message);
            }
        }
        messageList.removeAll(messagesforDelete);
        System.out.println("коллекция  после удаления = " + messageList);
    }

    public static void removeOther(List<Message> messageList, Message.MessagePriority priority) {
        // TODO: удалить из коллекции все сообщения, кроме тех, которые имеют заданный приоритет
        //  вывод в консоль до удаления и после удаления

        System.out.println("старая коллекция до удаления = " + messageList);
        List<Message>  newMessages = new ArrayList<>();
        for (Message message : messageList) {
            if (message.getPriority() == priority){
                newMessages.add(message);
            }
        }

        System.out.println("новая коллекция  после удаления = " + newMessages);
    }

    public static void main(String[] args) {
        List<Message> messages = Message.generate(34);
        countEachPriority(messages);
        countEachCode(messages);
        uniqueMessageCount(messages);
        System.out.println(uniqueMessagesInOriginalOrder(messages));
        removeEach(messages, Message.MessagePriority.HIGH);
        removeOther(messages, Message.MessagePriority.LOW);
    }
}

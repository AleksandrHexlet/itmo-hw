package ru.itmo.coursePaper;


import ru.itmo.coursePaper.Utils.ENUM.SubscriptionType;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Objects;

public class FitnesCenter {
    private FitnesSubscription[] gym_visitors = new FitnesSubscription[20];
    private FitnesSubscription[] visitors_pool = new FitnesSubscription[20];
    private FitnesSubscription[] visitors_group_classes = new FitnesSubscription[20];

    private int countGYM = 0;
    private int countPOOL = 0;
    private int countGroupClasses = 0;
    private final LocalTime currentTime = LocalTime.now();


    public void addClient(FitnesSubscription subscription, SubscriptionType fitnessZone) {
        if (subscription.getDate_registration().isAfter(subscription.getEnd_date_registration())) {
            throw new IllegalArgumentException("Срок действия вашего абонемента истек. В ближайшее время с вами свяжется наш менеджер");
        }
        if (currentTime.isBefore(subscription.getSubscriptionType().getTime_start()) || currentTime.isAfter(subscription.getSubscriptionType().getEnd_time())) {
            System.out.println("По вашему абонементу " + subscription.getSubscriptionType().getName_subscription() + " Время посещения фитнес центра закончилось. Будем рады вас видеть в каждый день с " + subscription.getSubscriptionType().getTime_start() + " до " + subscription.getSubscriptionType().getEnd_time());
        return;
        }

        if (subscription.getSubscriptionType().getName_subscription().equals(SubscriptionType.ONE_TIME_SUBSCRIPTION.getName_subscription())) {

            if (fitnessZone.name().equals(SubscriptionType.GYM.name())) {
                getInfoClientWhoCame(subscription, fitnessZone);
                this.gym_visitors = addClientToGYM(subscription, fitnessZone, gym_visitors);
                System.out.println("gym_visitors = " + Arrays.toString(gym_visitors));
                return;
            } else if (fitnessZone.name().equals(SubscriptionType.SWIMMING_POOL.name())) {
                this.visitors_pool = addClientToPOOL(subscription, fitnessZone, visitors_pool);
                getInfoClientWhoCame(subscription, fitnessZone);
                System.out.println("visitors_pool = " + Arrays.toString(visitors_pool));
                return;
            } else {
                System.out.println("ONE_TIME_SUBSCRIPTION Ваш тип абонемента не позволяет посещать " + fitnessZone.name() + ". Обратитесь пожалуйста к вашему менеджеру");
                return;
            }
        }


        if (subscription.getSubscriptionType().getName_subscription().equals(SubscriptionType.DAILY_SUBSCRIPTION.getName_subscription())) {
            if (fitnessZone.name().equals(SubscriptionType.GYM.name())) {

                this.gym_visitors = addClientToGYM(subscription, fitnessZone, gym_visitors);
                getInfoClientWhoCame(subscription, fitnessZone);

                System.out.println("gym_visitors = " + Arrays.toString(gym_visitors));

                return;
            } else if (fitnessZone.name().equals(SubscriptionType.GROUP_CLASSES.name())) {

                this.visitors_group_classes = addClientToGroupClasses(subscription, fitnessZone, visitors_group_classes);
                getInfoClientWhoCame(subscription, fitnessZone);
                System.out.println("visitors_group_classes = " + Arrays.toString(visitors_group_classes));

                return;
            } else {
                System.out.println("Ваш тип абонемента DAILY_SUBSCRIPTION  и он не позволяет посещать " + fitnessZone.name() + ". Обратитесь пожалуйста к вашему менеджеру");
                return;
            }
        }

        if (subscription.getSubscriptionType().getName_subscription().equals(SubscriptionType.FULL_SUBSCRIPTION.getName_subscription())) {
            if (fitnessZone.name().equals(SubscriptionType.GYM.name())) {
                this.gym_visitors = addClientToGYM(subscription, fitnessZone, gym_visitors);
                System.out.println("gym_visitors = " + Arrays.toString(gym_visitors));
                getInfoClientWhoCame(subscription, fitnessZone);
                return;
            } else if (fitnessZone.name().equals(SubscriptionType.GROUP_CLASSES.name())) {
                this.visitors_group_classes = addClientToGroupClasses(subscription, fitnessZone, visitors_group_classes);

                System.out.println("visitors_group_classes = " + Arrays.toString(visitors_group_classes));
                getInfoClientWhoCame(subscription, fitnessZone);
                return;
            } else if (fitnessZone.name().equals(SubscriptionType.SWIMMING_POOL.name())) {
                this.visitors_pool = addClientToPOOL(subscription, fitnessZone,  visitors_pool);
                getInfoClientWhoCame(subscription, fitnessZone);
                System.out.println("visitors_pool = " + Arrays.toString(visitors_pool));
                return;
            }
        } else {
            System.out.println("Что-то пошло не так. По какой-то причине вы не можете посетить  " + fitnessZone.name() + ". Обратитесь пожалуйста к вашему менеджеру");
            return;
        }

    }


    /// очищаем массивы с записанными в GYM, POOL, GROUP_CLASSES после закрытия клуба
    public void closedFitness() {
        LocalTime start_time = SubscriptionType.FULL_SUBSCRIPTION.getTime_start();
        LocalTime end_time = SubscriptionType.FULL_SUBSCRIPTION.getEnd_time();


        while (currentTime.isBefore(start_time) || currentTime.isAfter(end_time)) {
            for (int i = 0; i < 20; i++) {
                if (this.visitors_pool[i] != null) this.visitors_pool[i] = null;
                if (this.visitors_group_classes[i] != null) this.visitors_group_classes[i] = null;
                if (this.gym_visitors[i] != null) this.gym_visitors[i] = null;
            }

            System.out.println("gym_visitors = " + Arrays.toString(gym_visitors));
            System.out.println("visitors_group_classes = " + Arrays.toString(visitors_group_classes));
            System.out.println("visitors_pool = " + Arrays.toString(visitors_pool));
            return;
        }

    }

    public void getInfoALLclients() {
        for (FitnesSubscription gym_visitor : gym_visitors) {
            if (gym_visitor != null)
                System.out.println(" В тренажерном зале зарегистрирован следующий посетитель " + gym_visitor);
        }

        for (FitnesSubscription visitor_pool : visitors_pool) {
            if (visitor_pool != null)
                System.out.println(" В бассейне зарегистрирован следующий посетитель " + visitor_pool);
        }

        for (FitnesSubscription visitors_group_class : visitors_group_classes) {
            if (visitors_group_class != null)
                System.out.println("На групповых занятиях зарегистрирован следующий посетитель " + visitors_group_class);
        }
    }

    public void getInfoClientWhoCame(FitnesSubscription subscription, SubscriptionType fitnesZone){
        LocalTime time = LocalTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        System.out.println("В фитнес центр пришел " + subscription.getOwner().getName() + " " + subscription.getOwner().getSurname() + ". Посетитель просит записать в " + fitnesZone.name() + ". Текущее время и дата " + time.format(formatter) + "; " + subscription.getCurrent_date());

    }


/*
Реализовать возможность вывода информации о посетителях: сначала посетителях тренажерного зала,
потом бассейна, потом групповых занятий.

Реализовать возможность выводить информацию в консоль каждый раз, когда абонемент регистрируется в
одной из зон (добавляется в массив). Информация для вывода:

Фамилия Имя Посещаемая зона (бассейн/тренажерный зал/групповые занятия)
Дата и время посещения
 */

    public FitnesSubscription[] addClientToGYM(FitnesSubscription subscription, SubscriptionType fitnesZone,  FitnesSubscription[] gym_visitors) {


        if (countGYM < gym_visitors.length) {
            gym_visitors[countGYM] = subscription;
            countGYM++;
            System.out.println("Вы записаны в " + fitnesZone.name() + ". Хорошей  вам тренировки");
        } else {
            System.out.println("В тренажерном зале нет мест. Попробуйте прийти позже");
        }
        return gym_visitors;
    }



    public  FitnesSubscription[] addClientToPOOL(FitnesSubscription subscription, SubscriptionType fitnesZone, FitnesSubscription[] visitors_pool) {

        if (countPOOL < visitors_pool.length) {
            visitors_pool[countPOOL] = subscription;
            countPOOL++;
            System.out.println("Вы записаны в " + fitnesZone.name() + ". Приятного вам плавания");
        } else {
            System.out.println("Бассейн полон. Попробуйте прийти позже");
        }
        return visitors_pool;
    };



    public FitnesSubscription[] addClientToGroupClasses(FitnesSubscription subscription, SubscriptionType fitnesZone, FitnesSubscription[] visitors_group_classes) {

        if (countGroupClasses < visitors_group_classes.length) {
            visitors_group_classes[countGroupClasses] = subscription;
            countGroupClasses++;
            System.out.println("Вы записаны в " + fitnesZone.name() + " . Хорошей вам тренировки ");
        } else {
            System.out.println("В классах с групповыми занятиями закончились свободные места. Попробуйте прийти позже");
        }
        return visitors_group_classes;
    };


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FitnesCenter that = (FitnesCenter) o;
        return countGYM == that.countGYM && countPOOL == that.countPOOL && countGroupClasses == that.countGroupClasses && Arrays.equals(gym_visitors, that.gym_visitors) && Arrays.equals(visitors_pool, that.visitors_pool) && Arrays.equals(visitors_group_classes, that.visitors_group_classes);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(countGYM, countPOOL, countGroupClasses);
        result = 31 * result + Arrays.hashCode(gym_visitors);
        result = 31 * result + Arrays.hashCode(visitors_pool);
        result = 31 * result + Arrays.hashCode(visitors_group_classes);
        return result;
    }

    @Override
    public String toString() {
        return "FitnesCenter{" +
                "gym_visitors=" + Arrays.toString(gym_visitors) +
                ", visitors_pool=" + Arrays.toString(visitors_pool) +
                ", visitors_group_classes=" + Arrays.toString(visitors_group_classes) +
                ", countGYM=" + countGYM +
                ", countPOOL=" + countPOOL +
                ", countGroupClasses=" + countGroupClasses +
                '}';
    }

}
package ru.itmo.coursePaper;

import ru.itmo.coursePaper.Utils.ENUM.AddClientToArr;
import ru.itmo.coursePaper.Utils.ENUM.FitnesZone;
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
    private LocalTime currentTime = LocalTime.now();


    public void addClient(FitnesSubscription subscription, FitnesZone fitnesZone) {
        if (subscription.getDate_registration().isAfter(subscription.getEnd_date_registration())) {
            throw new IllegalArgumentException("Срок действия вашего абонемента истек. В ближайшее время с вами свяжется наш менеджер");
        }
        if (currentTime.isBefore(subscription.getSubscriptionType().getTime_start()) || currentTime.isAfter(subscription.getSubscriptionType().getEnd_time())) {
            System.out.println("По вашему абонементу " + subscription.getSubscriptionType().getName_subscription() + " Время посещения фитнес центра закончилось. Будем рады вас видеть в каждый день с " + subscription.getSubscriptionType().getTime_start() + " до " + subscription.getSubscriptionType().getEnd_time());
        return;
        }

        if (subscription.getSubscriptionType().getName_subscription().equals(SubscriptionType.ONE_TIME_SUBSCRIPTION.getName_subscription())) {

            if (fitnesZone.name().equals(FitnesZone.GYM.name())) {
                getInfoClientWhoCame(subscription, fitnesZone);
                this.gym_visitors = AddClientToArr.addClientToGYM(subscription, fitnesZone, countGYM, gym_visitors);
                System.out.println("gym_visitors = " + Arrays.toString(gym_visitors));
                return;
            } else if (fitnesZone.name().equals(FitnesZone.SWIMMING_POOL.name())) {
                this.visitors_pool = AddClientToArr.addClientToPOOL(subscription, fitnesZone, countPOOL, visitors_pool);
                getInfoClientWhoCame(subscription, fitnesZone);
                System.out.println("visitors_pool = " + Arrays.toString(visitors_pool));
                return;
            } else {
                System.out.println("ONE_TIME_SUBSCRIPTION Ваш тип абонемента не позволяет посещать " + fitnesZone.name() + ". Обратитесь пожалуйста к вашему менеджеру");
                return;
            }
        }


        if (subscription.getSubscriptionType().getName_subscription().equals(SubscriptionType.DAILY_SUBSCRIPTION.getName_subscription())) {
            if (fitnesZone.name().equals(FitnesZone.GYM.name())) {

                this.gym_visitors = AddClientToArr.addClientToGYM(subscription, fitnesZone, countGYM, gym_visitors);
                getInfoClientWhoCame(subscription, fitnesZone);

                System.out.println("gym_visitors = " + Arrays.toString(gym_visitors));

                return;
            } else if (fitnesZone.name().equals(FitnesZone.GROUP_CLASSES.name())) {

                this.visitors_group_classes = AddClientToArr.addClientToGroupClasses(subscription, fitnesZone, countGroupClasses, visitors_group_classes);
                getInfoClientWhoCame(subscription, fitnesZone);
                System.out.println("visitors_group_classes = " + Arrays.toString(visitors_group_classes));

                return;
            } else {
                System.out.println("Ваш тип абонемента DAILY_SUBSCRIPTION  и он не позволяет посещать " + fitnesZone.name() + ". Обратитесь пожалуйста к вашему менеджеру");
                return;
            }
        }

        if (subscription.getSubscriptionType().getName_subscription().equals(SubscriptionType.FULL_SUBSCRIPTION.getName_subscription())) {
            if (fitnesZone.name().equals(FitnesZone.GYM.name())) {
                this.gym_visitors = AddClientToArr.addClientToGYM(subscription, fitnesZone, countGYM, gym_visitors);
                System.out.println("gym_visitors = " + Arrays.toString(gym_visitors));
                getInfoClientWhoCame(subscription, fitnesZone);
                return;
            } else if (fitnesZone.name().equals(FitnesZone.GROUP_CLASSES.name())) {
                this.visitors_group_classes = AddClientToArr.addClientToGroupClasses(subscription, fitnesZone, countGroupClasses, visitors_group_classes);

                System.out.println("visitors_group_classes = " + Arrays.toString(visitors_group_classes));
                getInfoClientWhoCame(subscription, fitnesZone);
                return;
            } else if (fitnesZone.name().equals(FitnesZone.SWIMMING_POOL.name())) {
                this.visitors_pool = AddClientToArr.addClientToPOOL(subscription, fitnesZone, countPOOL, visitors_pool);
                getInfoClientWhoCame(subscription, fitnesZone);
                System.out.println("visitors_pool = " + Arrays.toString(visitors_pool));
                return;
            }
        } else {
            System.out.println("Что-то пошло не так. По какой-то причине вы не можете посетить  " + fitnesZone.name() + ". Обратитесь пожалуйста к вашему менеджеру");
            return;
        }

    }


    /// очищаем массивы с записанными в GYM, POOL, GROUP_CLASSES после закрытия клуба
    public void closedFitnes() {
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
        for (int i = 0; i < gym_visitors.length; i++) {
            if (gym_visitors[i] != null)
                System.out.println(" В тренажерном зале зарегистрированн следующий посетитель " + gym_visitors[i]);
        }

        for (int i = 0; i < visitors_pool.length; i++) {
            if (visitors_pool[i] != null)
                System.out.println(" В бассейне зарегистрированн следующий посетитель " + visitors_pool[i]);
        }

        for (int i = 0; i < visitors_group_classes.length; i++) {
            if (visitors_group_classes[i] != null)
                System.out.println("На групповых занятиях зарегистрированн следующий посетитель " + visitors_group_classes[i]);
        }
    }

    public void getInfoClientWhoCame(FitnesSubscription subscription, FitnesZone fitnesZone){
        LocalTime time = LocalTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        System.out.println("В финес центр пришел " + subscription.getOwner().getName() + " " + subscription.getOwner().getSurname() + ". Посетитель записался в " + fitnesZone.name() + ". Текущее время и дата " + time.format(formatter) + "; " + subscription.getCurrent_date());
    }


/*
Реализовать возможность вывода информации о посетителях: сначала посетителях тренажерного зала,
потом бассейна, потом групповых занятий.

Реализовать возможность выводить информацию в консоль каждый раз, когда абонемент регистрируется в
одной из зон ( добавляется в массив). Информация для вывода:

Фамилия Имя Посещаемая зона (бассейн/тренажерный зал/групповые занятия)
Дата и время посещения
 */


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
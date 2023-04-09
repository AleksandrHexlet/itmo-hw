package ru.itmo.coursePaper;

import ru.itmo.coursePaper.Utils.ENUM.FitnesZone;
import ru.itmo.coursePaper.Utils.ENUM.SubscriptionType;

import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.Objects;


public class FitnesSubscription {
//    SubscriptionType one_time_subscription = SubscriptionType.ONE_TIME_SUBSCRIPTION;
//    SubscriptionType daily_subscription = SubscriptionType.DAILY_SUBSCRIPTION;
//    SubscriptionType full_subscription = SubscriptionType.FULL_SUBSCRIPTION;
    private SubscriptionType subscriptionType;
    private int numberSubscription =(int)(Math.random() * 99999);
    private LocalDate date_registration =  LocalDate.now();
    private LocalDate current_date =  LocalDate.now();

    private LocalDate end_date_registration = LocalDate.of(9999, Month.OCTOBER, 25);;

    private Owner owner;
//    Каждый абонемент хранит номер, дату регистрации (текущая дата) и дату окончания регистрации.
//    Каждый абонемент хранит информацию о владельце (НЕ НАОБОРОТ).
//    Данные о владельце: имя, фамилия, год рождения.


    //public static FitnesSubscription[] addClientToPOOL(FitnesSubscription subscription, FitnesZone fitnesZone, int countPOOL, FitnesSubscription[] visitors_pool) {
// FitnesSubscription делаем метод addClient и проверяем SubscriptionType, если допустим он == ONE_TIME_SUBSCRIPTION,
// и допустим FitnesZone.SWIMMING_POOL тогда в addClient вызываем статический метод метод addClientToPOOL,
// если клиент хочет на груповые занятия, а абонемент не позволяет, тогда сообщение в консоль.
// Проверки в коде ниже

        /*
        if (subscription.subscriptionType.getName_subscription().equals(SubscriptionType.ONE_TIME_SUBSCRIPTION.getName_subscription()) && fitnesZone.name() == FitnesZone.GYM.name() || fitnesZone.name() == FitnesZone.SWIMMING_POOL.name()) {

            if (fitnesZone.name().equals(FitnesZone.SWIMMING_POOL) && countPOOL < visitors_pool.length) {
                visitors_pool[countPOOL] = subscription;
                countPOOL++;
                System.out.println(fitnesZone.name() + " ждёт вас. Приятного плавания");
            } else {
                System.out.println("Бассейн полон. Попробуйте прийти позже");
            }

        } else {
            System.out.println("Ваш тип абонемента не позволяет посещать " + fitnesZone.name() + ". Обратитесь пожалуйста к вашему менеджеру");
        }
        System.out.println("gym_visitors  =" + Arrays.toString(gym_visitors));
        System.out.println("visitors_pool  =" + Arrays.toString(visitors_pool));
    };

    */

//    public FitnesSubscription(SubscriptionType subscriptionType) {
//        this.subscriptionType = subscriptionType;
//    }

    public FitnesSubscription(SubscriptionType subscriptionType, Owner owner) {
        this.subscriptionType = subscriptionType;
        this.owner = owner;
    }

    public void getDate(){
        System.out.println("текущая дата " + date_registration);
        System.out.println("end_date " + end_date_registration);
        boolean isBefore = date_registration.isBefore(end_date_registration);
        System.out.println("isBefore: " + isBefore);
    }

    public SubscriptionType getSubscriptionType() {
        return subscriptionType;
    }

    public int getNumberSubscription() {
        return numberSubscription;
    }

    public LocalDate getDate_registration() {
        return date_registration;
    }

    public LocalDate getCurrent_date() {
        return current_date;
    }

    public LocalDate getEnd_date_registration() {
        return end_date_registration;
    }

    public Owner getOwner() {
        return owner;
    }

    public void somecode(){

//        FitnesSubscription fitnessSubscription = new FitnesSubscription(SubscriptionType.FULL_SUBSCRIPTION);
//        fitnessSubscription.getTime();
//
//        LocalTime time = LocalTime.now();
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
//        LocalTime lt1 = LocalTime.of( 22 , 17 ) ;
//        LocalTime lt2 = LocalTime.of( 21 , 29 ) ;
//
//        boolean isBefore = time.isBefore( lt1 ) ;
//        boolean isBefore1 = lt1.isBefore( time ) ;
//        System.out.println("isBefore1 =  " + isBefore1);
//        System.out.println("isBefore =  " + isBefore);
//
//        System.out.println("time = " +time.format(formatter));
//        String name_subs =  fitnessSubscription.getOne_time_subscription().getName_subscription();
//        System.out.println("name subscription = "+ name_subs);
//        System.out.println("getEnd_time() subscription = "+ fitnessSubscription.getOne_time_subscription().getEnd_time());
//        System.out.println("getTime_start() subscription = "+ fitnessSubscription.getOne_time_subscription().getTime_start());
//        System.out.println("local time = "+   formatter   +("HH:mm:ss");

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FitnesSubscription that = (FitnesSubscription) o;
        return numberSubscription == that.numberSubscription && subscriptionType == that.subscriptionType && date_registration.equals(that.date_registration) && end_date_registration.equals(that.end_date_registration) && owner.equals(that.owner);
    }

    @Override
    public int hashCode() {
        return Objects.hash(subscriptionType, numberSubscription, date_registration, end_date_registration, owner);
    }

    @Override
    public String toString() {
        return "FitnesSubscription{" +
                "subscriptionType=" + subscriptionType +
                ", numberSubscription=" + numberSubscription +
                ", date_registration=" + date_registration +
                ", end_date_registration=" + end_date_registration +
                ", owner=" + owner +
                '}';
    }
}


/*
В фитнес клубе есть три типа абонементов:

Разовый (на один день). По разовому абонементу клиенты могут посещать бассейн и
тренажерный зал с 8 до 22 часов.
Дневной (срок действия может быть любым). По данному абонементу клиенты могут посещать
тренажерный зал и групповые занятия (но не бассейн) с 8 до 16 часов.
Полный (срок действия может быть любым). По данному абонементу клиенты могут посещать
тренажерный зал, бассейн и групповые занятия с 8 до 22 часов.
Каждый абонемент хранит номер, дату регистрации (текущая дата) и дату окончания регистрации.
Каждый абонемент хранит информацию о владельце (НЕ НАОБОРОТ). Данные о владельце: имя, фамилия, год рождения.
 */
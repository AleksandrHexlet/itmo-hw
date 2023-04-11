package ru.itmo.coursePaper;


import ru.itmo.coursePaper.Utils.ENUM.FitnesZone;
import ru.itmo.coursePaper.Utils.ENUM.SubscriptionType;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) {

        FitnesCenter fitnesCenter = new FitnesCenter();


        Owner owner01 = new Owner("Ivan","Ivanov",1999);
        Owner owner02 = new Owner("Igor","Igorev",1989);
        Owner owner03 = new Owner("Zahar","Zaharov",1979);
        FitnesSubscription fitnesSubscriptionONE = new FitnesSubscription(SubscriptionType.ONE_TIME_SUBSCRIPTION,owner01);
        FitnesSubscription fitnesSubscriptionDaily = new FitnesSubscription(SubscriptionType.DAILY_SUBSCRIPTION, owner02);
        FitnesSubscription fitnesSubscriptionFull = new FitnesSubscription(SubscriptionType.FULL_SUBSCRIPTION,owner03);


        fitnesCenter.addClient(fitnesSubscriptionONE, FitnesZone.GYM);

        fitnesCenter.addClient(fitnesSubscriptionONE, FitnesZone.SWIMMING_POOL);

        fitnesCenter.addClient(fitnesSubscriptionONE, FitnesZone.GROUP_CLASSES);



        fitnesCenter.addClient(fitnesSubscriptionDaily, FitnesZone.GYM);

        fitnesCenter.addClient(fitnesSubscriptionDaily, FitnesZone.SWIMMING_POOL);

        fitnesCenter.addClient(fitnesSubscriptionDaily, FitnesZone.GROUP_CLASSES);



        fitnesCenter.addClient(fitnesSubscriptionFull, FitnesZone.GYM);

        fitnesCenter.addClient(fitnesSubscriptionFull, FitnesZone.SWIMMING_POOL);

        fitnesCenter.addClient(fitnesSubscriptionFull, FitnesZone.GROUP_CLASSES);


        fitnesCenter.closedFitnes();

    }
}

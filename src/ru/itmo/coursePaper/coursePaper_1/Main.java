package ru.itmo.coursePaper;


import ru.itmo.coursePaper.Utils.ENUM.SubscriptionType;

public class Main {
    public static void main(String[] args) {

        FitnesCenter fitnesCenter = new FitnesCenter();


        Owner owner01 = new Owner("Ivan","Ivanov",1999);
        Owner owner02 = new Owner("Igor","Igorev",1989);
        Owner owner03 = new Owner("Zahar","Zaharov",1979);
        FitnesSubscription fitnesSubscriptionONE = new FitnesSubscription(SubscriptionType.ONE_TIME_SUBSCRIPTION,owner01);

        FitnesSubscription fitnesSubscriptionDaily = new FitnesSubscription(SubscriptionType.DAILY_SUBSCRIPTION, owner02);
        FitnesSubscription fitnesSubscriptionFull = new FitnesSubscription(SubscriptionType.FULL_SUBSCRIPTION,owner03);

//
//        fitnesCenter.addClient(fitnesSubscriptionONE, SubscriptionType.GYM);
//
//        fitnesCenter.addClient(fitnesSubscriptionONE, SubscriptionType.SWIMMING_POOL);

//        fitnesCenter.addClient(fitnesSubscriptionONE, SubscriptionType.GROUP_CLASSES);



//        fitnesCenter.addClient(fitnesSubscriptionDaily, SubscriptionType.GYM);

//        fitnesCenter.addClient(fitnesSubscriptionDaily, SubscriptionType.SWIMMING_POOL);

//        fitnesCenter.addClient(fitnesSubscriptionDaily, SubscriptionType.GROUP_CLASSES);



        fitnesCenter.addClient(fitnesSubscriptionFull, SubscriptionType.GYM);

//        fitnesCenter.addClient(fitnesSubscriptionFull, SubscriptionType.SWIMMING_POOL);

//        fitnesCenter.addClient(fitnesSubscriptionFull, SubscriptionType.GROUP_CLASSES);



        fitnesCenter.closedFitness();

    }
}

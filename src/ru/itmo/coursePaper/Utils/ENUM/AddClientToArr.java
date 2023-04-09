package ru.itmo.coursePaper.Utils.ENUM;

import ru.itmo.coursePaper.FitnesSubscription;

public class AddClientToArr {

    public static FitnesSubscription[] addClientToGYM(FitnesSubscription subscription, FitnesZone fitnesZone, int countGYM, FitnesSubscription[] gym_visitors) {


        if (countGYM < gym_visitors.length) {
            gym_visitors[countGYM] = subscription;
            countGYM++;
            System.out.println("Вы записаны в " + fitnesZone.name() + ". Хорошей  вам тренировки");
        } else {
            System.out.println("В тренажерном зале нет мест. Попробуйте прийти позже");
        }
        return gym_visitors;
    }



    public static FitnesSubscription[] addClientToPOOL(FitnesSubscription subscription, FitnesZone fitnesZone, int countPOOL, FitnesSubscription[] visitors_pool) {

        if (countPOOL < visitors_pool.length) {
            visitors_pool[countPOOL] = subscription;
            countPOOL++;
            System.out.println("Вы записаны в " + fitnesZone.name() + ". Приятного вам плавания");
        } else {
            System.out.println("Бассейн полон. Попробуйте прийти позже");
        }
        return visitors_pool;
    };



    public static FitnesSubscription[] addClientToGroupClasses(FitnesSubscription subscription, FitnesZone fitnesZone, int countGroupClasses, FitnesSubscription[] visitors_group_classes) {

        if (countGroupClasses < visitors_group_classes.length) {
            visitors_group_classes[countGroupClasses] = subscription;
            countGroupClasses++;
            System.out.println("Вы записаны в " + fitnesZone.name() + " . Хорошей вам тренировки ");
        } else {
            System.out.println("Бассейн полон. Попробуйте прийти позже");
        }
        return visitors_group_classes;
    };

};







// FitnesSubscription делаем метод addClient и проверяем SubscriptionType, если допустим он == ONE_TIME_SUBSCRIPTION,
// и допустим FitnesZone.SWIMMING_POOL тогда в addClient вызываем статический метод метод addClientToPOOL,
// если клиент хочет на груповые занятия, а абонемент не позволяет, тогда сообщение в консоль




//       System.out.println("subscription.name = " + subscription.subscriptionType.getName_subscription() + "; fitnesZone === " + fitnesZone.name());
//        System.out.println("SubscriptionType.ONE_TIME_SUBSCRIPTION = " + SubscriptionType.ONE_TIME_SUBSCRIPTION.getName_subscription());
//
//
//        System.out.println("1. SubscriptionType.ONE_TIME_SUBSCRIPTION  = " + SubscriptionType.ONE_TIME_SUBSCRIPTION.getName_subscription() + ";  subscription.subscriptionType.getName_subscription() = " + subscription.subscriptionType.getName_subscription());
//        System.out.println("2. fitnesZone.name()  = " + fitnesZone.name() + ";  FitnesZone.GYM.name() = " + FitnesZone.GYM.name());
//        System.out.println("3. fitnesZone.name()  = " + fitnesZone.name() + "; FitnesZone.SWIMMING_POOL.name() = " + FitnesZone.SWIMMING_POOL.name());
//        System.out.println("4. countGYM  = " + countGYM + "; gym_visitors.length = " + gym_visitors.length);
//
//        boolean q = countGYM < gym_visitors.length;
//        System.out.println("5. subscription.subscriptionType.getName_subscription().equals(SubscriptionType.ONE_TIME_SUBSCRIPTION.getName_subscription()) === " + subscription.subscriptionType.getName_subscription().equals(SubscriptionType.ONE_TIME_SUBSCRIPTION.getName_subscription()));
//        System.out.println("6. fitnesZone.name().equals(FitnesZone.GYM)  = " + fitnesZone.name().equals(FitnesZone.GYM) + "; countGYM < gym_visitors.length = " + q);



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

        System.out.println("visitors_pool  =" + Arrays.toString(visitors_pool));
    };

            System.out.println("gym_visitors  =" + Arrays.toString(gym_visitors));
        System.out.println("visitors_pool  =" + Arrays.toString(visitors_pool));
 */
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





package ru.itmo.coursePaper.Utils.ENUM;

import java.time.LocalTime;

public enum SubscriptionType {
    ONE_TIME_SUBSCRIPTION("one_time",LocalTime.of( 8, 00 ),LocalTime.of( 22 , 00 )),
    DAILY_SUBSCRIPTION("daily_subscription", LocalTime.of( 8, 00 ),LocalTime.of( 16 , 00 )),
    FULL_SUBSCRIPTION("full_subscription", LocalTime.of( 8, 00 ),LocalTime.of( 22 , 00 ));

    private String name_subscription;
//    private LocalTime time_start =LocalTime.of( 8 , 00 ) ;
//    private LocalTime end_time =LocalTime.of( 22 , 00 ) ;

    private LocalTime time_start ;
    private LocalTime end_time;
    SubscriptionType(String name_subscription, LocalTime time_start, LocalTime end_time) {
        this.name_subscription = name_subscription;
        this.time_start = time_start;
        this.end_time = end_time;
    }



    public String getName_subscription() {
        return name_subscription;
    }

    public LocalTime getTime_start() {
        return time_start;
    }

    public LocalTime getEnd_time() {
        return end_time;
    }
}


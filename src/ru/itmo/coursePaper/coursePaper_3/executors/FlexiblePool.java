package ru.itmo.coursePaper.coursePaper_3.executors;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class FlexiblePool extends ThreadPoolExecutor {
    // можно объявить собственные свойства и методы
    public FlexiblePool(int corePoolSize, // минимальное (== изначальное количество потоков)
                        int maximumPoolSize, // максимальное количество потоков
                        long keepAliveTime, // время простаивания потока
                        TimeUnit unit, // ед. измерения keepAliveTime
                        BlockingQueue<Runnable> workQueue) // очередь для задач
    {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
    }

    // можно переопределить методы ThreadPoolExecutor согласно модификаторам,
    // например,
    @Override
    protected void beforeExecute(Thread t, Runnable r) {
//        AppTask appTask = (AppTask) r;
//        System.out.println("Задача '" + appTask.getName() + "' начинает выполняться");
    }

    @Override
    protected void afterExecute(Runnable r, Throwable t) {
//        AppTask appTask = (AppTask) r;
//        if (t == null) System.out.println("Выполнение '" + appTask.getName() + "' успешно завершено");
//        else System.out.println("Во время выполнения '" + appTask.getName() + "' произошла ошибка");
    }
}

package io.swagger.utils;

import io.swagger.model.AlarmBody;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AlarmFactory {
    private final int NUM_THREADS = 10;
    private final ExecutorService executor = Executors.newFixedThreadPool(NUM_THREADS);
    private final Map<Number, Alarm> alarms = new HashMap<>();


    public Alarm createAlarm(AlarmBody alarm) {
        BasicAlarm basicAlarm = new BasicAlarm(alarm);
        basicAlarm.setFuture(executor.submit(basicAlarm.alarmLogic()));
        alarms.put(basicAlarm.getIdentifier(), basicAlarm);
        return basicAlarm;
    }

}


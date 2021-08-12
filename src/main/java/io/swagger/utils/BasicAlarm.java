package io.swagger.utils;

import io.swagger.model.AlarmBody;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class BasicAlarm implements Alarm {

    private Future<Alarm> future;
    private AlarmBody alarm;
    private Callable<Alarm> alarmLogic = () -> {
        int waitSeconds = alarm.getDelay().intValue();
        System.out.printf("Starting alarm: %s\n", alarm.getName());
        TimeUnit.SECONDS.sleep(waitSeconds);
        System.out.printf("%d seconds later...\n",waitSeconds);
        System.out.printf("Ending alarm: %s\n", alarm.getName());
        return this;
    };

    public BasicAlarm(AlarmBody alarm) {
        this.alarm = alarm;
    }

    protected void setFuture(Future<Alarm> future){
        this.future = future;
    }

    @Override
    public int getIdentifier() {
        return alarm.hashCode();
    }

    @Override
    public Future<Alarm> getFuture() {
        return future;
    }

    @Override
    public Callable<Alarm> alarmLogic() {
        return alarmLogic;
    }
}

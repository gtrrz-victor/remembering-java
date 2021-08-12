package io.swagger.utils;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;

public interface Alarm {
    int getIdentifier();
    Future<Alarm> getFuture();
    Callable<Alarm> alarmLogic();

    default boolean hasGoneOff(){
        return this.getFuture().isDone();
    }
}

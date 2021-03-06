package io.swagger.dao;

import io.swagger.model.AlarmBody;
import org.springframework.data.annotation.Id;

import java.math.BigDecimal;

public class Alarm {

    @Id
    public String id;

    public String name;
    public int delay;

    public Alarm() {}

    public Alarm(String firstName, int delay) {
        this.name = firstName;
        this.delay = delay;
    }

    @Override
    public String toString() {
        return String.format(
                "Alarm[id=%s, name='%s', delay='%d']",
                id, name, delay);
    }

    public static Alarm parse(AlarmBody alarm){
        return new Alarm(alarm.getName(),alarm.getDelay().intValue());
    }

    public io.swagger.model.Alarm toModel(){
        return new io.swagger.model.Alarm().name(name).value(BigDecimal.valueOf(delay));
    }

}
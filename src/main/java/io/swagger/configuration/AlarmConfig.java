package io.swagger.configuration;

import io.swagger.utils.AlarmFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class AlarmConfig {

    @Bean
    @Scope("singleton")
    public AlarmFactory alarmFactory(){
        return new AlarmFactory();
    }
}

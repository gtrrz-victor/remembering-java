package io.swagger.configuration;

import io.swagger.utils.AlarmFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AlarmConfig {

    @Bean
    public AlarmFactory alarmFactory(){
        return new AlarmFactory();
    }
}

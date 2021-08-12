package io.swagger.service;

import io.swagger.dao.Alarm;
import io.swagger.dao.AlarmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlarmService {

    private final AlarmRepository repository;

    @Autowired
    public AlarmService(AlarmRepository repository) {
        this.repository = repository;
    }

    public List<Alarm> findAll(){
        return repository.findAll();
    }

    public Alarm findByName(String name){
        return repository.findByName(name);
    }
    public void create(Alarm alarm){
        repository.save(alarm);
    }
}

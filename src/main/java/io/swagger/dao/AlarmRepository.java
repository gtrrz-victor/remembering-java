package io.swagger.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface AlarmRepository extends MongoRepository<Alarm, String> {

    Alarm findByName(String firstName);

}

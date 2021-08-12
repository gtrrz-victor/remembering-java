package io.swagger.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.model.Alarm;
import io.swagger.model.AlarmBody;
import io.swagger.model.AlarmCreatedResponse;
import io.swagger.service.AlarmService;
import io.swagger.utils.AlarmFactory;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-08-12T00:01:02.404Z[GMT]")
@RestController
public class AlarmApiController implements AlarmApi {

    private static final Logger log = LoggerFactory.getLogger(AlarmApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    private final AlarmFactory alarmFactory;

    private final AlarmService alarmService;

    @org.springframework.beans.factory.annotation.Autowired
    public AlarmApiController(ObjectMapper objectMapper, HttpServletRequest request, AlarmFactory alarmFactory, AlarmService alarmService) {
        this.objectMapper = objectMapper;
        this.request = request;
        this.alarmFactory = alarmFactory;
        this.alarmService = alarmService;
    }

    public ResponseEntity<AlarmCreatedResponse> alarmAlarmNamePost(@Parameter(in = ParameterIn.PATH, description = "", required=true, schema=@Schema()) @PathVariable("alarmName") String alarmName) {
        io.swagger.dao.Alarm alarm = alarmService.findByName(alarmName);
        int identifier = alarmFactory.createAlarm(new AlarmBody().name(alarm.name).delay(BigDecimal.valueOf(alarm.delay))).getIdentifier();
        return new ResponseEntity<AlarmCreatedResponse>(new AlarmCreatedResponse().code(BigDecimal.valueOf(identifier)).description("Alarm successfully created"), HttpStatus.OK);
    }

    public ResponseEntity<AlarmCreatedResponse> createAlarm(@Parameter(in = ParameterIn.DEFAULT, description = "alarm's data", required=true, schema=@Schema()) @Valid @RequestBody AlarmBody body) {
        int identifier = alarmFactory.createAlarm(body).getIdentifier();
        alarmService.create(io.swagger.dao.Alarm.parse(body));
        return new ResponseEntity<AlarmCreatedResponse>(new AlarmCreatedResponse().code(BigDecimal.valueOf(identifier)).description("Alarm successfully created"), HttpStatus.OK);
    }

    public ResponseEntity<List<Alarm>> findAllAlarms() {
        return new ResponseEntity<List<Alarm>>(alarmService.findAll().stream().map(alarm -> alarm.toModel()).collect(Collectors.toList()),HttpStatus.OK);
    }

}

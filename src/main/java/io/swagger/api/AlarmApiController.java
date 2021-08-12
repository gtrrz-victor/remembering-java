package io.swagger.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.model.AlarmBody;
import io.swagger.model.InlineResponse2001;
import io.swagger.utils.Alarm;
import io.swagger.utils.AlarmFactory;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.math.BigDecimal;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-08-12T00:01:02.404Z[GMT]")
@RestController
public class AlarmApiController implements AlarmApi {

    private static final Logger log = LoggerFactory.getLogger(AlarmApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    private final AlarmFactory alarmFactory;

    @org.springframework.beans.factory.annotation.Autowired
    public AlarmApiController(ObjectMapper objectMapper, HttpServletRequest request, AlarmFactory alarmFactory) {
        this.objectMapper = objectMapper;
        this.request = request;
        this.alarmFactory = alarmFactory;
    }

    public ResponseEntity<InlineResponse2001> createAlarm(@Parameter(in = ParameterIn.DEFAULT, description = "alarm's data", required = true, schema = @Schema()) @Valid @RequestBody AlarmBody body) {
        Alarm alarm = alarmFactory.createAlarm(body);
        return new ResponseEntity<InlineResponse2001>(
                new InlineResponse2001().code(BigDecimal.valueOf(alarm.getIdentifier())).description("Alarm successfully created"),
                HttpStatus.OK);
    }

}

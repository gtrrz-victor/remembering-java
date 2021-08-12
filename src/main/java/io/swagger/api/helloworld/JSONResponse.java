package io.swagger.api.helloworld;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.io.IOException;

public class JSONResponse implements Response {

    private final ObjectMapper objectMapper;

    public JSONResponse(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Override
    public ResponseEntity<String> build() {
        ResponsePOJO resp = new ResponsePOJO();
        resp.setName("Victor");
        resp.setValue(32);
        try {
            return new ResponseEntity<String>(objectMapper.writeValueAsString(resp), HttpStatus.OK);
        } catch (IOException e) {
            return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

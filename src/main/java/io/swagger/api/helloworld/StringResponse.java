package io.swagger.api.helloworld;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class StringResponse implements Response{

    @Override
    public ResponseEntity<String> build() {
        return new ResponseEntity<String>("response as string",HttpStatus.OK);
    }
}

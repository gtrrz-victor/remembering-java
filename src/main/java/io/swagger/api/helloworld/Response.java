package io.swagger.api.helloworld;

import org.springframework.http.ResponseEntity;

public interface Response {
    ResponseEntity<String> build();
}

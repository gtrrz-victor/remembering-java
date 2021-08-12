package io.swagger.api.helloworld;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.MediaType;

import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Stream;

public enum ResponseFactory {
    APPLICATION_JSON(MediaType.APPLICATION_JSON_VALUE) {
        @Override
        public Response createResponse(ObjectMapper objectMapper) {
            return new JSONResponse(objectMapper);
        }
    },
    TEXT_PLAIN(MediaType.TEXT_PLAIN_VALUE) {
        @Override
        public Response createResponse(ObjectMapper objectMapper) {
            return new StringResponse();
        }
    };

    public final String label;

    public abstract Response createResponse(ObjectMapper objectMapper);

    ResponseFactory(String label) {
        this.label = label;
    }

    public static final ResponseFactory valueByAccept(String accept) throws HeaderNotAllowedException {
        Optional<ResponseFactory> value =Arrays.stream(ResponseFactory.values()).filter(r -> r.label.equals(accept)).findFirst();
        if (value.isPresent())return value.get();
        throw new HeaderNotAllowedException("Header not accepted. Header value: "+ accept);
    }
}


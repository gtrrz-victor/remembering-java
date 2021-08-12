package io.swagger.api.helloworld;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.Mock;
import org.springframework.http.MediaType;
import static org.junit.Assert.*;
public class ResponseFactoryTest {

    @Mock
    ObjectMapper objectMapper;
    @Rule
    public ExpectedException exception = ExpectedException.none();


    @Test
    public void responseJSONTest() throws HeaderNotAllowedException {
            Response response = ResponseFactory.valueByAccept(MediaType.APPLICATION_JSON_VALUE).createResponse(objectMapper);
            assertEquals(JSONResponse.class,response.getClass());
    }

    @Test(expected = HeaderNotAllowedException.class)
    public void errorWhenNotValidAcceptHeader() throws HeaderNotAllowedException {
        ResponseFactory.valueByAccept(MediaType.ALL_VALUE).createResponse(objectMapper);
    }

    @Test
    public void responseTextPlain() throws HeaderNotAllowedException {
        Response response = ResponseFactory.valueByAccept(MediaType.TEXT_PLAIN_VALUE).createResponse(objectMapper);
        assertEquals(StringResponse.class,response.getClass());
    }
}

package io.swagger.api;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class HelloworldApiControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void plainTextResponseTest() throws Exception {
        this.mvc.perform(get("/helloworld").header("Accept", "text/plain"))
                .andExpect(status().isOk())
                .andExpect(content().string("response as string"));
    }

    @Test
    public void jsonResponseTest() throws Exception {
        this.mvc.perform(get("/helloworld").header("Accept", "application/json"))
                .andExpect(status().isOk())
                .andExpect(content().string("{\"name\":\"Victor\",\"value\":32}"));
    }
}

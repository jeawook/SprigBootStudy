package me.restapi.demoinfleanrestapi.index;

import me.restapi.demoinfleanrestapi.common.BaseControllerTest;
import org.junit.jupiter.api.Test;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class IndexControllerTests extends BaseControllerTest {

    /*@Test

    public void index() throws Exception{
        this.mockMvc.perform(get("/api"))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("_links.events").exists());
    }*/
}

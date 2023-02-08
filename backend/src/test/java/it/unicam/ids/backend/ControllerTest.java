package it.unicam.ids.backend;

import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class ControllerTest {

    private final MockMvc mvc;
    private final String path;


    public ControllerTest(MockMvc mvc, String path) {
        this.mvc = mvc;
        this.path = path;
    }


    public void getAll() throws Exception {
        mvc.perform(get(path + "/all"))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith("application/json"));
    }

    public void getOne() throws Exception {
        mvc.perform(get(path + "/{id}", 1))
                .andExpect(status().isOk());
    }
}

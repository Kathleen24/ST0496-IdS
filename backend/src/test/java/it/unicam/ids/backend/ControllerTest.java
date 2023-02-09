package it.unicam.ids.backend;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class ControllerTest {

    private final MockMvc mvc;
    private final String path;
    private final ObjectMapper mapper = new ObjectMapper();


    public ControllerTest(MockMvc mvc, String path) {
        this.mvc = mvc;
        this.path = path;
    }


    public void getAll() throws Exception {
        mvc.perform(get(path + "/all"))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith("application/json"));
    }

    public void getOne(Object id) throws Exception {
        mvc.perform(get(path + "/{id}", id))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith("application/json"));
    }

    public void add(Object object) throws Exception {
        mvc.perform(post(path + "/add")
                        .contentType("application/json")
                        .content(mapper.writeValueAsString(object)))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith("application/json"));
    }

    public void delete(Object id) throws Exception {
        mvc.perform(MockMvcRequestBuilders.delete(path + "/{id}", id))
                .andExpect(status().isOk());
    }
}

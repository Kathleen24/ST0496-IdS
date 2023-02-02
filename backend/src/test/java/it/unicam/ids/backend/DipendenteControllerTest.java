package it.unicam.ids.backend;

import it.unicam.ids.backend.repository.DipendenteRepository;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@Import(ClienteControllerIntegrationTest.class)
public class DipendenteControllerTest {
    @Autowired
    private DipendenteRepository dipendenteRepository;

}

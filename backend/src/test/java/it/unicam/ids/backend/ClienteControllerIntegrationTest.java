package it.unicam.ids.backend;

import it.unicam.ids.backend.entity.Cliente;
import it.unicam.ids.backend.entity.UtentePiattaforma;
import it.unicam.ids.backend.repository.ClienteRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.MOCK,
        classes = BackendApplication.class
)
@AutoConfigureMockMvc
@TestPropertySource(
        locations = "classpath:application-integration-test.properties"
)
public class ClienteControllerIntegrationTest {

    @Autowired
    private MockMvc mvc;
    @Autowired
    private ClienteRepository clienteRepository;
    private ControllerTest controllerTest;


    @Before
    public void setUp() {
        controllerTest = new ControllerTest(mvc, "/clienti");
    }

    @Test
    public void getAll() throws Exception {
        controllerTest.getAll();
    }

    @Test
    public void givenCliente_whenGetCliente_thenStatus200() throws Exception {
        controllerTest.getOne();
    }

    @Test
    public void addCliente() throws Exception {
        //TODO
        Cliente cliente = new Cliente(new UtentePiattaforma("kjnasc", "njksdc", "njksd", new Date(), "nksdc", "njksdc", "njic", "nksdc", "njksdc", "mksldc"),
                "nome", "pass", "email");
        clienteRepository.save(cliente);
    }

    @Test
    public void givenCliente() throws Exception {
        //TODO
        Cliente cliente = new Cliente(new UtentePiattaforma("kjnasc", "njksdc", "njksd", new Date(), "nksdc", "njksdc", "njic", "nksdc", "njksdc", "mksldc"),
                "nome", "pass", "email");
    }
}

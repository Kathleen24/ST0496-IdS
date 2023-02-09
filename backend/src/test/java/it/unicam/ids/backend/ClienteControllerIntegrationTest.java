package it.unicam.ids.backend;

import it.unicam.ids.backend.entity.Azienda;
import it.unicam.ids.backend.entity.Bonus;
import it.unicam.ids.backend.entity.Cliente;
import it.unicam.ids.backend.entity.ProgrammaFedelta;
import it.unicam.ids.backend.entity.UtentePiattaforma;
import it.unicam.ids.backend.repository.*;
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
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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

    private static final String PATH = "/clienti";

    @Autowired
    private MockMvc mvc;

    //region Repositories
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private UtentePiattaformaRepository utentePiattaformaRepository;
    @Autowired
    private ProgrammaFedeltaRepository programmaFedeltaRepository;
    @Autowired
    private ProgrammaFedeltaDelClienteRepository programmaFedeltaDelClienteRepository;
    @Autowired
    private BonusRepository bonusRepository;
    @Autowired
    private AziendaRepository aziendaRepository;
    //endregion

    private ControllerTest controllerTest;


    @Before
    public void setUp() {
        controllerTest = new ControllerTest(mvc, PATH);

        programmaFedeltaDelClienteRepository.deleteAll();
        bonusRepository.deleteAll();
        programmaFedeltaRepository.deleteAll();
        aziendaRepository.deleteAll();
        clienteRepository.deleteAll();
        utentePiattaformaRepository.deleteAll();
    }

    @Test
    public void getAll() throws Exception {
        controllerTest.getAll();
    }

    @Test
    public void getOne() throws Exception {
        Cliente cliente = saveCliente();

        controllerTest.getOne(cliente.getTessera());
    }

    @Test
    public void addCliente() throws Exception {
        UtentePiattaforma utente = new UtentePiattaforma("kjnasc", "njksdc", "njksd", new Date(), "nksdc", "njksdc", "njic", "nksdc", "njksdc", "mksldc");
        Cliente cliente = new Cliente(utente,
                "nome", "pass", "email");

        controllerTest.add(cliente);
    }

    @Test
    public void deleteCliente() throws Exception {
        Cliente cliente = saveCliente();

        controllerTest.delete(cliente.getTessera());
    }

    @Test
    public void addProgrammaFedelta() throws Exception {
        Cliente cliente = saveCliente();
        ProgrammaFedelta programmaFedelta = saveProgrammaFedelta();

        mvc.perform(post(PATH + "/addProgrammaFedelta")
                .param("tessera", cliente.getTessera().toString())
                .param("pfId", programmaFedelta.getId().toString()))
                .andExpect(status().isOk());
    }

    @Test
    public void qrcode() throws Exception {
        Cliente cliente = saveCliente();

        mvc.perform(get(PATH + "/{tessera}/qrcode", cliente.getTessera()))
                .andExpect(status().isOk());
    }


    private Cliente saveCliente() {
        UtentePiattaforma utente = new UtentePiattaforma("kjnasc", "njksdc", "njksd", new Date(), "nksdc", "njksdc", "njic", "nksdc", "njksdc", "mksldc");
        Cliente cliente = new Cliente(utente,
                "nome", "pass", "email");

        utentePiattaformaRepository.save(utente);
        return clienteRepository.save(cliente);
    }

    private ProgrammaFedelta saveProgrammaFedelta() {
        Azienda azienda = new Azienda("nome", "legge, processo", "email", "link");
        Bonus bonus = new Bonus(azienda, 1237894, "descrizi", Bonus.Tipo.CASHBACK);
        ProgrammaFedelta programmaFedelta = new ProgrammaFedelta(azienda, List.of(bonus), List.of(3678));

        aziendaRepository.save(azienda);
        bonusRepository.save(bonus);
        return programmaFedeltaRepository.save(programmaFedelta);
    }
}

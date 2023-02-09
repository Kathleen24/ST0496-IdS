package it.unicam.ids.backend.service;

import it.unicam.ids.backend.entity.Cliente;
import it.unicam.ids.backend.entity.ProgrammaFedeltaDelCliente;
import it.unicam.ids.backend.repository.ClienteRepository;
import it.unicam.ids.backend.repository.ProgrammaFedeltaDelClienteRepository;
import it.unicam.ids.backend.repository.ProgrammaFedeltaRepository;
import it.unicam.ids.backend.repository.UtentePiattaformaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;
    private final UtentePiattaformaRepository utentePiattaformaRepository;
    private final ProgrammaFedeltaDelClienteRepository programmaFedeltaDelClienteRepository;
    private final ProgrammaFedeltaRepository programmaFedeltaRepository;


    public ClienteService(
            ClienteRepository clienteRepository,
            UtentePiattaformaRepository utentePiattaformaRepository,
            ProgrammaFedeltaDelClienteRepository programmaFedeltaDelClienteRepository,
            ProgrammaFedeltaRepository programmaFedeltaRepository
    ) {
        this.clienteRepository = clienteRepository;
        this.utentePiattaformaRepository = utentePiattaformaRepository;
        this.programmaFedeltaDelClienteRepository = programmaFedeltaDelClienteRepository;
        this.programmaFedeltaRepository = programmaFedeltaRepository;
    }


    public List<Cliente> getAllClienti() {
        return clienteRepository.findAll();
    }

    public Cliente getCliente(Integer tessera) {
        return clienteRepository.findById(tessera).orElse(null);
    }

    public Cliente addCliente(Cliente cliente) {
        utentePiattaformaRepository.save(cliente.getUtentePiattaforma());
        return clienteRepository.save(cliente);
    }

    public Cliente updateCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public void deleteCliente(Integer tessera) {
        clienteRepository.deleteById(tessera);
    }

    public void addProgrammaFedelta(Integer tessera, Integer pfId) {
        Cliente cliente = getCliente(tessera);
        cliente.getProgrammiFedelta().add(
            programmaFedeltaDelClienteRepository.save(new ProgrammaFedeltaDelCliente(
                    pfId, tessera,
                    programmaFedeltaRepository.findById(pfId).orElseThrow()
            ))
        );
        clienteRepository.save(cliente);
    }

    public void addPunti(Integer tessera, Integer pfID, int punti) {
        Cliente cliente = getCliente(tessera);

        cliente.getProgrammiFedelta().stream()
                .filter(pf -> pf.getProgrammaFedeltaID().equals(pfID))
                .findFirst().orElseThrow()
                .addPunti(punti);
        updateCliente(cliente);
    }

    public Set<ProgrammaFedeltaDelCliente> getAllProgrammiFedeltaOf(Integer tessera) {
        return getCliente(tessera).getProgrammiFedelta();
    }

    //Per il sequence diagram Visualizza progressi programma fedeltà
    public ProgrammaFedeltaDelCliente getProgrammaFedeltaOf(Integer tessera, Integer pfID) {
        return getCliente(tessera).getProgrammiFedelta().stream()
                .filter(pf -> pf.getProgrammaFedeltaID().equals(pfID))
                .findFirst().orElse(null);
    }

    public void addProgrammaFedeltaToCliente(Integer tessera, Integer pfID) {
        getCliente(tessera).addProgrammaFedelta(getProgrammaFedeltaOf(tessera, pfID));
    }

}

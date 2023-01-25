package it.unicam.ids.backend.service;

import it.unicam.ids.backend.entity.Cliente;
import it.unicam.ids.backend.entity.ProgrammaFedeltaDelCliente;
import it.unicam.ids.backend.id.ProgrammaFedeltaDelClienteID;
import it.unicam.ids.backend.repository.ClienteRepository;
import it.unicam.ids.backend.repository.ProgrammaFedeltaDelClienteRepository;
import it.unicam.ids.backend.repository.ProgrammaFedeltaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;
    private final ProgrammaFedeltaDelClienteRepository programmaFedeltaDelClienteRepository;
    private final ProgrammaFedeltaRepository programmaFedeltaRepository;


    public ClienteService(
            ClienteRepository clienteRepository,
            ProgrammaFedeltaDelClienteRepository programmaFedeltaDelClienteRepository,
            ProgrammaFedeltaRepository programmaFedeltaRepository
    ) {
        this.clienteRepository = clienteRepository;
        this.programmaFedeltaDelClienteRepository = programmaFedeltaDelClienteRepository;
        this.programmaFedeltaRepository = programmaFedeltaRepository;
    }


    public List<Cliente> getAllClienti() {
        return clienteRepository.findAll();
    }

    public Cliente getCliente(Integer tessera) {
        return clienteRepository.findById(tessera).orElse(null);
    }

    public void addCliente(Cliente cliente) {
        clienteRepository.saveAndFlush(cliente);
    }

    public void updateCliente(Cliente cliente) {
        clienteRepository.saveAndFlush(cliente);
    }

    public void deleteCliente(Integer tessera) {
        clienteRepository.deleteById(tessera);
    }

    public void addProgrammaFedelta(Integer tessera, Integer pfId) {
        Cliente cliente = getCliente(tessera);
        cliente.getProgrammiFedelta().add(
            programmaFedeltaDelClienteRepository.saveAndFlush(new ProgrammaFedeltaDelCliente(
                    new ProgrammaFedeltaDelClienteID(pfId, tessera),
                    programmaFedeltaRepository.findById(pfId).orElseThrow()
            ))
        );
        clienteRepository.saveAndFlush(cliente);
        // TODO: 25/01/23 Test
    }

    public void addPunti(Integer tessera, Integer pfID, int punti) {
        Cliente cliente = getCliente(tessera);

        cliente.getProgrammiFedelta().stream()
                .filter(pf -> pf.getId().getProgrammaFedeltaID().equals(pfID))
                .findFirst().orElseThrow()
                .addPunti(punti);
        updateCliente(cliente);
    }

    public Set<ProgrammaFedeltaDelCliente> getAllProgrammiFedeltaOf(Integer tessera) {
        return getCliente(tessera).getProgrammiFedelta();
    }

    //Per il sequence diagram Visualizza progressi programma fedeltà
    public ProgrammaFedeltaDelCliente getProgrammaFedeltaOf(Integer tessera, Integer pfID) {
        Cliente cliente = getCliente(tessera);
        return cliente.getProgrammiFedelta().stream()
                .filter(pf -> pf.getId().getProgrammaFedeltaID().equals(pfID))
                .findFirst().orElse(null);
    }

    public void addProgrammaFedeltaToCliente(Integer tessera, Integer pfID){
        getCliente(tessera).addProgrammaFedelta(getProgrammaFedeltaOf(tessera, pfID));
    }
}

package it.unicam.ids.backend.service;

import it.unicam.ids.backend.entity.Cliente;
import it.unicam.ids.backend.entity.ProgrammaFedelta;
import it.unicam.ids.backend.entity.ProgrammaFedeltaDelCliente;
import it.unicam.ids.backend.id.ProgrammaFedeltaDelClienteID;
import it.unicam.ids.backend.id.ProgrammaFedeltaID;
import it.unicam.ids.backend.repository.ClienteRepository;
import it.unicam.ids.backend.repository.ProgrammaFedeltaDelClienteRepository;
import it.unicam.ids.backend.repository.ProgrammaFedeltaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
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
        Optional<Cliente> cliente = this.clienteRepository.findById(tessera);
        return cliente.orElse(null);
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

    public void addProgrammaFedelta(Integer tessera, ProgrammaFedeltaID pfId) {
        //getCliente(tessera).getProgrammiFedelta().add(
        programmaFedeltaDelClienteRepository.saveAndFlush(new ProgrammaFedeltaDelCliente(
                new ProgrammaFedeltaDelClienteID(pfId, tessera),
                getCliente(tessera),
                programmaFedeltaRepository.findById(pfId).orElseThrow()
        ));
        //);
    }

    public void addPunti(Integer tessera, ProgrammaFedeltaID pfId, int punti) {
        Cliente cliente = getCliente(tessera);

        cliente.getProgrammiFedelta().stream()
                .filter(pf -> pf.getId().getProgrammaFedeltaID().equals(pfId))
                .findFirst().orElseThrow().addPunti(punti);
        updateCliente(cliente);
    }

    public Set<ProgrammaFedeltaDelCliente> getAllProgrammiFedeltaOf(Integer tessera){
        Cliente cliente = getCliente(tessera);
        return cliente.getProgrammiFedelta();
    }

    //Per il sequence diagram Visualizza progressi programma fedeltà
    public ProgrammaFedeltaDelCliente getProgrammaFedeltaOf(Integer tessera, ProgrammaFedeltaID programmaFedeltaID){
        Cliente cliente=getCliente(tessera);
        return cliente.getProgrammiFedelta().stream()
                .filter(pf -> pf.getId().getProgrammaFedeltaID().equals(programmaFedeltaID))
                .findFirst().orElse(null);
    }

    public void addProgrammaFedeltaToCliente(Integer tessera, ProgrammaFedeltaID programmaFedeltaID){
        Cliente cliente = getCliente(tessera);
        cliente.addProgrammaFedelta(getProgrammaFedeltaOf(tessera, programmaFedeltaID));
    }


}

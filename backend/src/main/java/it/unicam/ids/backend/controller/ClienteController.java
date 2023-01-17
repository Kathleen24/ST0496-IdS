package it.unicam.ids.backend.controller;

import it.unicam.ids.backend.entity.Cliente;
import it.unicam.ids.backend.id.ProgrammaFedeltaID;
import it.unicam.ids.backend.service.ClienteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clienti")
public class ClienteController {

    private final ClienteService clienteService;


    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }


    public List<Cliente> getAllClienti() {
        return clienteService.getAllClienti();
    }

    public Cliente getCliente(Integer tessera) {
        return clienteService.getCliente(tessera);
    }

    public void addCliente(Cliente cliente) {
        clienteService.addCliente(cliente);
    }

    public void updateCliente(Cliente cliente) {
        clienteService.updateCliente(cliente);
    }

    public void deleteCliente(Integer tessera) {
        clienteService.deleteCliente(tessera);
    }

    @PostMapping("/addProgrammaFedelta")
    public void addProgrammaFedelta(@RequestParam Integer tessera, @RequestBody ProgrammaFedeltaID pfId) {
        clienteService.addProgrammaFedelta(tessera, pfId);
    }

    @PostMapping("/addPunti")
    public void addPunti(@RequestParam Integer tessera, @RequestParam ProgrammaFedeltaID pfId, @RequestParam int punti) {
        clienteService.addPunti(tessera, pfId, punti);
    }
}

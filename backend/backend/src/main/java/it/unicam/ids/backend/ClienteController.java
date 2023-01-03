package it.unicam.ids.backend;

import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
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
}

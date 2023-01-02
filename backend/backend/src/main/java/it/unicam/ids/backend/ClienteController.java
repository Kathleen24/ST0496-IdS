package it.unicam.ids.backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
@RestController
public class ClienteController {
    @Autowired
    private ClienteService clienteService;
    public List<Cliente> getAllClienti() {
        return clienteService.getAllClienti();
    }
    public Cliente getAzienda(Integer tessera) {
        return clienteService.getCliente(tessera);
    }
    public void addAzienda(Cliente cliente) {
        clienteService.addCliente(cliente);
    }
    public void updateAzienda(Integer tessera, Cliente cliente) {
        clienteService.updateCliente(tessera,cliente); //in teoria senza id tra parentesi
    }
    public void deleteAzienda(Integer tessera) {
        clienteService.deleteCliente(tessera);
    }

}

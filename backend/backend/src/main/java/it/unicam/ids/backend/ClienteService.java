package it.unicam.ids.backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> getAllClienti() { return clienteRepository.findAll();}

    public Cliente getCliente(Integer tessera){
        Optional<Cliente> cliente = this.clienteRepository.findById(tessera);
        return cliente.orElse(null);
    }

    public void addCliente(Cliente cliente) { clienteRepository.save(cliente); }
    public void updateCliente(Integer tessera, Cliente cliente) {
        clienteRepository.save(cliente);
    }
    public void deleteCliente(Integer tessera) { clienteRepository.deleteById(tessera);}
}

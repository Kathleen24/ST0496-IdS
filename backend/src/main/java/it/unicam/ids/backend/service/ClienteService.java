package it.unicam.ids.backend.service;

import it.unicam.ids.backend.entity.Cliente;
import it.unicam.ids.backend.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;


    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }


    public List<Cliente> getAllClienti() {
        return clienteRepository.findAll();
    }

    public Cliente getCliente(Integer tessera) {
        Optional<Cliente> cliente = this.clienteRepository.findById(tessera);
        return cliente.orElse(null);
    }

    public void addCliente(Cliente cliente) {
        clienteRepository.save(cliente);
    }

    public void updateCliente(Cliente cliente) {
        clienteRepository.save(cliente);
    }

    public void deleteCliente(Integer tessera) {
        clienteRepository.deleteById(tessera);
    }
}

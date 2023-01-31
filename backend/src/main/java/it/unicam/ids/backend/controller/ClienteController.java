package it.unicam.ids.backend.controller;

import it.unicam.ids.backend.entity.Cliente;
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


    @GetMapping("/all")
    public List<Cliente> getAllClienti() {
        return clienteService.getAllClienti();
    }

    @GetMapping("/{tessera}")
    public Cliente getCliente(@PathVariable Integer tessera) {
        return clienteService.getCliente(tessera);
    }

    @PostMapping("/add")
    public Cliente addCliente(@RequestBody Cliente cliente) {
        return clienteService.addCliente(cliente);
    }

    @PostMapping("/update")
    public Cliente updateCliente(@RequestBody Cliente cliente) {
        return clienteService.updateCliente(cliente);
    }

    @DeleteMapping("/{tessera}")
    public void deleteCliente(@PathVariable Integer tessera) {
        clienteService.deleteCliente(tessera);
    }

    @PostMapping("/addProgrammaFedelta")
    public void addProgrammaFedelta(@RequestParam Integer tessera, @RequestParam Integer pfId) {
        clienteService.addProgrammaFedelta(tessera, pfId);
    }

    @PostMapping("/addPunti")
    public void addPunti(@RequestParam Integer tessera, @RequestParam Integer pfId, @RequestParam int punti) {
        clienteService.addPunti(tessera, pfId, punti);
    }
}
package it.unicam.ids.backend.controller;

import it.unicam.ids.backend.entity.Abbonamento;
import it.unicam.ids.backend.entity.Cliente;
import it.unicam.ids.backend.service.ClienteService;
import it.unicam.ids.backend.util.EntityValidator;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.regex.Pattern;

@RestController
@RequestMapping("/clienti")
public class ClienteController implements EntityValidator<Cliente> {

    private final ClienteService clienteService;


    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    public void validateEntity(Cliente cliente) {
        if (cliente==null)
            throw new NullPointerException("L'oggetto cliente è nullo");
        if(clienteService.getCliente(cliente.getTessera())!=null)
            throw new IllegalArgumentException("La tessera è già esistente");
        //nome utente
        if(!clienteService.getAllClienti().stream().filter(c->c.getEmail().equals(cliente.getEmail())).findFirst().isEmpty())
            throw new IllegalArgumentException("L'email è già esistente");
        if(!Pattern.compile("^(.+)@(\\S+)$").matcher(cliente.getEmail()).matches())
            throw new IllegalArgumentException("L'email inserita non è ben composta");
        //password String

    }
    @GetMapping("/all")
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
    public void addProgrammaFedelta(@RequestParam Integer tessera, @RequestParam Integer pfId) {
        clienteService.addProgrammaFedelta(tessera, pfId);
    }

    @PostMapping("/addPunti")
    public void addPunti(@RequestParam Integer tessera, @RequestParam Integer pfId, @RequestParam int punti) {
        clienteService.addPunti(tessera, pfId, punti);
    }

    //Per sequence diagram Visualizza dati personali
    public void visualizzaDatiPersonali(Integer tessera){
        getCliente(tessera).toString();
    }
}

package it.unicam.ids.backend.controller;

import it.unicam.ids.backend.entity.Cliente;
import it.unicam.ids.backend.entity.ProgrammaFedeltaDelCliente;
import it.unicam.ids.backend.service.ClienteService;
import it.unicam.ids.backend.util.EntityValidator;
import it.unicam.ids.backend.util.QRCodeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.image.BufferedImage;
import java.util.List;
import java.util.regex.Pattern;

@RestController
@RequestMapping("/clienti")
public class ClienteController implements EntityValidator<Cliente> {

    private final ClienteService clienteService;
    private final QRCodeService qrCodeService;


    public ClienteController(ClienteService clienteService, QRCodeService qrCodeService) {
        this.clienteService = clienteService;
        this.qrCodeService = qrCodeService;
    }


    @Override
    public void validateEntity(Cliente cliente) {
        if (cliente == null)
            throw new NullPointerException("L'oggetto cliente è nullo");

        if (clienteService.getCliente(cliente.getTessera()) != null)
            throw new IllegalArgumentException("La tessera è già esistente");
        //nome utente
        if(clienteService.getAllClienti().stream().anyMatch(c -> c.getEmail().equals(cliente.getEmail())))
            throw new IllegalArgumentException("L'email è già esistente");
        if(!Pattern.compile("^(.+)@(\\S+)$").matcher(cliente.getEmail()).matches())
            throw new IllegalArgumentException("L'email inserita non è ben composta");
        //password String
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

    @GetMapping("/{tessera}/programmiFedelta")
    public List<ProgrammaFedeltaDelCliente> getProgrammiFedeltaDelCliente(@PathVariable Integer tessera) {
        return getCliente(tessera).getProgrammiFedelta().stream().toList();
    }

    /**
     * Questo metodo genera un QRCode contenente il link per invitare nuovi utenti.
     *
     * @param tessera il numero della tessera di chi genera il QRCode
     * @return il QRCode in formato PNG(250x250)
     *
     * @throws Exception Eccezioni generiche
     */
    @GetMapping("/{tessera}/qrcode")
    public ResponseEntity<BufferedImage> linkInviti(@PathVariable String tessera) throws Exception {
        //TODO Aggiungere il formato del link da comporre con la tessera.
        return qrCodeService.qrCodeGenerator(tessera);
    }
}

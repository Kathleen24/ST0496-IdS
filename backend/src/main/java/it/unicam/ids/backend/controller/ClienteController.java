package it.unicam.ids.backend.controller;

import it.unicam.ids.backend.entity.Cliente;
import it.unicam.ids.backend.service.ClienteService;
import it.unicam.ids.backend.util.QRCodeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.image.BufferedImage;
import java.util.List;

@RestController
@RequestMapping("/clienti")
public class ClienteController {

    private final ClienteService clienteService;
    private final QRCodeService qrCodeService;

    public ClienteController(ClienteService clienteService, QRCodeService qrCodeService) {
        this.clienteService = clienteService;
        this.qrCodeService = qrCodeService;
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
    public String visualizzaDatiPersonali(Integer tessera){
        return getCliente(tessera).toString();
    }

    /**
     * Questo metodo genera un QRCode contenente il link per invitare nuovi utenti.
     * @param tessera - il numero della tessera di chi genera il QRCode.
     * @return - il QRCode in formato PNG(250x250).
     * @throws Exception - Eccezioni generiche.
     */
    @GetMapping("/qrcode/{id}")
    public ResponseEntity<BufferedImage> linkInviti(@RequestParam ("tessera") String tessera) throws Exception{
        //TODO Aggiungere il formato del link da comporre con la tessera.
        return qrCodeService.qrCodeGenerator(tessera);
    }
}
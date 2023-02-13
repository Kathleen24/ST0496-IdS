package it.unicam.ids.backend.controller;

import it.unicam.ids.backend.entity.Recensione;
import it.unicam.ids.backend.id.RecensioneID;
import it.unicam.ids.backend.service.AziendaService;
import it.unicam.ids.backend.service.RecensioneService;
import it.unicam.ids.backend.util.EntityValidator;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/recensioni")
public class RecensioneController implements EntityValidator<Recensione> {

    private final RecensioneService recensioneService;
    private final AziendaService aziendaService;


    public RecensioneController(RecensioneService recensioneService, AziendaService aziendaService) {
        this.recensioneService = recensioneService;
        this.aziendaService = aziendaService;
    }


    @Override
    public void validateEntity(Recensione recensione) {
        if (recensione == null)
            throw new NullPointerException("L'oggetto recensione è nullo");
        if(recensione.getVoto() < 1 || recensione.getVoto() > 5)
            throw new IllegalArgumentException("Il voto deve essere compreso tra 1 e 5");

        if(aziendaService.getAzienda(recensione.getAziendaID()) == null)
            throw new IllegalArgumentException("L'azienda inserita non è esistente");
    }

    @GetMapping("/all")
    public List<Recensione> getAllRecensioni() {
        return recensioneService.getAllRecensioni();
    }

    @GetMapping("/{tessera}@{aziendaID}")
    public Recensione getRecensione(RecensioneID id) {
        return recensioneService.getRecensione(id);
    }

    @PostMapping("/add")
    public Recensione addRecensione(@RequestBody Recensione recensione) {
        return recensioneService.addRecensione(recensione);
    }

    @PostMapping("/update")
    public Recensione updateRecensione(@RequestBody Recensione recensione) {
        return recensioneService.updateRecensione(recensione);
    }
    @DeleteMapping("/{tessera}@{aziendaID}")
    public void deleteRecensione(RecensioneID id) {
        recensioneService.deleteRecensione(id);
    }
}
package it.unicam.ids.backend.controller;

import it.unicam.ids.backend.entity.Dipendente;
import it.unicam.ids.backend.id.DipendenteID;
import it.unicam.ids.backend.service.DipendenteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dipendenti")
public class DipendenteController {

    private final DipendenteService dipendenteService;


    public DipendenteController(DipendenteService dipendenteService) {
        this.dipendenteService = dipendenteService;
    }


    @GetMapping("/all")
    public List<Dipendente> getAllDipendenti() {
        return dipendenteService.getAllDipendente();
    }

    @GetMapping("/{nomeUtente}@{aziendaID}")
    public Dipendente getDipendente(DipendenteID id) {
        return dipendenteService.getDipendente(id);
    }

    @PostMapping("/add")
    public Dipendente addDipendente(@RequestBody Dipendente dipendente) {
        return dipendenteService.addDipendente(dipendente);
    }

    @PostMapping("/update")
    public Dipendente updateDipendente(@RequestBody Dipendente dipendente) {
        return dipendenteService.updateDipendente(dipendente);
    }

    @DeleteMapping("/{nomeUtente}@{aziendaID}")
    public void deleteDipendente(DipendenteID id) {
        dipendenteService.deleteDipendente(id);
    }
}

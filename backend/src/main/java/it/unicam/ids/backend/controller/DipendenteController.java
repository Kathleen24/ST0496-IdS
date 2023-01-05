package it.unicam.ids.backend.controller;

import it.unicam.ids.backend.entity.Dipendente;
import it.unicam.ids.backend.service.DipendenteService;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class DipendenteController {

    private final DipendenteService dipendenteService;


    public DipendenteController(DipendenteService dipendenteService) {
        this.dipendenteService = dipendenteService;
    }


    public List<Dipendente> getAllDipendenti() {
        return dipendenteService.getAllDipendente();
    }

    public Dipendente getDipendente(String nomeUtente) {
        return dipendenteService.getDipendente(nomeUtente);
    }

    public void addDipendente(Dipendente dipendente) {
        dipendenteService.addDipendente(dipendente);
    }

    public void updateDipendente(Dipendente dipendente) {
        dipendenteService.updateDipendente(dipendente);
    }

    public void deleteDipendente(String nomeUtente) {
        dipendenteService.deleteDipendente(nomeUtente);
    }
}

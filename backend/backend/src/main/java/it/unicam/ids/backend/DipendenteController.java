package it.unicam.ids.backend;

import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class DipendenteController {

    private final DipendenteService dipendenteService;


    public DipendenteController(DipendenteService dipendenteService) {
        this.dipendenteService = dipendenteService;
    }


    public List<Dipendente> getAllAziende() {
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

package it.unicam.ids.backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class DipendeteController {
    @Autowired
    private DipendeteService dipendeteService;

    public List<Dipendete> getAllAziende() {return dipendeteService.getAllDipendete();}

    public Dipendete getDipendente(String nomeUtente) {return dipendeteService.getDipendete(nomeUtente);}

    public void addDipendete(Dipendete dipendete) {dipendeteService.addDipendete(dipendete);}

    public void updateDipendente(String nomeUtente, Dipendete dipendete){
        dipendeteService.updateDipendete(nomeUtente,dipendete);
    }

    public void deleteDipendete(String nomeUtente) {dipendeteService.deleteDipendete(nomeUtente);}
}

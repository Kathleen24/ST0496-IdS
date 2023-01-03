package it.unicam.ids.backend;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AziendaController {

    private final AziendaService aziendaServiceDB;


    public AziendaController(AziendaService aziendaServiceDB) {
        this.aziendaServiceDB = aziendaServiceDB;
    }


    public List<Azienda> getAllAziende() {
        return aziendaServiceDB.getAllAziende();
    }

    public Azienda getAzienda(Integer id) {
        return aziendaServiceDB.getAzienda(id);
    }

    public void addAzienda(Azienda azienda) {
        aziendaServiceDB.addAzienda(azienda);
    }

    public void updateAzienda(Azienda azienda) {
        aziendaServiceDB.updateAzienda(azienda);
    }

    public void deleteAzienda(Integer id) {
        aziendaServiceDB.deleteAzienda(id);
    }
}

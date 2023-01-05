package it.unicam.ids.backend.controller;

import it.unicam.ids.backend.entity.Azienda;
import it.unicam.ids.backend.service.AziendaService;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AziendaController {

    private final AziendaService aziendaService;


    public AziendaController(AziendaService aziendaServiceDB) {
        this.aziendaService = aziendaServiceDB;
    }


    public List<Azienda> getAllAziende() {
        return aziendaService.getAllAziende();
    }

    public Azienda getAzienda(Integer id) {
        return aziendaService.getAzienda(id);
    }

    public void addAzienda(Azienda azienda) {
        aziendaService.addAzienda(azienda);
    }

    public void updateAzienda(Azienda azienda) {
        aziendaService.updateAzienda(azienda);
    }

    public void deleteAzienda(Integer id) {
        aziendaService.deleteAzienda(id);
    }
}

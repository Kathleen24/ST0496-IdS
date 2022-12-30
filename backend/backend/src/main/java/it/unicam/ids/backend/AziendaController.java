package it.unicam.ids.backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AziendaController {
    @Autowired
    private AziendaService aziendaServiceDB;

    public List<Azienda> getAllAziende() {
        return aziendaServiceDB.getAllAziende();
    }

    public Azienda getAzienda(Integer id) {
        return aziendaServiceDB.getAzienda(id);
    }

    public void addAzienda(Azienda azienda) {
        aziendaServiceDB.addAzienda(azienda);
    }

    public void updateAzienda(Integer id, Azienda azienda) {
        aziendaServiceDB.updateAzienda(id,azienda); //in teoria senza id tra parentesi
    }

    public void deleteAzienda(Integer id) {
        aziendaServiceDB.deleteAzienda(id);
    }

}

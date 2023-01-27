package it.unicam.ids.backend.controller;

import it.unicam.ids.backend.entity.Coalizione;
import it.unicam.ids.backend.service.CoalizioneService;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static it.unicam.ids.backend.entity.Coalizione.Stato.ACCETTATA_INATTIVA;

@RestController
public class CoalizioneController {

    private final CoalizioneService coalizioneService;


    public CoalizioneController(CoalizioneService aziendaServiceDB) {
        this.coalizioneService = aziendaServiceDB;
    }


    public List<Coalizione> getAllCoalizioni() {
        return coalizioneService.getAllCoalizioni();
    }

    public Coalizione getCoalizione(Integer id) {
        return coalizioneService.getCoalizione(id);
    }

    public void addCoalizione(Coalizione coalizione) {
        coalizioneService.addCoalizione(coalizione);
    }

    public void updateCoalizione(Coalizione coalizione) {
        coalizioneService.updateCoalizione(coalizione);
    }

    public void deleteCoalizione(Integer id) {
        if (getCoalizione(id).getStato().equals(ACCETTATA_INATTIVA) ||
                getCoalizione(id).getStato().equals(Coalizione.Stato.INATTESA_INATTIVA))
            coalizioneService.deleteCoalizione(id);
        else
            System.out.println("Non puoi eseguire questa operazione");
    }

    /**
     * Determina se la coalizione è nello stato INATTESA_INATTIVA
     * @param id
     * @return true se ci si trova. false altrimenti
     */
    public boolean isInAttesaEAccettabile(Integer id) {
        return getCoalizione(id).getStato().equals(Coalizione.Stato.INATTESA_INATTIVA);
    }

    /**
     * Cambia lo stato della coalizione in ACCETTATA_INATTIVA se è possibile
     * @param id
     */
    public void accettaCoalizione(Integer id) {
        if (isInAttesaEAccettabile(id)) {
            getCoalizione(id).setStato(Coalizione.Stato.ACCETTATA_INATTIVA);
            updateCoalizione(getCoalizione(id));
            //non ho capito come cambia update da add
        }
        else
            System.out.println("Non puoi eseguire questa operazione");
    }

    /**
     * Cambia lo stato della coalizione in RIFIUTATA_INATTIVA se è possibile
     * @param id
     */
    public void rifiutaCoalizione(Integer id) {
        if (isInAttesaEAccettabile(id)) {
            getCoalizione(id).setStato(Coalizione.Stato.RIFIUTATA_INATTIVA);
            updateCoalizione(getCoalizione(id));
            //non ho capito come cambia update da add
        }
        else
            System.out.println("Non puoi eseguire questa operazione");
    }
}
